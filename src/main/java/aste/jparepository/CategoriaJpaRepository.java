package aste.jparepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.Categoria;

@Transactional
@Repository
public interface CategoriaJpaRepository extends JpaRepository<Categoria, Integer> {
	//List<Oggetto> findByUsernameAndPassword(String username, String password);
}
