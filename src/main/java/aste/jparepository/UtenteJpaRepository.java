package aste.jparepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.Utente;

@Transactional
@Repository
public interface UtenteJpaRepository extends JpaRepository<Utente, Integer> {
	List<Utente> findByUsernameAndPassword(String username, String password);
}
