package aste.service;

import java.util.List;

import aste.model.User;

public interface UserService {
	     
	    public void addUser(User User);
	 
	    public List<User> getAllUsers();
	 
	    public void deleteUser(Integer UserId);
	 
	    public User getUser(int Userid);
	 
	    public User updateUser(User User);
}
