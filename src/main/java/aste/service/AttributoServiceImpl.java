package aste.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.AttributoJpaRepository;
import aste.model.Attributo;

@Service
@Transactional
public class AttributoServiceImpl implements AttributoService {

	@Resource
	AttributoJpaRepository attributoJpaRepository;

	public void addAttributo(Attributo attributo) {
		attributoJpaRepository.saveAndFlush(attributo);
	}

	public List<Attributo> getAllOggetti() {
		return attributoJpaRepository.findAll();
	}

	public void deleteAttributo(Integer attributoId) {
		attributoJpaRepository.delete(attributoId);
	}

	public Attributo getAttributo(int attributoId) {
		return attributoJpaRepository.getOne(attributoId);
	}

	public Attributo updateAttributo(Attributo attributo) {
		return attributoJpaRepository.saveAndFlush(attributo);
	}
}
