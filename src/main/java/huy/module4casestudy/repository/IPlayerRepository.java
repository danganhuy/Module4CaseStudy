package huy.module4casestudy.repository;

import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByMemberId(Long memberId);
}
