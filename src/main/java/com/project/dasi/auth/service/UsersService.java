package com.project.dasi.auth.service;


import com.project.dasi.auth.dto.UserCreateRequest;
import com.project.dasi.auth.dto.UserDTO;

public interface UsersService {
    UserDTO createUser(UserCreateRequest userCreateRequest);
}
