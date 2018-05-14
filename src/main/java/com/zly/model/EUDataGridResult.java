package com.zly.model;

import java.util.List;

/**
 * Created by zly11 on 2018/4/30.
 */
public class EUDataGridResult {

    private String status;
    private List<?> objectsList;
    private Object object;

    public static EUDataGridResult ok(List<?> ol){
        EUDataGridResult e = new EUDataGridResult();
        e.status = "200";
        e.objectsList = ol;
        return e;
    }

    public static EUDataGridResult ok(Object o){
        EUDataGridResult e = new EUDataGridResult();
        e.status = "200";
        e.object = o;
        return e;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<?> getObjectsList() {
        return objectsList;
    }

    public void setObjectsList(List<?> objectsList) {
        this.objectsList = objectsList;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
