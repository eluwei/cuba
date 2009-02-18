/*
 * Copyright (c) 2008 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.

 * Author: Konstantin Krivopustov
 * Created: 13.02.2009 16:26:58
 *
 * $Id$
 */
package com.haulmont.cuba.gui.config;

import org.dom4j.Element;

public class ScreenInfo
{
    private String id;
    private Element descriptor;
    private Class screenClass;

    public ScreenInfo(String id, Element descriptor) {
        this.id = id;
        this.descriptor = descriptor;
    }

    public String getId() {
        return id;
    }

    public String getTemplate() {
        return descriptor.attributeValue("template");
    }

    public Class getScreenClass() {
        if (screenClass == null) {
            String className = descriptor.attributeValue("class");
            if (className != null)
                try {
                    screenClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
        }

        return screenClass;
    }

    public Element getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(Element descriptor) {
        this.descriptor = descriptor;
    }

    public String toString() {
        String template = getTemplate();
        return "id='" + id + '\'' +
                (template != null ? ", template=" + template : "") +
                (screenClass != null ? ", screenClass=" + screenClass : "");
    }
}
