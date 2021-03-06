/**
 *
 *
 * Copyright (c) 2010 / 2011 eZuce, Inc. All rights reserved.
 * Contributed to SIPfoundry under a Contributor Agreement
 *
 * This software is free software; you can redistribute it and/or modify it under
 * the terms of the Affero General Public License (AGPL) as published by the
 * Free Software Foundation; either version 3 of the License, or (at your option)
 * any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 */
package org.sipfoundry.sipxconfig.freeswitch;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.sipfoundry.sipxconfig.common.BeanWithId;
import org.sipfoundry.sipxconfig.common.NamedObject;
import org.sipfoundry.sipxconfig.search.IndexedBean;

public class FreeswitchCondition extends BeanWithId implements NamedObject, IndexedBean {

    private String m_field;
    private String m_expression;
    private boolean m_regex;
    private Set<FreeswitchAction> m_actions = new LinkedHashSet<FreeswitchAction>();

    public String getField() {
        return m_field;
    }

    public void setField(String field) {
        m_field = field;
    }

    public String getExpression() {
        return m_expression;
    }

    public void setExpression(String expression) {
        m_expression = expression;
    }

    public Set<FreeswitchAction> getActions() {
        return m_actions;
    }

    public void setActions(Set<FreeswitchAction> actions) {
        m_actions = actions;
    }

    public void addAction(FreeswitchAction action) {
        if (action != null) {
            m_actions.add(action);
        }
    }

    public void removeAction(FreeswitchAction action) {
        if (action != null) {
            m_actions.remove(action);
        }
    }

    public String getExtension() {
        return StringUtils.removeEnd(StringUtils.removeStart(m_expression, "^"), "$");
    }

    public String getEscapedExpression() {
        if (isRegex()) {
            return m_expression;
        }
        return m_expression.replaceAll("[\\*]", "\\\\\\*");
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(m_field).append(m_expression).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof FreeswitchCondition)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        FreeswitchCondition bean = (FreeswitchCondition) other;
        return new EqualsBuilder().append(m_field, bean.m_field).append(m_expression, bean.m_expression).isEquals();
    }

    public boolean isRegex() {
        return m_regex;
    }

    public void setRegex(boolean regex) {
        m_regex = regex;
    }

    @Override
    public String getName() {
        return getExtension();
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public Set<String> getIndexValues() {
        Set<String> values = new HashSet<String>();
        values.add(getExtension());
        return values;
    }
}
