package com.proveider.internetprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proveider.internetprovider.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}