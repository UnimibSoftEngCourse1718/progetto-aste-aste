package aste.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aste.jparepository.OffertaJpaRepository;
import aste.model.Offerta;
import aste.model.Offerta.Stato;
import aste.model.Oggetto;
import aste.model.Utente;
import aste.service.OffertaService;
import aste.service.UtenteService;

@Service
@Transactional
public class OffertaServiceImpl implements OffertaService {

	@Resource
	OffertaJpaRepository offertaJpaRepository;
	
	@Autowired
	UtenteService utenteService;

	public void addOfferta(Offerta offerta){
		
		// Prendere l'offerta maggiore relativa all'oggetto in esame
		Offerta currentOfferta = offertaJpaRepository.findFirstByIdOggettoOrderByIdOffertaDesc(offerta.getIdOggetto());

		if (currentOfferta != null) {
			// Esiste già un'offerta per quell'oggetto.
			// Controllo quale tra le due offerte piu alta.
			if (currentOfferta.getImporto() < offerta.getImporto()){
				offertaJpaRepository.saveAndFlush(offerta);
				Utente utente = offerta.getIdUtente();
				utente.setCredito(utente.getCredito() - offerta.getImporto());
				utenteService.updateUser(utente);
				List<Offerta> listOfferte = offertaJpaRepository.findByIdOggettoOrderByIdOffertaDesc(offerta.getIdOggetto());
				Offerta offerta2 = listOfferte.get(1);
				Utente utente2 = offerta2.getIdUtente();
				utente2.setCredito(utente2.getCredito() + offerta2.getImporto());
				utenteService.updateUser(utente2);
			}
			else
				throw new IllegalArgumentException("L'importo deve essere maggiore all'offerta corrente!");

		} else{
			offertaJpaRepository.saveAndFlush(offerta);
			Utente utente = offerta.getIdUtente();
			utente.setCredito(utente.getCredito() - offerta.getImporto());
			utenteService.updateUser(utente);
		}
			
		
	}

	public List<Offerta> getAllOggetti() {
		return offertaJpaRepository.findAll();
	}

	public void deleteOfferta(Integer offertaId) {
		offertaJpaRepository.delete(offertaId);
	}

	public Offerta getOfferta(int offertaId) {
		return offertaJpaRepository.getOne(offertaId);
	}

	public Offerta updateOfferta(Offerta offerta) {
		return offertaJpaRepository.saveAndFlush(offerta);
	}

	public List<Offerta> findAllOggettoInAsta() {
		return offertaJpaRepository.findByStato(Stato.ATTIVO);
	}

	public List<Offerta> findAllOfferteByUtente(Utente idUtente) {
		return offertaJpaRepository.findByIdUtente(idUtente);
	}
	
	public List<Offerta> findAllOggettiVinti(Utente idUtente, Stato stato) {
		return offertaJpaRepository.findByIdUtenteAndStato(idUtente, stato);
	}

	public Offerta findFirstOfferteByOggetto(Oggetto oggetto) {
		return offertaJpaRepository.findFirstByIdOggettoOrderByIdOfferta(oggetto);
	}

	public Offerta findFirstByIdOggettoOrderByIdOffertaDesc(Oggetto oggetto) {
		return offertaJpaRepository.findFirstByIdOggettoOrderByIdOffertaDesc(oggetto);
	}

	public void deleteByIdOggettoAndStato(Oggetto oggetto, Stato stato) {
		offertaJpaRepository.deleteByIdOggettoAndStato(oggetto, stato);		
	}
	
	
	
}
