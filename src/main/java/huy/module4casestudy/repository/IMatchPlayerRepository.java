package huy.module4casestudy.repository;

import huy.module4casestudy.model.MatchPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchPlayerRepository extends JpaRepository<MatchPlayer, Long> {
}
