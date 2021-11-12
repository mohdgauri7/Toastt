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

package com.matthewtamlin.spyglass.integrationtests.annotationcombinations.colorhandler;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import com.matthewtamlin.spyglass.integrationtests.R;
import com.matthewtamlin.spyglass.integrationtests.framework.ReceivedValue;
import com.matthewtamlin.spyglass.markers.annotations.defaults.DefaultToInteger;
import com.matthewtamlin.spyglass.markers.annotations.unconditionalhandlers.ColorHandler;

public class WithDefaultToInteger extends ColorHandlerTestTargetBase {
  public static final int DEFAULT_VALUE = 142970;
  
  public WithDefaultToInteger(final Context context) {
    super(context);
    init(null, 0, 0);
  }
  
  public WithDefaultToInteger(final Context context, final AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0, 0);
  }
  
  public WithDefaultToInteger(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs, defStyleAttr, 0);
  }
  
  @RequiresApi(21)
  @TargetApi(21)
  public WithDefaultToInteger(
      final Context context,
      final AttributeSet attrs,
      final int defStyleAttr,
      final int defStyleRes) {
    
    super(context, attrs, defStyleAttr, defStyleRes);
    init(attrs, defStyleAttr, defStyleRes);
  }
  
  @ColorHandler(attributeId = R.styleable.ColorHandlerTestTargetBase_colorHandlerAttr)
  @DefaultToInteger(DEFAULT_VALUE)
  public void handlerMethod(final int i) {
    setReceivedValue(ReceivedValue.of(i));
  }
  
  private void init(final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
    WithDefaultToInteger_SpyglassCompanion
        .builder()
        .setTarget(this)
        .setContext(getContext())
        .setStyleableResource(R.styleable.ColorHandlerTestTargetBase)
        .setAttributeSet(attrs)
        .setDefaultStyleAttribute(defStyleAttr)
        .setDefaultStyleResource(defStyleRes)
        .build()
        .callTargetMethodsNow();
  }
}