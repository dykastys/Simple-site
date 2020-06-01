package ru.kushnarev.models.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PasswordContainer {
    private static final Map<String,String> logins = new ConcurrentHashMap<>();

    public static Map<String, String> getLogins() {
        return logins;
    }
}
