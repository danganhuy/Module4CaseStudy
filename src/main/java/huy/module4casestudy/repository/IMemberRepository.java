package huy.module4casestudy.repository;

import huy.module4casestudy.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberRepository extends JpaRepository<Member, Long> {
}
