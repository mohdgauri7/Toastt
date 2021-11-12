package com.matthewtamlin.spyglass.processor.definitions;

import com.squareup.javapoet.ClassName;

/**
 * Definitions for observable types from RxJava 2.
 */
public class RxJavaClassNames {
  public static final ClassName OBSERVABLE = ClassName.get("io.reactivex", "Observable");
  
  public static final ClassName SINGLE = ClassName.get("io.reactivex", "Single");
  
  public static final ClassName MAYBE = ClassName.get("io.reactivex", "Maybe");
  
  public static final ClassName COMPLETABLE = ClassName.get("io.reactivex", "Completable");
  
  public static final ClassName FLOWABLE = ClassName.get("io.reactivex", "Flowable");
}