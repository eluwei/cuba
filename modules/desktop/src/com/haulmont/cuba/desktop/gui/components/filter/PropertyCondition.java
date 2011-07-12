/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.cuba.desktop.gui.components.filter;

import com.haulmont.cuba.gui.components.filter.AbstractConditionDescriptor;
import com.haulmont.cuba.gui.components.filter.AbstractPropertyCondition;
import com.haulmont.cuba.gui.components.filter.ParamFactory;
import com.haulmont.cuba.gui.data.Datasource;
import org.dom4j.Element;

/**
 * <p>$Id$</p>
 *
 * @author devyatkin
 */
public class PropertyCondition extends AbstractPropertyCondition<Param> {
    public PropertyCondition(Element element, String messagesPack, String filterComponentName, Datasource datasource) {
        super(element, messagesPack, filterComponentName, datasource);
    }

    public PropertyCondition(AbstractConditionDescriptor descriptor, String entityAlias) {
        super(descriptor, entityAlias);
    }

    @Override
    public OperationEditor createOperationEditor() {
        return new PropertyOperationEditor(this);
    }

    @Override
    protected ParamFactory getParamFactory() {
        return new ParamFactoryImpl();
    }
}
