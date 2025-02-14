package huy.module4casestudy.repository;

import huy.module4casestudy.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoachRepository extends JpaRepository<Coach, Long> {

}
