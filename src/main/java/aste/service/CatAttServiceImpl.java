package aste.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.CatAttJpaRepository;
import aste.model.CatAtt;

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

	
}
