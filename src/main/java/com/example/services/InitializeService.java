package com.example.services;

import com.example.auth.entities.Role;
import com.example.auth.entities.User;
import com.example.auth.repositories.RoleRepository;
import com.example.auth.repositories.UserRepository;

import java.util.ArrayList;

public class InitializeService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public InitializeService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public void initialize() {

        userRepository.deleteAll();
        roleRepository.deleteAll();

        System.out.println("[RoleRepository is empty] : " + roleRepository.findAll().isEmpty());
        System.out.println("[UserRepository is empty] : " + userRepository.findAll().isEmpty());

        if (userRepository.findAll().isEmpty()) {
            User user1 = new User("admin", "admin", new ArrayList<Role>() {{
                add(new Role("admin"));
                add(new Role("sysadmin"));
                add(new Role("user"));
                add(new Role("superuser"));
            }});
            //user1.getRoles().forEach(roleRepository::save);
            User user2 = new User("sysadmin", "qwerty", new ArrayList<Role>() {{
                add(new Role("admin"));
                add(new Role("sysadmin"));
            }});
            //user2.getRoles().forEach(roleRepository::save);
            User user3 = new User("user", "user1", new ArrayList<Role>() {{
                add(new Role("user"));
            }});
            //user3.getRoles().forEach(roleRepository::save);
            User user4 = new User("superuser", "superuser123", new ArrayList<Role>() {{
                add(new Role("admin"));
                add(new Role("superuser"));
            }});
            //user4.getRoles().forEach(roleRepository::save);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);


        }
    }
}
