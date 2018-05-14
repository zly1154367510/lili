package com.zly.model;

import java.util.List;

public class ItemParamGroup {
    private Integer id;

    private String groupName;
    private Long itemCatId;
    private List<ItemParanKey> itemParanKeyList;
    public ItemParamGroup(Integer id, String groupName, Long itemCatId) {
        this.id = id;
        this.groupName = groupName;
        this.itemCatId = itemCatId;
    }

    public List<ItemParanKey> getItemParanKeyList() {
        return itemParanKeyList;
    }

    public void setItemParanKeyList(List<ItemParanKey> itemParanKeyList) {
        this.itemParanKeyList = itemParanKeyList;
    }

    public ItemParamGroup() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }
}