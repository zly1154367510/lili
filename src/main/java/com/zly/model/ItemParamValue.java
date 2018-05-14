package com.zly.model;

public class ItemParamValue extends ItemParamValueKey {
    private String paramValue;

    public ItemParamValue(Long itemId, Integer paramId, String paramValue) {
        super(itemId, paramId);
        this.paramValue = paramValue;
    }

    public ItemParamValue() {
        super();
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }
}