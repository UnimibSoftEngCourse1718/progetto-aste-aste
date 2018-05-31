package aste.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.OggettoJpaRepository;
import aste.model.Oggetto;

@Service
@Transactional
public class OggettoServiceImpl implements OggettoService {

	@Resource
	OggettoJpaRepository oggettoJpaRepository;

	public void addOggetto(Oggetto oggetto) {
		oggettoJpaRepository.saveAndFlush(oggetto);
	}

	public List<Oggetto> getAllOggetti() {
		return oggettoJpaRepository.findAll();
	}

	public void deleteOggetto(Integer oggettoId) {
		oggettoJpaRepository.delete(oggettoId);
	}

	public Oggetto getOggetto(int oggettoId) {
		return oggettoJpaRepository.getOne(oggettoId);
	}

	public Oggetto updateOggetto(Oggetto oggetto) {
		return oggettoJpaRepository.saveAndFlush(oggetto);
	}

	public List<Oggetto> findByNome(String nome) {
		return oggettoJpaRepository.findByNome(nome);
	}
}
