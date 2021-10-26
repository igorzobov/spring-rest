package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
