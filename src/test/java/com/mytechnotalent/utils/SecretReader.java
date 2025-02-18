package com.mytechnotalent.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SecretReader {
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/secret.properties");

            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("Error loading config.properties: " + e.getMessage());
            throw new RuntimeException("Could not read secret.properties file.");
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing or empty property: " + key);
        }

        return value;
    }
}