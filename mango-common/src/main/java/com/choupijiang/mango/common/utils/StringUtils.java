package com.choupijiang.mango.common.utils;

public class StringUtils {
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }
}
