package com.projet.backend.service;

import com.projet.backend.model.Role;
import com.projet.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RoleServiceImpl implements RoleService{
//    @Autowired
//    public RoleRepository roleRepository;
//
//    @Override
//    public Role saveRole() {
//        return null;
//    }
//
//    @Override
//    public Optional<Role> getRoleId(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public void deleteRoleById(Long id) {
//
//    }
//
//    @Override
//    public Role updateRole(Long id, Role newRole) {
//        return null;
//    }
//
//    @Override
//    public List<Role> getAllRole() {
//        return List.of();
//    }
//}





import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository){
        this.repository=repository;
    }

    @Override
    public Role saveRole(Role role) {
        return repository.save(role);
    }

    @Override
    public Optional<Role> getRoleId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteRoleById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Role updateRole(Long id, Role newRole) {
        return repository.findById(id)
                .map(role -> {
                    role.setName(newRole.getName());
                    return repository.save(role);
                }).orElse(null);
    }

    @Override
    public List<Role> getAllRole() {
        return repository.findAll();
    }
}