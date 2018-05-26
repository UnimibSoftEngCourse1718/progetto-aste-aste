package aste.dao;

import java.util.List;

import aste.model.User;
 
public interface UserDAO {
 
    public void addUser(User User);
 
    public List<User> getAllUsers();
 
    public void deleteUser(Integer UserId);
 
    public User updateUser(User User);
 
    public User getUser(int Userid);
}