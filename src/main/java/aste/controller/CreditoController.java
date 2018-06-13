package aste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aste.model.Credito;
import aste.service.CreditoService;
import aste.utils.Constants;
import aste.utils.ResponseObj;

@RestController
@RequestMapping("credito")
public class CreditoController {

	@Autowired
	CreditoService creditoService;	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<Credito> save(@RequestBody Credito credito) {
		ResponseObj<Credito> response = new ResponseObj<Credito>();
		creditoService.addCredito(credito);
		response.setEsito(Constants.OK);
		response.setData(credito);
        return response;
    }
}
