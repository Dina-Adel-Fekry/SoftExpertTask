package com.example.softexpertdemo.Model;

import java.util.List;

public class Object {
    private int status;
    private List<Car> data;

    public Object(int status, List<Car> data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }
}
