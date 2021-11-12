/*
 * Copyright 2017-2018 Matthew David Tamlin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.matthewtamlin.spyglass.processor.core;


import com.google.common.collect.ImmutableSet;
import com.matthewtamlin.spyglass.processor.codegeneration.CompanionGenerator;
import com.matthewtamlin.spyglass.processor.definitions.AnnotationRegistry;
import com.matthewtamlin.spyglass.processor.definitions.CallerDef;
import com.matthewtamlin.spyglass.processor.definitions.CompanionDef;
import com.matthewtamlin.spyglass.processor.grouper.Grouper;
import com.matthewtamlin.spyglass.processor.grouper.TypeElementWrapper;
import com.matthewtamlin.spyglass.processor.validation.BasicValidator;
import com.matthewtamlin.spyglass.processor.validation.Result;
import com.matthewtamlin.spyglass.processor.validation.TypeValidator;
import com.matthewtamlin.spyglass.processor.validation.Validator;
import com.squareup.javapoet.JavaFile;

import javax.annotation.processing.*;
import javax.inject.Inject;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static javax.tools.Diagnostic.Kind.ERROR;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MainProcessor extends AbstractProcessor {
  private static final Set<Class<? extends Annotation>> SUPPORTED_ANNOTATIONS = ImmutableSet
      .<Class<? extends Annotation>>builder()
      .addAll(AnnotationRegistry.CONDITIONAL_HANDLERS)
      .addAll(AnnotationRegistry.UNCONDITIONAL_HANDLERS)
      .addAll(AnnotationRegistry.DEFAULTS)
      .addAll(AnnotationRegistry.PLACEHOLDERS)
      .build();
  
  private static final Set<JavaFile> REQUIRED_FILES = ImmutableSet.of(CallerDef.SRC_FILE, CompanionDef.SRC_FILE);
  
  @Inject
  protected Elements elementUtil;
  
  @Inject
  protected Messager messager;
  
  @Inject
  protected Filer filer;
  
  @Inject
  protected CompanionGenerator companionGenerator;
  
  @Inject
  protected BasicValidator basicValidator;
  
  @Inject
  protected TypeValidator typeValidator;
  
  private boolean allRequiredFilesCreated;
  
  private boolean requiredFilesMissingErrorWritten;
  
  @Override
  public synchronized void init(final ProcessingEnvironment processingEnvironment) {
    super.init(processingEnvironment);
    
    DaggerCoreComponent
        .builder()
        .setProcessingEnvironment(processingEnvironment)
        .build()
        .inject(this);
    
    createRequiredFiles();
  }
  
  @Override
  public Set<String> getSupportedAnnotationTypes() {
    final Set<String> supportedTypes = new HashSet<>();
    
    for (Class<? extends Annotation> clazz : SUPPORTED_ANNOTATIONS) {
      supportedTypes.add(clazz.getCanonicalName());
    }
    
    return supportedTypes;
  }
  
  @Override
  public boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
    if (!allRequiredFilesCreated) {
      if (!requiredFilesMissingErrorWritten) {
        messager.printMessage(ERROR, "A required class could not be created. Aborting Spyglass processing.");
        requiredFilesMissingErrorWritten = true;
      }
      
      return false;
    }
    
    try {
      final Set<ExecutableElement> methods = findMethodsWithSpyglassAnnotations(roundEnv);
      
      if (allElementsPassValidation(methods, basicValidator)) {
        if (allElementsPassValidation(methods, typeValidator)) {
          final Set<TypeElement> targetTypes = findTypesWithSpyglassAnnotations(roundEnv);
          
          for (final TypeElement targetType : targetTypes) {
            createFile(companionGenerator.generateFor(targetType), "Failed to create Spyglass companion class.");
          }
        }
      }
    } catch (final Throwable t) {
      messager.printMessage(
          ERROR,
          String.format(
              "An unknown error occurred while processing Spyglass annotations. Please update to the " +
                  "latest version of Spyglass, or report this issue if a newer version does not " +
                  "exist. Error message: \'%1$s\'. Stacktrace: \'%2$s\'.",
              t.getMessage() == null ? "None." : t.getMessage(),
              Arrays.toString(t.getStackTrace())));
    }
    
    return false;
  }
  
  private void createRequiredFiles() {
    allRequiredFilesCreated = true;
    
    for (final JavaFile requiredFile : REQUIRED_FILES) {
      final String className = requiredFile.packageName + "." + requiredFile.typeSpec.name;
      
      // Spyglass could be applied to a project that uses Spyglass transitively
      final boolean alreadyExists = elementUtil.getTypeElement(className) != null;
      
      if (alreadyExists) {
        allRequiredFilesCreated &= true;
        
      } else {
        allRequiredFilesCreated &= createFile(requiredFile, "Could not create required class: " + className);
      }
    }
  }
  
  private Set<ExecutableElement> findMethodsWithSpyglassAnnotations(final RoundEnvironment roundEnvironment) {
    final Set<ExecutableElement> methods = new HashSet<>();
    
    for (final Class<? extends Annotation> annotationType : SUPPORTED_ANNOTATIONS) {
      for (final Element foundElement : roundEnvironment.getElementsAnnotatedWith(annotationType)) {
        if (foundElement.getKind() == ElementKind.METHOD) {
          methods.add((ExecutableElement) foundElement);
          
        } else if (foundElement.getKind() == ElementKind.PARAMETER) {
          methods.add((ExecutableElement) foundElement.getEnclosingElement());
          
        } else {
          throw new RuntimeException("A Spyglass annotation was found on an illegal element type.");
        }
      }
    }
    
    return methods;
  }
  
  private Set<TypeElement> findTypesWithSpyglassAnnotations(final RoundEnvironment roundEnvironment) {
    final Set<ExecutableElement> methods = findMethodsWithSpyglassAnnotations(roundEnvironment);
    final Map<TypeElementWrapper, Set<ExecutableElement>> typesToMethods = Grouper.groupByEnclosingClass(methods);
    
    final Set<TypeElement> unwrappedTypes = new HashSet<>();
    
    for (final TypeElementWrapper wrappedType : typesToMethods.keySet()) {
      unwrappedTypes.add(wrappedType.unwrap());
    }
    
    return unwrappedTypes;
  }
  
  private boolean allElementsPassValidation(final Set<? extends Element> elements, final Validator validator) {
    boolean allPassed = true;
    
    for (final Element element : elements) {
      // This check should never fail since handler and default annotations are restricted to methods
      if (element.getKind() != ElementKind.METHOD) {
        throw new RuntimeException("A handler or default annotation was found on a non-method element.");
      }
      
      final Result result = validator.validate((ExecutableElement) element);
      
      allPassed &= result.isSuccessful();
      
      if (!result.isSuccessful()) {
        messager.printMessage(ERROR, result.getDescription(), element);
      }
    }
    
    return allPassed;
  }
  
  private boolean createFile(final JavaFile file, final String errorMessage) {
    try {
      file.writeTo(filer);
      
      return true;
      
    } catch (final IOException e) {
      messager.printMessage(ERROR, errorMessage);
      
      return false;
    }
  }
}