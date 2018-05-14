package com.zly.model;

public class ItemParanKey {
    private Integer id;

    private String paramName;

    private Integer groupId;

    private ItemParamValue itemParamValue;

    public ItemParamValue getItemParamValue() {
        return itemParamValue;
    }

    public void setItemParamValue(ItemParamValue itemParamValue) {
        this.itemParamValue = itemParamValue;
    }

    public ItemParanKey(Integer id, String paramName, Integer groupId) {
        this.id = id;
        this.paramName = paramName;
        this.groupId = groupId;
    }

    public ItemParanKey() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}