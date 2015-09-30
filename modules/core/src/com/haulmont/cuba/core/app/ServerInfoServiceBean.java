/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/license for details.
 */
package com.haulmont.cuba.core.app;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.core.global.ViewNotFoundException;
import com.haulmont.cuba.core.global.ViewRepository;
import com.haulmont.cuba.core.sys.AbstractViewRepository;
import com.haulmont.cuba.core.sys.MetadataBuildSupport;

import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.util.List;
import java.util.TimeZone;

/**
 * Standard implementation of {@link ServerInfoService} interface.
 *
 * <p>Annotated with <code>@Component</code> instead of <code>@Service</code> to be available before user login.</p>
 *
 * @author krivopustov
 * @version $Id$
 */
@Component(ServerInfoService.NAME)
public class ServerInfoServiceBean implements ServerInfoService {

    @Inject
    protected ViewRepository viewRepository;

    @Inject
    protected ServerInfoAPI serverInfo;

    @Inject
    private MetadataBuildSupport metadataBuildSupport;

    @Inject
    protected TimeSource timeSource;

    @Override
    public String getReleaseNumber() {
        return serverInfo.getReleaseNumber();
    }

    @Override
    public String getReleaseTimestamp() {
        return serverInfo.getReleaseTimestamp();
    }

    @Override
    public List<View> getViews() {
        return ((AbstractViewRepository) viewRepository).getAll();
    }

    @Override
    public View getView(Class<? extends Entity> entityClass, String name) {
        try {
            return viewRepository.getView(entityClass, name);
        } catch (ViewNotFoundException e) {
            return null;
        }
    }

    @Override
    public TimeZone getTimeZone() {
        return TimeZone.getDefault();
    }

    @Override
    public long getTimeMillis() {
        return timeSource.currentTimeMillis();
    }
}
