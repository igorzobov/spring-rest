package app.config;

import app.model.Role;
import app.model.User;
import app.service.RoleService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbInit {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void postConstruct() {
        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        Set<Role> roleSetAdmin = new HashSet<>();
        roleSetAdmin.add(roleService.getRoleByName("ROLE_ADMIN"));

        Set<Role> roleSetUser = new HashSet<>();
        roleSetUser.add(roleService.getRoleByName("ROLE_USER"));

        User admin = new User("admin", 33, "admin@email.com", "admin", roleSetAdmin);
        User user = new User("user", 22, "user@mail.com", "user", roleSetUser);

        Set<Role> rolesAdmin = new HashSet<>();
        rolesAdmin.add(roleService.getRoleByName("ROLE_ADMIN"));
        admin.setRoles(rolesAdmin);
        Set<Role> rolesUser = new HashSet<>();
        rolesUser.add(roleService.getRoleByName("ROLE_USER"));
        user.setRoles(rolesUser);

        userService.save(admin);
        userService.save(user);
    }
}
