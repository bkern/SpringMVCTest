package com.bkern.mvc.domain;


public class UserData {

    private String name;
    private String sampleData;
    private int age;
    private int count;
    private USER_ROLES role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSampleData() {
        return sampleData;
    }

    public void setSampleData(String sampleData) {
        this.sampleData = sampleData;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public USER_ROLES getRole() {
        return role;
    }

    public void setRole(USER_ROLES role) {
        this.role = role;
    }

    public static enum USER_ROLES {
        USER,ADMIN
    }
}
