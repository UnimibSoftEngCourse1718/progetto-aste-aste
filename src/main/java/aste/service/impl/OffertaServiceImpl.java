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

	public void addOfferta(Offerta offerta) throws InterruptedException {
		// Fare il controllo se esiste gia  un'offerta per l'oggetto
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
