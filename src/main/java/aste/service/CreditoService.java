package aste.service;

import java.util.List;

import aste.model.Credito;

public interface CreditoService {
	     
	    public void addCredito(Credito credito);
	 
	    public List<Credito> findAllCredito();
	 	
	    public Credito getCredito(int creditoId); 
}
