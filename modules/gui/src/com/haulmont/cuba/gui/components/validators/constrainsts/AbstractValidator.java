/*
 * Copyright (c) 2008-2019 Haulmont.
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

package com.haulmont.cuba.gui.components.validators.constrainsts;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.validators.constrainsts.tools.*;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.function.Consumer;

public abstract class AbstractValidator<T> implements Consumer<T> {

    protected Messages messages = AppBeans.get(Messages.NAME);

    protected String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Nullable
    protected NumberConstraint getNumberConstraint(Number value) {
        Class clazz = value.getClass();
        if (clazz.equals(Integer.class)) {
            return new IntegerConstraint(value.intValue());
        } else if (clazz.equals(Long.class) && value.longValue() <= 0) {
            return new LongConstraint(value.longValue());
        } else if (clazz.equals(BigDecimal.class)) {
            return new BigDecimalConstraint((BigDecimal) value);
        } else if (clazz.equals(Double.class)) {
            return new DoubleConstraint(value.doubleValue());
        }
        return null;
    }

    protected void checkPositiveValue(long value, String message) {
        if (value < 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
