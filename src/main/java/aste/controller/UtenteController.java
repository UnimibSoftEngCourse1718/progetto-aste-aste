package aste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aste.model.Utente;
import aste.service.UtenteService;
import aste.utils.Constants;
import aste.utils.ResponseObj;

@RestController
@RequestMapping("user")
public class UtenteController {

	@Autowired
	UtenteService userService;	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<Utente> add(@RequestBody Utente user) {
		ResponseObj<Utente> response = new ResponseObj<Utente>();
		userService.addUser(user);
		response.setEsito(Constants.OK);
		response.setData(user);
        return response;
    }
	
	@RequestMapping(value = "/find", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<Utente> login(@RequestBody Utente user) {
		ResponseObj<Utente> response = new ResponseObj<Utente>();
		List<Utente> users = userService.getUserLogin(user);
		if(!users.isEmpty()){
			response.setEsito(Constants.OK);
			response.setData(user);
		}
		else
			response.setEsito(Constants.KO);	
        return response;
    }
}
