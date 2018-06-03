package aste.jparepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.Utente;

@Transactional
@Repository
public interface UtenteJpaRepository extends JpaRepository<Utente, Integer> {
	Utente findByUsernameAndPassword(String username, String password);
	Utente findByUsername(String username);
}
