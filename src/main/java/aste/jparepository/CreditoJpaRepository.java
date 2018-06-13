package aste.jparepository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.Credito;

@Transactional
@Repository
public interface CreditoJpaRepository extends JpaRepository<Credito, Integer> {
}
