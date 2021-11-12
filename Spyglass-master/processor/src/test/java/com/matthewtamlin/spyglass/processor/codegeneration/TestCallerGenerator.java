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

package com.matthewtamlin.spyglass.processor.codegeneration;

import com.google.testing.compile.JavaFileObjects;
import com.matthewtamlin.avatar.rules.AvatarRule;
import com.matthewtamlin.spyglass.processor.definitions.AndroidClassNames;
import com.matthewtamlin.spyglass.processor.definitions.CallerDef;
import com.matthewtamlin.spyglass.processor.framework.CompileChecker;
import com.matthewtamlin.spyglass.processor.mirrorhelpers.AnnotationMirrorHelper;
import com.matthewtamlin.spyglass.processor.mirrorhelpers.TypeMirrorHelper;
import com.squareup.javapoet.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.lang.model.element.ExecutableElement;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.mock;

public class TestCallerGenerator {
  @Rule
  public final AvatarRule avatarRule = AvatarRule
      .builder()
      .withSourceFileObjects(JavaFileObjects.forResource(getClass().getResource("TestCallerGeneratorData.java")))
      .build();
  
  private CallerGenerator callerGenerator;
  
  @Before
  public void setup() {
    final AnnotationMirrorHelper annotationMirrorHelper = new AnnotationMirrorHelper(avatarRule.getElementUtils());
    
    callerGenerator = new CallerGenerator(
        avatarRule.getElementUtils(),
        avatarRule.getTypeUtils(),
        new TypeMirrorHelper(avatarRule.getElementUtils(), avatarRule.getTypeUtils()),
        new GetDefaultMethodGenerator(annotationMirrorHelper),
        new GetValueMethodGenerator(annotationMirrorHelper),
        new GetPlaceholderMethodGenerator(annotationMirrorHelper),
        new AnyValueIsAvailableMethodGenerator(annotationMirrorHelper),
        new SpecificValueIsAvailableMethodGenerator(annotationMirrorHelper),
        new CastWrapperGenerator(
            avatarRule.getElementUtils(),
            new TypeMirrorHelper(avatarRule.getElementUtils(), avatarRule.getTypeUtils())));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testGenerateFor_nullMethodSupplied() {
    callerGenerator.generateFor(null, CodeBlock.of(""), CodeBlock.of(""), CodeBlock.of(""));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testGenerateFor_nullContextParameterSupplied() {
    callerGenerator.generateFor(mock(ExecutableElement.class), null, CodeBlock.of(""), CodeBlock.of(""));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testGenerateFor_nullTargetParameterSupplied() {
    callerGenerator.generateFor(mock(ExecutableElement.class), CodeBlock.of(""), null, CodeBlock.of(""));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testGenerateFor_nullAttrsParameterSupplied() {
    callerGenerator.generateFor(mock(ExecutableElement.class), CodeBlock.of(""), CodeBlock.of(""), null);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testGenerateFor_elementWithNoHandlerAnnotation() {
    final ExecutableElement element = avatarRule.getElementWithUniqueId("no handler");
    
    callerGenerator.generateFor(
        element,
        CodeBlock.of("target"),
        CodeBlock.of("context"),
        CodeBlock.of("attrs"));
  }
  
  @Test
  public void testGenerateFor_elementWithConditionalHandler() {
    final ExecutableElement element = avatarRule.getElementWithUniqueId("conditional handler");
    
    final TypeSpec result = callerGenerator.generateFor(
        element,
        CodeBlock.of("target"),
        CodeBlock.of("context"),
        CodeBlock.of("attrs"));
    
    assertThat(result, is(notNullValue()));
    checkCompiles(result);
  }
  
  @Test
  public void testGenerateFor_elementWithUnconditionalHandlerButNoDefault() {
    final ExecutableElement element = avatarRule.getElementWithUniqueId("unconditional handler no default");
    
    final TypeSpec result = callerGenerator.generateFor(
        element,
        CodeBlock.of("target"),
        CodeBlock.of("context"),
        CodeBlock.of("attrs"));
    
    assertThat(result, is(notNullValue()));
    checkCompiles(result);
  }
  
  @Test
  public void testGenerateFor_elementWithUnconditionalHandlerAndDefault() {
    final ExecutableElement element = avatarRule.getElementWithUniqueId("unconditional handler with default");
    
    final TypeSpec result = callerGenerator.generateFor(
        element,
        CodeBlock.of("target"),
        CodeBlock.of("context"),
        CodeBlock.of("attrs"));
    
    assertThat(result, is(notNullValue()));
    checkCompiles(result);
  }
  
  private void checkCompiles(final TypeSpec anonymousTypeSpec) {
    // Anonymous class cannot be top level class, so nest the anonymous class as a field
    final TypeSpec wrapperTypeSpec = TypeSpec
        .classBuilder("Wrapper")
        .addField(FieldSpec
            .builder(
                ClassName.get("com.matthewtamlin.spyglass.processor.codegeneration", "TestCallerGeneratorData"),
                "target")
            .build())
        .addField(FieldSpec.builder(AndroidClassNames.CONTEXT, "context").build())
        .addField(FieldSpec.builder(AndroidClassNames.TYPED_ARRAY, "attrs").build())
        .addField(FieldSpec
            .builder(TypeName.OBJECT, "o")
            .initializer("$L", anonymousTypeSpec)
            .build())
        .build();
    
    final JavaFile wrapperJavaFile = JavaFile
        .builder("", wrapperTypeSpec)
        .build();
    
    final Set<JavaFile> filesToCompile = new HashSet<>();
    
    filesToCompile.add(wrapperJavaFile);
    filesToCompile.add(CallerDef.SRC_FILE);
    
    CompileChecker.checkCompiles(filesToCompile);
  }
}