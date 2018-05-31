package aste.jparepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.Oggetto;

@Transactional
@Repository
public interface OggettoJpaRepository extends JpaRepository<Oggetto, Integer> {
	List<Oggetto> findByNome(String nome);
}
