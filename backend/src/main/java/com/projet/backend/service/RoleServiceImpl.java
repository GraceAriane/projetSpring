package com.projet.backend.service;

import com.projet.backend.model.Role;
import com.projet.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository){
        this.repository=repository;
    }

    /** 
     * @param role
     * @return Role
     */
    @Override
    public Role saveRole(Role role) {
        return repository.save(role);
    }

    /** 
     * @param id
     * @return Optional<Role>
     */
    @Override
    public Optional<Role> getRoleId(Long id) {
        return repository.findById(id);
    }

    /** 
     * @param id
     */
    @Override
    public void deleteRoleById(Long id) {
        repository.deleteById(id);
    }

    /** 
     * @param id
     * @param newRole
     * @return Role
     */
    @Override
    public Role updateRole(Long id, Role newRole) {
        return repository.findById(id)
                .map(role -> {
                    role.setName(newRole.getName());
                    return repository.save(role);
                }).orElse(null);
    }

    /** 
     * @return List<Role>
     */
    @Override
    public List<Role> getAllRole() {
        return repository.findAll();
    }
}