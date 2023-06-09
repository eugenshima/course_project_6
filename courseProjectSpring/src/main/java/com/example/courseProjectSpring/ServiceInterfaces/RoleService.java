package com.example.courseProjectSpring.ServiceInterfaces;

import com.example.courseProjectSpring.Model.Customer;
import com.example.courseProjectSpring.Model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role save(Role role);
}
