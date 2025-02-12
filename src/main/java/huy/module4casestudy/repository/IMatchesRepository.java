package huy.module4casestudy.repository;

import huy.module4casestudy.model.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchesRepository extends JpaRepository<Matches, Long> {

}
