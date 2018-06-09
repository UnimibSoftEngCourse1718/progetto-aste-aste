package aste.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.OggAttJpaRepository;
import aste.model.Attributo;
import aste.model.OggAtt;

@Service
@Transactional
public class OggAttServiceImpl implements OggAttService {

	@Resource
	OggAttJpaRepository oggAttJpaRepository;

	public void addOggAtt(OggAtt oggatt) {
		oggAttJpaRepository.saveAndFlush(oggatt);
	}

	public void deleteOggAtt(Integer oggattId) {
		oggAttJpaRepository.delete(oggattId);
	}

	public List<Attributo> findAttributiByOggetto(Integer idOggetto) {
		List<Attributo> attributi = new ArrayList<Attributo>();
		for(OggAtt oggAtt : oggAttJpaRepository.findByOggetto(idOggetto))
			attributi.add(oggAtt.getAttributo());
		return attributi;
	}
}
