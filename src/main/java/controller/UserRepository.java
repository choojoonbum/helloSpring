package controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByNameStartingWithOrderByNameAscCreateDateDesc(String name);

    List<User> findByNameStartingWith(String name, Sort sort);

    List<User> findByNameStartingWith(String name, Pageable pageable);

    User findByName(String name);
}
