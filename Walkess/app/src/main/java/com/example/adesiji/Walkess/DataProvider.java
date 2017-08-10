package com.example.adesiji.Walkess;

/**
 * Created by adesiji on 28/11/2015.
 */
public class DataProvider {
    private  String name;
    private String address;
    private  String mob;
    private  String email;
    private String date;
    private String time;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DataProvider(String name,String address, String mob, String email, String date,  String time, String id)
    {
        this.name = name;
        this.address = address;
        this.mob = mob;
        this.email = email;
        this.date = date;
        this.time = time;
        this.id = id;

    }

}
