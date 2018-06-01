package aste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aste.bean.CategoriaAttributiBean;
import aste.model.Attributo;
import aste.model.Categoria;
import aste.service.CategoriaService;
import aste.utils.Constants;
import aste.utils.ResponseObj;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<Categoria> save(@RequestBody CategoriaAttributiBean categoriaAttributiBean) {
		ResponseObj<Categoria> response = new ResponseObj<Categoria>();
		categoriaService.addCategoria(categoriaAttributiBean);
		response.setEsito(Constants.OK);
		response.setData(categoriaAttributiBean.getCategoria());
        return response;
    }
	
	@RequestMapping(value = "/findAttributi/{nomeCategoria}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public ResponseObj<List<Attributo>> findAttributi(@PathVariable String nomeCategoria) {
		
		ResponseObj<List<Attributo>> response = new ResponseObj<List<Attributo>>();
		List<Attributo> attributi = categoriaService.findAttributi(nomeCategoria);
		
		if(!attributi.isEmpty()) {
			response.setEsito(Constants.OK);
			response.setData(attributi);
		}
		else {
			response.setEsito(Constants.OK);
			response.setMessage(Constants.NO_ELEMENTS);
		}
        return response;
    }
}
