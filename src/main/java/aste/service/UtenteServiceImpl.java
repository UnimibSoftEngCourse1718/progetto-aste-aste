package aste.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.UtenteJpaRepository;
import aste.model.Utente;

@Service
@Transactional
public class UtenteServiceImpl implements UtenteService{
	
	@Resource
	UtenteJpaRepository userJpaRepository;
	 
	    public void addUser(Utente User) {
	    	userJpaRepository.saveAndFlush(User);
	    }
	 
	    public List<Utente> getAllUsers() {
	        return userJpaRepository.findAll();
	    }
	 
	    public void deleteUser(Integer UserId) {
	    	userJpaRepository.delete(UserId);
	    }
	 
	    public Utente getUser(int empid) {
	        return userJpaRepository.getOne(empid);
	    }
	    
	    public List<Utente> getUserLogin(Utente user) {
	        return userJpaRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	    }
	 
	    public Utente updateUser(Utente User) {
	        // TODO Auto-generated method stub
	        return userJpaRepository.saveAndFlush(User);
	    }
}
