package com.rba.databasehandler.model.entity;

/**
 * Created by Ricardo Bravo on 5/07/16.
 */

public class DemoEntity {

    String id, value;

    public DemoEntity() {
    }

    public DemoEntity(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
