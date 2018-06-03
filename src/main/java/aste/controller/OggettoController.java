package aste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aste.bean.OggettoAttributiBean;
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
    public ResponseObj<Oggetto> save(@RequestBody OggettoAttributiBean oggettoAttributiBean) {
		ResponseObj<Oggetto> response = new ResponseObj<Oggetto>();
		oggettoService.addOggetto(oggettoAttributiBean);
		response.setEsito(Constants.OK);
		response.setData(oggettoAttributiBean.getOggetto());
        return response;
    }
	
	@RequestMapping(value = "/findByNome/{nome}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public ResponseObj<List<Oggetto>> findByNome(@PathVariable String nome) {
		
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
	
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public ResponseObj<Oggetto> findById(@PathVariable Integer id) {
		
		ResponseObj<Oggetto> response = new ResponseObj<Oggetto>();
		Oggetto oggetto = oggettoService.getOggetto(id);
		
		if(oggetto != null) {
			response.setEsito(Constants.OK);
			response.setData(oggetto);
		}
		else {
			response.setEsito(Constants.OK);
			response.setMessage(Constants.NO_ELEMENTS);
		}
        return response;
    }
}
