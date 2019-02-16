/*
 * Copyright (c) 2018 - Manifold Systems LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package manifold.ext.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declare a structural interface using this annotation.
 * <p/>
 * See the <a href="http://manifold.systems/docs.html#structural-interfaces">Structural Interfaces</a>
 * documentation for more information.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Structural
{
  /**
   * Optional.
   * <p/>
   * A factory class that produces a class given a class extending {@code backingClass} and the structural interface to
   * proxy.  The factory class must provide a public default constructor and must implement {@link IProxyFactory}.
   * <p/>
   * Note the factory class is optional and exists primarily to address performance when the first time a type is cast
   * to a structural interface.  If a factory class is <i>not</i> provided, Manifold dynamically generates and compiles
   * one at runtime, which entails a significant first-time performance hit.  Thus a compile-time proxy factory provides
   * a way to eliminate this performance hit if and when needed.
   */
  Class factoryClass() default Void.class;

  /**
   * Optional.
   * <p/>
   * The base type of the object the proxy will wrap. This parameter is only relevant for structural interfaces that
   * provide a {@code factoryClass} parameter.
   */
  Class backingClass() default Void.class;
}
