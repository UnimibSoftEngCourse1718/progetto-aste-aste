package aste.service;

import aste.model.User;

public class UserService {

    public User getDefaultUser() {
    	
        User user = new User();
        user.setFirstName("Schifo");
        user.setLastName("DoeFromREST");
        return user;
    }
}