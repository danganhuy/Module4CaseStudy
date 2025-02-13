package huy.module4casestudy.repository;

import huy.module4casestudy.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> findAllByIdId(Long id);
}
