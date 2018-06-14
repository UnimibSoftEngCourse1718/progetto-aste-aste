package aste.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public ResponseObj<List<Categoria>> findAll() {
		ResponseObj<List<Categoria>> response = new ResponseObj<List<Categoria>>();
		List<Categoria> listCategoria = categoriaService.findAll();
		response.setEsito(Constants.OK);
		response.setData(listCategoria);
        return response;
    }
	
	@RequestMapping(value = "/findCategoria", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
    public ResponseObj<Set<Attributo>> findAttributi(@RequestBody Categoria categoria) {
		
		ResponseObj<Set<Attributo>> response = new ResponseObj<Set<Attributo>>();
		Set<Attributo> attributi = categoriaService.getCategoria(categoria.getIdCategoria()).getAttributi();
		
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
