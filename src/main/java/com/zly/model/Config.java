package com.zly.model;

public class Config {
    private Integer id;

    private String configName;

    private String configValue;

    public Config(Integer id, String configName, String configValue) {
        this.id = id;
        this.configName = configName;
        this.configValue = configValue;
    }

    public Config() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }
}