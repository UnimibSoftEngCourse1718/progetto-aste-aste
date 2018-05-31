package aste.jparepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.Offerta;
import aste.model.Offerta.Stato;

@Transactional
@Repository
public interface OffertaJpaRepository extends JpaRepository<Offerta, Integer> {
	List<Offerta> findByStato(Stato stato);
}
