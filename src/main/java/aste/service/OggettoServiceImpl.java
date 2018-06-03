package aste.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aste.bean.OggettoAttributiBean;
import aste.jparepository.OggettoJpaRepository;
import aste.model.Attributo;
import aste.model.OggAtt;
import aste.model.Oggetto;

@Service
@Transactional
public class OggettoServiceImpl implements OggettoService {

	@Resource
	OggettoJpaRepository oggettoJpaRepository;
	
	@Autowired
	OggAttService oggAttservice;

	public void addOggetto(OggettoAttributiBean oggettoAttributiBean) {
		Oggetto oggetto = oggettoJpaRepository.saveAndFlush(oggettoAttributiBean.getOggetto());
		Iterator<Map.Entry<Integer, String>> it = oggettoAttributiBean.getAttributiValore().entrySet().iterator();
		// Verifica con il metodo hasNext() che nella hashmap
		// ci siano altri elementi su cui ciclare
		while (it.hasNext()) {
			// Utilizza il nuovo elemento (coppia chiave-valore)
			// dell'hashmap
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) it.next();
			OggAtt oggAtt = new OggAtt();
			Attributo attributo = new Attributo();
			attributo.setIdAttributo(entry.getKey());
			oggAtt.setAttributo(attributo);
			oggAtt.setValore(entry.getValue());
			oggAtt.setOggetto(oggetto);
			oggAttservice.addOggAtt(oggAtt);
		}
	}

	public List<Oggetto> getAllOggetti() {
		return oggettoJpaRepository.findAll();
	}

	public void deleteOggetto(Integer oggettoId) {
		oggettoJpaRepository.delete(oggettoId);
	}

	public Oggetto getOggetto(Integer oggettoId) {
		return oggettoJpaRepository.findOne(oggettoId);
	}

	public Oggetto updateOggetto(Oggetto oggetto) {
		return oggettoJpaRepository.saveAndFlush(oggetto);
	}

	public List<Oggetto> findByNome(String nome) {
		return oggettoJpaRepository.findByNome(nome);
	}
}
