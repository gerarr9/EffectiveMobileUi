package org.example.utils.config;

public enum ConfigData {

    BASE_URL {
        public String getValue() {
            return ConfigReader.getConfigProperty("saucedemo.url");
        }
    },
    INVENTORY {
        public String getValue() {
            return ConfigReader.getConfigProperty("saucedemo.inventory");
        }
    },
    LOGIN {
        public String getValue() {
            return ConfigReader.getConfigProperty("login");
        }
    },
    LOCKED_USER {
        public String getValue() {
            return ConfigReader.getConfigProperty("login.locked");
        }
    },
    GLITCH_USER {
        public String getValue() {
            return ConfigReader.getConfigProperty("login.glitch");
        }
    },
    PASSWORD {
        public String getValue() {
            return ConfigReader.getConfigProperty("password");
        }
    };


    public abstract String getValue();

    @Override
    public String toString() {
        return this.getValue();
    }
}
