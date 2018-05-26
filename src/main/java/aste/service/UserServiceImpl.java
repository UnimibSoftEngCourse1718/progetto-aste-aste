package aste.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.UserJpaRepository;
import aste.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	UserJpaRepository userJpaRepository;
	 
	    public void addUser(User User) {
	    	userJpaRepository.saveAndFlush(User);
	    }
	 
	    public List<User> getAllUsers() {
	        return userJpaRepository.findAll();
	    }
	 
	    public void deleteUser(Integer UserId) {
	    	userJpaRepository.delete(UserId);
	    }
	 
	    public User getUser(int empid) {
	        return userJpaRepository.getOne(empid);
	    }
	    
	    public List<User> getUserLogin(User user) {
	        return userJpaRepository.findByFirstNameAndLastName(user.getFirstName(),user.getLastName());
	    }
	 
	    public User updateUser(User User) {
	        // TODO Auto-generated method stub
	        return userJpaRepository.saveAndFlush(User);
	    }
}
