package com.example.relaxer.repositories;

import com.example.relaxer.entity.Credentials;
import com.example.relaxer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

}