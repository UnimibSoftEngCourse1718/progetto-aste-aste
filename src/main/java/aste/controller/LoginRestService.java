package aste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import aste.model.User;
import aste.service.LoginService;
import aste.utils.ResponseObj;

@RestController
public class LoginRestService {

	@Autowired
	LoginService loginService;	
	
	@RequestMapping(value = "/login",headers="Accept=*/*", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public String validateCredentials(String user, String pwd) {
		ResponseObj<User> response = new ResponseObj<User>();
		
		if(loginService.validateCredentials(user, pwd))
			response.setResult("ok");
		else
			response.setResult("ko");
		
        return new Gson().toJson(response);
    }
}
