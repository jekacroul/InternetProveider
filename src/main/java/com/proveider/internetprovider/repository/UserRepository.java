package com.proveider.internetprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proveider.internetprovider.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
