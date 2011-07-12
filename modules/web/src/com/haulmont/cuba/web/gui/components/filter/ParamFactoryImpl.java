/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.cuba.web.gui.components.filter;

import com.haulmont.chile.core.model.MetaProperty;
import com.haulmont.cuba.gui.components.filter.ParamFactory;
import com.haulmont.cuba.gui.data.Datasource;

import java.util.UUID;

/**
 * <p>$Id$</p>
 *
 * @author devyatkin
 */
public class ParamFactoryImpl implements ParamFactory<Param> {

    @Override
    public Param createParam(String name, Class javaClass, String entityWhere, String entityView, Datasource datasource,
                             boolean inExpr) {
        return new Param(name, javaClass, entityWhere, entityView, datasource, inExpr);
    }

    @Override
    public Param createParam(String name, Class javaClass, String entityWhere, String entityView, Datasource datasource,
                             boolean inExpr, UUID categoryAttrId) {
        return new Param(name, javaClass, entityWhere, entityView, datasource, inExpr, categoryAttrId);
    }

    @Override
    public Param createParam(String name, Class javaClass, String entityWhere, String entityView, Datasource datasource,
                             MetaProperty property, boolean inExpr) {
        return new Param(name, javaClass, entityWhere, entityView, datasource, property, inExpr);
    }
}
