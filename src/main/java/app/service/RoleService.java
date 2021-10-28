package app.service;

import app.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);

    List<Role> getAllRoles();

    Role getRoleByName(String name);
}
