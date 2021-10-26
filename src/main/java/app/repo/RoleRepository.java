package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
