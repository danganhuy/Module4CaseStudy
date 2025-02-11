package huy.module4casestudy.repository;

import huy.module4casestudy.model.Member;
import huy.module4casestudy.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPlayerRepository extends JpaRepository<Player, Long> {
    // Lấy danh sách chỉ gồm thông tin từ Member
    @Query("SELECT m FROM Member m WHERE m.id IN (SELECT p.id FROM Player p)")
    List<Member> findAllMembers();

    // Lấy thông tin chi tiết của Player + Member
    @Query("SELECT p FROM Player p JOIN FETCH p.member WHERE p.id = :id")
    Optional<Player> findPlayerDetailsById(@Param("id") Long id);

    @Query("SELECT p FROM Player p JOIN FETCH p.member")
    List<Player> findAllWithMember();
}
