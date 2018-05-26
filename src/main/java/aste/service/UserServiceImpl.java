package aste.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aste.model.User;
import aste.dao.UserDAO;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	 	@Autowired
	    private UserDAO UserDAO;
	 
	    public void addUser(User User) {
	        UserDAO.addUser(User);
	    }
	 
	    public List<User> getAllUsers() {
	        return UserDAO.getAllUsers();
	    }
	 
	    public void deleteUser(Integer UserId) {
	        UserDAO.deleteUser(UserId);
	    }
	 
	    public User getUser(int empid) {
	        return UserDAO.getUser(empid);
	    }
	 
	    public User updateUser(User User) {
	        // TODO Auto-generated method stub
	        return UserDAO.updateUser(User);
	    }
	 
	    public void setUserDAO(UserDAO UserDAO) {
	        this.UserDAO = UserDAO;
	    }
}
