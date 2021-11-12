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

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import com.google.testing.compile.JavaFileObjects;
import com.matthewtamlin.avatar.rules.AvatarRule;
import com.matthewtamlin.spyglass.markers.annotations.unconditionalhandlers.*;
import com.matthewtamlin.spyglass.processor.definitions.CallerDef;
import com.matthewtamlin.spyglass.processor.framework.CompileChecker;
import com.matthewtamlin.spyglass.processor.mirrorhelpers.AnnotationMirrorHelper;
import com.squareup.javapoet.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import java.util.HashSet;
import java.util.Set;

import static javax.lang.model.element.Modifier.STATIC;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class TestGetValueMethodGenerator {
  @Rule
  public final AvatarRule avatarRule = AvatarRule
      .builder()
      .withSourceFileObjects(JavaFileObjects.forResource(getClass().getResource("TestGetValueMethodGeneratorData.java")))
      .build();
  
  private GetValueMethodGenerator generator;
  
  @Before
  public void setup() {
    generator = new GetValueMethodGenerator(new AnnotationMirrorHelper(avatarRule.getElementUtils()));
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor_nullCoreHelpers() {
    new GetValueMethodGenerator(null);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testGenerateFor_nullSupplied() {
    generator.generateFor(null);
  }
  
  @Test
  public void testGenerateFor_booleanHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("boolean");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, BooleanHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, TypeName.BOOLEAN.box());
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_colorHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("color");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, ColorHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(Number.class));
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_colorStateListHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("color state list");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(
        element,
        ColorStateListHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(ColorStateList.class));
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_dimensionHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("dimension");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, DimensionHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(Number.class));
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_drawableHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("drawable");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, DrawableHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(Drawable.class));
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_enumConstantHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("enum constant");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, EnumConstantHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(PlaceholderEnum.class));
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_EnumOrdinalHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("enum ordinal");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, EnumOrdinalHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(Number.class));
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_floatHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("float");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, FloatHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(Number.class));
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_fractionHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("fraction");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, FractionHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(Number.class));
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_integerHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("integer");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, IntegerHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(Number.class));
    checkCompiles(generatedMethod);
  }
  
  @Test
  public void testGenerateFor_stringHandlerAnnotationSupplied() {
    final Element element = avatarRule.getElementWithUniqueId("string");
    final AnnotationMirror mirror = AnnotationMirrorHelper.getAnnotationMirror(element, StringHandler.class);
    
    final MethodSpec generatedMethod = generator.generateFor(mirror);
    
    checkSignature(generatedMethod, ClassName.get(String.class));
    checkCompiles(generatedMethod);
  }
  
  private void checkSignature(final MethodSpec generatedMethod, final TypeName returnType) {
    assertThat("Generated method must not be null.", generatedMethod, is(notNullValue()));
    assertThat("Generated method has wrong return type.", generatedMethod.returnType, is(returnType));
    assertThat("Generated method has wrong number of parameters.", generatedMethod.parameters.size(), is(0));
    assertThat("Generated method must not be static.", generatedMethod.modifiers.contains(STATIC), is(false));
  }
  
  private void checkCompiles(final MethodSpec method) {
    final TypeSpec wrapperTypeSpec = CallerDef
        .getNewCallerSubclassPrototype("Wrapper", TypeName.OBJECT)
        .addMethod(CallerDef
            .getNewCallMethodPrototype()
            .addCode(CodeBlock.of("return null;"))
            .build())
        .addMethod(CallerDef.getNewConstructorPrototype(TypeName.OBJECT).build())
        .addMethod(method)
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