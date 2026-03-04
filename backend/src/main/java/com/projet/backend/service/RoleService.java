package com.projet.backend.service;

import com.projet.backend.model.Author;
import com.projet.backend.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
//    public Role saveRole();

    public Role saveRole(Role role);

    public Optional<Role> getRoleId(Long id);
    public void deleteRoleById(Long id);
    public Role updateRole(Long id, Role newRole);
    public List<Role> getAllRole();

}
