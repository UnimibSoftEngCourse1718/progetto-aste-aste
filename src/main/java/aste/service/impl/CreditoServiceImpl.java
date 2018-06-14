package aste.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import aste.jparepository.CreditoJpaRepository;
import aste.model.Credito;
import aste.model.Utente;
import aste.service.CreditoService;
import aste.service.UtenteService;

@Service
@Transactional
public class CreditoServiceImpl implements CreditoService {

	@Resource
	CreditoJpaRepository creditoJpaRepository;
	
	@Resource
	UtenteService utenteService;

	public void addCredito(Credito credito) {
		creditoJpaRepository.saveAndFlush(credito);	
		Utente utente = credito.getIdUtente();
		if(credito.getAzione())
			utente.setCredito(utente.getCredito()+ credito.getQuantita());
		else
			utente.setCredito(utente.getCredito()- credito.getQuantita());
		utenteService.updateUser(utente);
	}

	public List<Credito> findAllCredito() {
		return creditoJpaRepository.findAll();
	}

	public Credito getCredito(int creditoId) {
		return creditoJpaRepository.findOne(creditoId);
	}
}
