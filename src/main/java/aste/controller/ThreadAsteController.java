package aste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aste.model.Oggetto;
import aste.service.ThreadAsteService;
import aste.utils.Constants;
import aste.utils.ResponseObj;

@RestController
@RequestMapping("threadAste")
public class ThreadAsteController {

	@Autowired
	ThreadAsteService threadAsteService;	
	
	@RequestMapping(value = "/run", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<Oggetto> save(@RequestBody Oggetto oggetto) throws InterruptedException {
		ResponseObj<Oggetto> response = new ResponseObj<Oggetto>();
		threadAsteService.runThread(oggetto);
		response.setEsito(Constants.OK);
        return response;
    }
}
