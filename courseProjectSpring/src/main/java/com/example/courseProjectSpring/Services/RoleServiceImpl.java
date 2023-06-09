package com.example.courseProjectSpring.Services;

import com.example.courseProjectSpring.Model.Role;
import com.example.courseProjectSpring.Repository.RoleRepository;
import com.example.courseProjectSpring.ServiceInterfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Transactional
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Transactional
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
