package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import app.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
