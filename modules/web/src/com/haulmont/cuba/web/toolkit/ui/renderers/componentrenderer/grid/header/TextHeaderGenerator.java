/*
 * Licensed under the Apache License,Version2.0(the"License");you may not
 * use this file except in compliance with the License.You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,software
 * distributed under the License is distributed on an"AS IS"BASIS,WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND,either express or implied.See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.haulmont.cuba.web.toolkit.ui.renderers.componentrenderer.grid.header;

/**
 * Typed lambda-compatible interface to generate html grid headers.
 *
 * @author Jonas Hahn (jonas.hahn@datenhahn.de)
 */
public interface TextHeaderGenerator extends HeaderGenerator<String> {

    @Override
    String getHeader(Object propertyId);
}
