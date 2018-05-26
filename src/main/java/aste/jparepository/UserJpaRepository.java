package aste.jparepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.User;

@Transactional
@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
	List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
