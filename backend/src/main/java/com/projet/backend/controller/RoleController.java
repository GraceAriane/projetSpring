package com.projet.backend.controller;

import com.projet.backend.model.Author;
import com.projet.backend.model.Role;
import com.projet.backend.service.AuthorService;
import com.projet.backend.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return service.getAllRole();
    }

    @PostMapping
    public Role create(@RequestBody Role role) {
        return service.saveRole(role);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id);
        return service.saveRole(role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRoleById(id);
    }
}