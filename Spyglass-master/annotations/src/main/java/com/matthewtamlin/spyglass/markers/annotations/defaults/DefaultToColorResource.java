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

package com.matthewtamlin.spyglass.markers.annotations.defaults;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a default for the annotated method, so that the Spyglass framework can invoke the method if its handler
 * annotation is not satisfied. This annotation should only be applied to methods which satisfy all of the following
 * criteria:
 * <ul>
 * <li>The method is a non-static member of an Android View subclass.</li>
 * <li>The method has a handler annotation.</li>
 * <li>The method has no other default annotations.</li>
 * <li>The method has at least one {@code Number} parameter.</li>
 * <li>Except for one {@code Number} parameter, every parameter belonging to the method has a placeholder annotation.</li>
 * </ul>
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface DefaultToColorResource {
  /**
   * @return the resource ID of the default value, must resolve to an color resource
   */
  int resId();
}