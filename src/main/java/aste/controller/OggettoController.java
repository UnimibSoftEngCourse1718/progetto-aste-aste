package aste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aste.model.Oggetto;
import aste.service.OggettoService;
import aste.utils.Constants;
import aste.utils.ResponseObj;

@RestController
@RequestMapping("oggetto")
public class OggettoController {

	@Autowired
	OggettoService oggettoService;	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<Oggetto> add(@RequestBody Oggetto oggetto) {
		ResponseObj<Oggetto> response = new ResponseObj<Oggetto>();
		oggettoService.addOggetto(oggetto);
		response.setEsito(Constants.OK);
		response.setData(oggetto);
        return response;
    }
	
	@RequestMapping(value = "/findByNome/{nome}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public ResponseObj<List<Oggetto>> find(@PathVariable String nome) {
		
		ResponseObj<List<Oggetto>> response = new ResponseObj<List<Oggetto>>();
		List<Oggetto> oggetti = oggettoService.findByNome(nome);
		
		if(!oggetti.isEmpty()) {
			response.setEsito(Constants.OK);
			response.setData(oggetti);
		}
		else {
			response.setEsito(Constants.OK);
			response.setMessage(Constants.NO_ELEMENTS);
		}
        return response;
    }
}
