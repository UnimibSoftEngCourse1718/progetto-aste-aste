package aste.jparepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aste.model.OggAtt;

@Transactional
@Repository
public interface OggAttJpaRepository extends JpaRepository<OggAtt, Integer> {

	List<OggAtt> findByOggetto(Integer idOggetto);
}
