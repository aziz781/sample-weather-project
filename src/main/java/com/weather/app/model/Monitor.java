package com.weather.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by abdulaziz on 27/06/2016.
 */
@Document(collection = "Monitor")
public class Monitor {

    private String id;
    private String name;
    private String status;
    private Integer count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}


