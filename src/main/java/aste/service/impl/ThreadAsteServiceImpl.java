package aste.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aste.model.Offerta;
import aste.model.Offerta.Stato;
import aste.model.Oggetto;
import aste.service.OffertaService;
import aste.service.ThreadAsteService;

@Service
public class ThreadAsteServiceImpl implements ThreadAsteService {

	@Autowired
	OffertaService offertaService;
	
	public void runThread(Oggetto oggetto) throws InterruptedException {
		Thread.sleep(oggetto.getTempoAsta()*60*1000);
		Offerta offerta = offertaService.findFirstByIdOggettoOrderByIdOffertaDesc(oggetto);
		offerta.setStato(Stato.VENDUTO);
		offertaService.updateOfferta(offerta);
		offertaService.deleteByIdOggettoAndStato(oggetto, Stato.ATTIVO);
	}

}
