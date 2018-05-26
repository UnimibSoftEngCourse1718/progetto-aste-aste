package aste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aste.model.User;
import aste.service.UserService;
import aste.utils.ResponseObj;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<User> add(@RequestBody User user) {
		ResponseObj<User> response = new ResponseObj<User>();
		userService.addUser(user);
		response.setData(user);
        return response;
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<User> login(@RequestBody User user) {
		ResponseObj<User> response = new ResponseObj<User>();
		List<User> users = userService.getUserLogin(user);
		if(!users.isEmpty()){
			response.setResult("OK");
			response.setData(user);
		}
		else
			response.setResult("KO");	
        return response;
    }
}
