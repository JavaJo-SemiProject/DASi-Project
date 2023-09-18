package com.project.dasi.auth.service;


import com.project.dasi.auth.dto.UserCreateRequest;
import com.project.dasi.auth.dto.UserDTO;
import com.project.dasi.auth.repository.UserRepository;

import java.util.HashMap;

public interface UsersService {

    UserDTO createUser(UserCreateRequest userCreateRequest);

    HashMap<String, Object> useridOverlap(String userid);
}
