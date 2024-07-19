package com.route.basicsc40.model;

public class ContactDM {
    private int imageId;
    private String name;
    private String phoneNumber;

    public ContactDM(int imageId, String name, String phoneNumber) {
        this.imageId = imageId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
