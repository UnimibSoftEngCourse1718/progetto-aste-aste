package aste.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalRestExceptionHandler {
	 
	    @ExceptionHandler(value = Exception.class)
	    @ResponseBody
	    public ResponseObj<Exception> exception(Exception e) {
	    	ResponseObj<Exception> response = new ResponseObj<Exception>();
	    	response.setEsito(Constants.KO);
	    	response.setMessage(e.getMessage());
	    	return response;
	    }
}
