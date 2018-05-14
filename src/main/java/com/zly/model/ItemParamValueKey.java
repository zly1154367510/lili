package com.zly.model;

public class ItemParamValueKey {
    private Long itemId;

    private Integer paramId;

    public ItemParamValueKey(Long itemId, Integer paramId) {
        this.itemId = itemId;
        this.paramId = paramId;
    }

    public ItemParamValueKey() {
        super();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }
}