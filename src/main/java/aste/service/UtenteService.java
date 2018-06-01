package aste.service;

import java.util.List;

import aste.model.Utente;

public interface UtenteService {
	     
	    public void addUser(Utente user);
	 
	    public List<Utente> getAllUsers();
	 
	    public void deleteUser(Integer userId);
	 
	    public Utente getUser(int userid);
	 
	    public Utente updateUser(Utente user);
	    
	    public List<Utente> getUserLogin(Utente user);
}
