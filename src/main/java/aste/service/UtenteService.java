package aste.service;

import java.util.List;

import aste.model.Utente;

public interface UtenteService {
	     
	    public void addUser(Utente User);
	 
	    public List<Utente> getAllUsers();
	 
	    public void deleteUser(Integer UserId);
	 
	    public Utente getUser(int Userid);
	 
	    public Utente updateUser(Utente User);
	    
	    public List<Utente> getUserLogin(Utente user);
}
