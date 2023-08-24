package repository.user;

import model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmailOrUserId(String email, String userId);
    User findByUserId(String userId);
}
