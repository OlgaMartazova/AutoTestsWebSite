package com.example.fanfics.settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    public static String fileDir = "src/test/resources/Settings.xml";
    private static final Properties properties;
    private static String baseURL;
    private static String login;
    private static String password;

    static {
        try (FileInputStream fileInputStream = new FileInputStream(fileDir)) {
            properties = new Properties();
            properties.loadFromXML(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBaseUrl() {
        if (baseURL == null) {
            baseURL = properties.getProperty("baseURL");
        }
        return baseURL;
    }

    public static String getLogin() {
        if (login == null) {
            login = properties.getProperty("login");
        }
        return login;
    }

    public static String getPassword() {
        if (password == null) {
            password = properties.getProperty("password");
        }
        return password;
    }
}
