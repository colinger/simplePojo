/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package uk.me.jeffsutton.pojogen;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.jsonschema2pojo.AbstractAnnotator;

/**
 * @author gxy23996
 * @version $Id: XStreamAnnotator.java, v0.1 2017/7/7 gxy23996 Exp $$
 */
public class XStreamAnnotator extends AbstractAnnotator {
    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        field.annotate(XStreamAlias.class).param("value", captureName(propertyName));
    }

    private String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }
}
