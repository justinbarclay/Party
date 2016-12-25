package com.example.justin.myapplication;

/**
 * Created by Justin on 2016-12-25.
 */

public class Part {
    String name;
    String location;
    String count;

    Part(String name, String location, String count){
        this.name = name;
        this.location = location;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n Location: " + location + "\n Count: " + count;
    }
}
