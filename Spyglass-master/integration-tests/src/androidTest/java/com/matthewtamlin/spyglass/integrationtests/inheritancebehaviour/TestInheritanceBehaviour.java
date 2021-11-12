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

package com.matthewtamlin.spyglass.integrationtests.inheritancebehaviour;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.matthewtamlin.spyglass.integrationtests.framework.ReceivedValue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class TestInheritanceBehaviour {
  @Rule
  public final UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();
  
  private Context context;
  
  @Before
  public void setup() {
    context = InstrumentationRegistry.getTargetContext();
  }
  
  @Test
  @UiThreadTest
  public void testSuperclassInstantiationTriggersSuperclassSpyglass() {
    final Superclass s = new Superclass(context);
    
    assertThat(s.getSuperclassReceivedValue(), is(ReceivedValue.of(Superclass.EXPECTED_VALUE)));
  }
  
  @Test
  @UiThreadTest
  public void testSubclassInstantiationTriggersSuperclassSpyglass() {
    final Subclass s = new Subclass(context);
    
    assertThat(s.getSuperclassReceivedValue(), is(ReceivedValue.of(Superclass.EXPECTED_VALUE)));
  }
  
  @Test
  @UiThreadTest
  public void testSubclassInstantiationTriggersSubclassSpyglass() {
    final Subclass s = new Subclass(context);
    
    assertThat(s.getSubclassReceivedValue(), is(ReceivedValue.of(Subclass.EXPECTED_VALUE)));
  }
}