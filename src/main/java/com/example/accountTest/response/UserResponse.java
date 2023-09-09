package com.example.accountTest.response;

public class UserResponse {

    public int id;
    public String message;
    public Boolean status;
    public String firstName;
    public String lastName;
    public String address;
    public String email;

    public UserResponse(String message, Boolean status,int id, String firstName, String lastName, String address, String email) {
        this.message = message;
        this.status = status;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    public UserResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}
