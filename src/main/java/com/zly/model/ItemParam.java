package com.zly.model;

/**
 * Created by zly11 on 2018/5/3.
 */
public class ItemParam {


  private ItemParamGroup itemParamGroup;
  private ItemParanKey itemParanKey;
  private ItemParamValue itemParamValue;

    public ItemParamGroup getItemParamGroup() {
        return itemParamGroup;
    }

    public void setItemParamGroup(ItemParamGroup itemParamGroup) {
        this.itemParamGroup = itemParamGroup;
    }

    public ItemParanKey getItemParanKey() {
        return itemParanKey;
    }

    public void setItemParanKey(ItemParanKey itemParanKey) {
        this.itemParanKey = itemParanKey;
    }

    public ItemParamValue getItemParamValue() {
        return itemParamValue;
    }

    public void setItemParamValue(ItemParamValue itemParamValue) {
        this.itemParamValue = itemParamValue;
    }
}
