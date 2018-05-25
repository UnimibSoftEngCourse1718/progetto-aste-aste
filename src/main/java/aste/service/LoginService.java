package aste.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateCredentials(String usrname, String pwd) {
	    		return "zio".equals(usrname) && "carlo".equals(pwd);
	    }
}
