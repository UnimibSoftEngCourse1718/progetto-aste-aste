package aste.jparepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.CatAtt;

@Transactional
@Repository
public interface CatAttJpaRepository extends JpaRepository<CatAtt, Integer> {
}
