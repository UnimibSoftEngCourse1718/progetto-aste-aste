package aste.jparepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.Offerta;
import aste.model.Offerta.Stato;
import aste.model.Oggetto;
import aste.model.Utente;

@Transactional
@Repository
public interface OffertaJpaRepository extends JpaRepository<Offerta, Integer> {
	List<Offerta> findByStato(Stato stato);
	List<Offerta> findByIdUtente(Utente utente);
	List<Offerta> findByIdUtenteAndStato(Utente utente, Stato stato);
	List<Offerta> findByIdOggettoOrderByIdOffertaDesc(Oggetto oggetto);
	Offerta findFirstByIdOggettoOrderByIdOfferta(Oggetto oggetto);
	Offerta findFirstByIdOggettoOrderByIdOffertaDesc(Oggetto oggetto);
	void deleteByIdOggettoAndStato(Oggetto oggetto,Stato stato);
}
