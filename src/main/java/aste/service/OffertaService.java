package aste.service;

import java.util.List;

import aste.model.Offerta;
import aste.model.Offerta.Stato;
import aste.model.Oggetto;
import aste.model.Utente;

public interface OffertaService {
	     
	    public void addOfferta(Offerta offerta) throws Exception;
	 
	    public List<Offerta> getAllOggetti();
	 
	    public void deleteOfferta(Integer offertaId);
	 
	    public Offerta getOfferta(int offertaId);
	 
	    public Offerta updateOfferta(Offerta offerta);
	    
	    public List<Offerta> findAllOggettoInAsta();
	    
	    public List<Offerta> findAllOfferteByUtente(Utente idUtente);
	    
	    public Offerta findFirstOfferteByOggetto(Oggetto oggetto);
	    
	    public Offerta findFirstByIdOggettoOrderByIdOffertaDesc(Oggetto oggetto);
	    
	    public void deleteByIdOggettoAndStato(Oggetto oggetto,Stato stato);
}
