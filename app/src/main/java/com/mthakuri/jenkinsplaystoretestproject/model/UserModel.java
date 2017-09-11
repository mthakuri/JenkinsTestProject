package com.mthakuri.jenkinsplaystoretestproject.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mthakuri on 9/11/2017.
 */

public class UserModel {

    private String id;
    @SerializedName("username")
    private String userName;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("profile_image")
    private UserPictureUrlModel profileImages;

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserPictureUrlModel getProfileImages() {
        return profileImages;
    }
}
