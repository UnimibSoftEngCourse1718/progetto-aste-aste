package aste.service;

import java.util.List;

import aste.model.Utente;

public interface UtenteService {
	     
	    public void addUser(Utente user);
	 
	    public List<Utente> getAllUsers();
	 
	    public void deleteUser(Integer userId);
	 
	    public Utente getUser(Integer userid);
	 
	    public Utente getUser(String username);
	    
	    public Utente updateUser(Utente user);
	    
	    public Utente getUserLogin(Utente user);
}
