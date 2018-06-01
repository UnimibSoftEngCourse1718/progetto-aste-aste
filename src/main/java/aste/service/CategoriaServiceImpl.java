package aste.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aste.bean.CategoriaAttributiBean;
import aste.jparepository.CategoriaJpaRepository;
import aste.model.Attributo;
import aste.model.CatAtt;
import aste.model.Categoria;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

	@Resource
	CategoriaJpaRepository categoriaJpaRepository;
	
	@Autowired
	AttributoService attributoService;
	
	@Autowired
	CatAttService catAttService;

	public void addCategoria(CategoriaAttributiBean categoriaAttributiBean) {
		categoriaJpaRepository.saveAndFlush(categoriaAttributiBean.getCategoria());
		for(Attributo attributo : categoriaAttributiBean.getAttributi()){
			attributoService.addAttributo(attributo);
			CatAtt catAtt = new CatAtt();
			catAtt.setIdAttributo(attributo);
			catAtt.setIdCategoria(categoriaAttributiBean.getCategoria());
			catAttService.addCatAtt(catAtt);
		}
	}

	public List<Categoria> getAllOggetti() {
		return categoriaJpaRepository.findAll();
	}

	public void deleteCategoria(Integer categoriaId) {
		categoriaJpaRepository.delete(categoriaId);	
	}

	public Categoria getCategoria(int categoriaId) {
		return categoriaJpaRepository.getOne(categoriaId);
	}

	public Categoria updateCategoria(Categoria categoria) {
		return categoriaJpaRepository.saveAndFlush(categoria);
	}
	
	public List<Attributo> findAttributi(String nomeCategoria) {
		return categoriaJpaRepository.findFirstByNome(nomeCategoria).getAttributi();
	}

	public List<Categoria> findAll() {
		return categoriaJpaRepository.findAll();
	}
}
