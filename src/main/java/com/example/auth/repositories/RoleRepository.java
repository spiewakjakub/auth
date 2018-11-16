package com.example.auth.repositories;

import com.example.auth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Override
    List<Role> findAll();

    @Override
    Role getOne(Long aLong);
}
