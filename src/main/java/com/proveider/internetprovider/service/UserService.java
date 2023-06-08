package com.proveider.internetprovider.service;

import com.proveider.internetprovider.dto.UserDto;
import com.proveider.internetprovider.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
