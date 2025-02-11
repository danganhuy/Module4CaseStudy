package huy.module4casestudy.repository;

import huy.module4casestudy.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICoachRepository extends JpaRepository<Coach, Long> {
    @Query("select  * from")
    List<Coach> findAll();
}
