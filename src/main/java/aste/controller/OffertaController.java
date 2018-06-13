package aste.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aste.model.Offerta;
import aste.model.Oggetto;
import aste.model.Utente;
import aste.service.OffertaService;
import aste.service.UtenteService;
import aste.utils.Constants;
import aste.utils.ResponseObj;

@RestController
@RequestMapping("offerta")
public class OffertaController {

	@Autowired
	OffertaService offertaService;
	
	@Autowired
	UtenteService utenteService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<Offerta> save(@RequestBody Offerta offerta) throws Exception {
		ResponseObj<Offerta> response = new ResponseObj<Offerta>();
		offertaService.addOfferta(offerta);
		response.setEsito(Constants.OK);
		response.setData(offerta);
        return response;
    }
	
	@RequestMapping(value = "/findAllOggettoInAsta", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public ResponseObj<List<Oggetto>> findAllOggettoInAsta() {
		
		ResponseObj<List<Oggetto>> response = new ResponseObj<List<Oggetto>>();
		List<Offerta> offerte = offertaService.findAllOggettoInAsta();
		List<Oggetto> oggettiInAsta = new ArrayList<Oggetto>();
		
		for(Offerta offerta : offerte)
			oggettiInAsta.add(offerta.getIdOggetto());
		response.setEsito(Constants.OK);
		if(!oggettiInAsta.isEmpty())
			response.setData(oggettiInAsta);
		else
			response.setMessage(Constants.NO_ELEMENTS);
        return response;
    }
	
	//trovare tutte le offerte attive di un utente
	@RequestMapping(value = "/findAllOfferteUtente/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public ResponseObj<List<Offerta>> findAllOfferteUtente(@PathVariable Integer id) {
		
		ResponseObj<List<Offerta>> response = new ResponseObj<List<Offerta>>();
		Utente utente = utenteService.getUser(id);
		List<Offerta> offerte = offertaService.findAllOfferteByUtente(utente);
		response.setEsito(Constants.OK);
		
		if(!offerte.isEmpty())
			response.setData(offerte);
		else
			response.setMessage(Constants.NO_ELEMENTS);
        return response;
    }
	
}
