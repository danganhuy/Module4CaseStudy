package huy.module4casestudy.repository;

import huy.module4casestudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
