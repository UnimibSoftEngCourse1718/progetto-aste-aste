package aste.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.UtenteJpaRepository;
import aste.model.Utente;
import aste.service.UtenteService;

@Service
@Transactional
public class UtenteServiceImpl implements UtenteService{
	
	@Resource
	UtenteJpaRepository userJpaRepository;
	 
	    public void addUser(Utente user) {
	    	userJpaRepository.saveAndFlush(user);
	    }
	 
	    public List<Utente> getAllUsers() {
	        return userJpaRepository.findAll();
	    }
	 
	    public void deleteUser(Integer userId) {
	    	userJpaRepository.delete(userId);
	    }
	 
	    public Utente getUser(Integer empid) {
	        return userJpaRepository.findOne(empid);
	    }
	    
	    public Utente getUser(String username) {
	        return userJpaRepository.findByUsername(username);
	    }
	    
	    public Utente getUserLogin(Utente user) {
	        return userJpaRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	    }
	 
	    public Utente updateUser(Utente user) {
	        return userJpaRepository.saveAndFlush(user);
	    }
}
