package aste.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aste.model.Offerta;
import aste.model.Oggetto;
import aste.service.OffertaService;
import aste.utils.Constants;
import aste.utils.ResponseObj;

@RestController
@RequestMapping("offerta")
public class OffertaController {

	@Autowired
	OffertaService offertaService;	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<Offerta> save(@RequestBody Offerta offerta) {
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
}
