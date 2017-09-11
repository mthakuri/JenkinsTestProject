package com.mthakuri.jenkinsplaystoretestproject.model;

/**
 * Created by mthakuri on 9/11/2017.
 */

public class PictureModel {

    private String id;
    private UserModel user;
    private PictureUrlModel urls;

    public String getId() {
        return id;
    }

    public UserModel getUser() {
        return user;
    }

    public PictureUrlModel getUrls() {
        return urls;
    }
}
