package aste.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.CatAttJpaRepository;
import aste.model.Attributo;
import aste.model.CatAtt;
import aste.service.CatAttService;

@Service
@Transactional
public class CatAttServiceImpl implements CatAttService {

	@Resource
	CatAttJpaRepository catAttJpaRepository;

	public void addCatAtt(CatAtt catatt) {
		catAttJpaRepository.saveAndFlush(catatt);
	}

	public void deleteCatAtt(Integer catattId) {
		catAttJpaRepository.delete(catattId);
	}

	public List<Attributo> findAttributiByCategoria(Integer idCategoria) {
		List<Attributo> attributi = new ArrayList<Attributo>();
		for(CatAtt catAtt : catAttJpaRepository.findByCategoria(idCategoria))
			attributi.add(catAtt.getAttributo());
		return attributi;
	}	
}
