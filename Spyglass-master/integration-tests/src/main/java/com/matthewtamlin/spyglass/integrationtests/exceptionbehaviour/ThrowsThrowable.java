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

package com.matthewtamlin.spyglass.integrationtests.exceptionbehaviour;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import com.matthewtamlin.spyglass.integrationtests.R;
import com.matthewtamlin.spyglass.markers.annotations.defaults.DefaultToString;
import com.matthewtamlin.spyglass.markers.annotations.unconditionalhandlers.StringHandler;

@SuppressWarnings({"ThrowableInstanceNeverThrown", "UnusedParameters"})
public class ThrowsThrowable extends ExceptionBehaviourTestTargetBase {
  private static final Throwable THROWABLE = new Throwable("test");
  
  public ThrowsThrowable(final Context context) {
    super(context);
    init(null, 0, 0);
  }
  
  public ThrowsThrowable(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0, 0);
  }
  
  public ThrowsThrowable(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs, defStyleAttr, 0);
  }
  
  @RequiresApi(21)
  @TargetApi(21)
  public ThrowsThrowable(
      final Context context,
      final AttributeSet attrs,
      final int defStyleAttr,
      final int defStyleRes) {
    
    super(context, attrs, defStyleAttr, defStyleRes);
    init(attrs, defStyleAttr, defStyleRes);
  }
  
  public static Throwable getExpectedThrowable() {
    return THROWABLE;
  }
  
  @StringHandler(attributeId = R.styleable.ExceptionBehaviourTestTargetBase_exceptionAttr)
  @DefaultToString("test string")
  public void handlerMethod(final String s) throws Throwable {
    throw THROWABLE;
  }
  
  private void init(final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
    ThrowsThrowable_SpyglassCompanion
        .builder()
        .setTarget(this)
        .setContext(getContext())
        .setStyleableResource(R.styleable.ExceptionBehaviourTestTargetBase)
        .setAttributeSet(attrs)
        .setDefaultStyleAttribute(defStyleAttr)
        .setDefaultStyleResource(defStyleRes)
        .build()
        .callTargetMethodsNow();
  }
}