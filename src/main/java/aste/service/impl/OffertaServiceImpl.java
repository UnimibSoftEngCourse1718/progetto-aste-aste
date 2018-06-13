package aste.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.OffertaJpaRepository;
import aste.model.Offerta;
import aste.model.Offerta.Stato;
import aste.model.Oggetto;
import aste.model.Utente;
import aste.service.OffertaService;

@Service
@Transactional
public class OffertaServiceImpl implements OffertaService {

	@Resource
	OffertaJpaRepository offertaJpaRepository;

	public void addOfferta(Offerta offerta) throws Exception {
		
		// Prendere l'offerta maggiore relativa all'oggetto in esame
		Offerta currentOfferta = offertaJpaRepository.findFirstByIdOggettoOrderByIdOffertaDesc(offerta.getIdOggetto());

		if (currentOfferta != null) {
			// Esiste già un'offerta per quell'oggetto.
			// Controllo quale tra le due offerte è la più alta.
			if (currentOfferta.getImporto() < offerta.getImporto()) 
				offertaJpaRepository.saveAndFlush(offerta);
			else
				throw new Exception("L'importo deve essere maggiore all'offerta corrente!");

		} else
			offertaJpaRepository.saveAndFlush(offerta);
		
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

	public Offerta findFirstOfferteByOggetto(Oggetto oggetto) {
		return offertaJpaRepository.findFirstByIdOggettoOrderByIdOfferta(oggetto);
	}

	public Offerta findFirstByIdOggettoOrderByIdOffertaDesc(Oggetto oggetto) {
		return offertaJpaRepository.findFirstByIdOggettoOrderByIdOffertaDesc(oggetto);
	}
	
	
	
}
