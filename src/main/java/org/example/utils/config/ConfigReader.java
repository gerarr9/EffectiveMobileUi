package org.example.utils.config;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static final Properties properties = new Properties();

    public static void readProperties() {
        if (properties.isEmpty()) {
            try {
                properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
            } catch (IOException e) {
                throw new RuntimeException("Файл не найден");
            }
        }
    }

    public static String getConfigProperty(String key) {
        return properties.getProperty(key);
    }
}
