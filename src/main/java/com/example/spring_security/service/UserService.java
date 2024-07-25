package com.example.spring_security.service;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_security.entities.Role;
import com.example.spring_security.entities.User;
import com.example.spring_security.repository.RoleRepository;
import com.example.spring_security.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User createUser(String name, String password, Date creationDate) {
        User user = new User(name, password, creationDate);
        return userRepository.save(user);
    }

    public Role createRole(String name) {
        Role role = new Role(name);
        return roleRepository.save(role);
    }

    public void assignRoleToUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found"));
        user.getRoles().add(role);
        role.getUsers().add(user);
        userRepository.save(user);
    }

    public User createUserWithRoles(String name, String password, Date creationDate, Set<Role> roles) {
        User user = new User(name, password, creationDate);
        user.setRoles(roles);
        roles.forEach(role -> role.getUsers().add(user));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }
    
}
