package huy.module4casestudy.repository;

import huy.module4casestudy.model.Coach;
import huy.module4casestudy.model.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMatchesRepository extends JpaRepository<Matches, Long> {
    List<Matches> findByCoachId(Long coachId);
}
