package com.earyant.web.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Properties;

/**
 * @author xiaowang
 */
public final class ApplicationProperties {
    private static final String resourceName = "/application.properties";
    private static Properties property = new Properties();

    static {
        ApplicationProperties.init();
    }

    /**
     * 初始化
     */
    public static void init() {
        ApplicationProperties.setProperty(PropertiesLoaderUtils.loadUrlProperties(resourceName));
    }

    /**
     * @return Properties
     */
    public static Properties getProperty() {
        if (property == null || property.isEmpty() || property.size() == 0) {
            ApplicationProperties.init();
        }
        return property;
    }

    public static void setProperty(Properties property) {
        ApplicationProperties.property = property;
    }

    /**
     * 获取属性值
     *
     * @param key
     * @return String
     */
    public static String getPropertyValue(String key) {
        if (StringUtils.isEmpty(key)) {
            return "";
        }
        return (String) ApplicationProperties.getProperty().get(key);
    }
}