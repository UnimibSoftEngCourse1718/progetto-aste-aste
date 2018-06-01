package aste.jparepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.Attributo;

@Transactional
@Repository
public interface AttributoJpaRepository extends JpaRepository<Attributo, Integer> {
}
