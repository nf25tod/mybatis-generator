package com.nextxworkroom.mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * Created by lscm on 16/6/8.
 */
public class CommonPlugin extends PluginAdapter{

    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("java.lang.String"));
        method.setName("toString");
        String bodyLine = "return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);";
        method.addBodyLine(bodyLine);
        topLevelClass.addMethod(method);
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.apache.commons.lang.builder.ToStringBuilder"));
        topLevelClass.addImportedType(new FullyQualifiedJavaType("org.apache.commons.lang.builder.ToStringStyle"));
        return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
    }
}
