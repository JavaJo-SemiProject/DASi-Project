package com.project.dasi.auth.model.service;


import com.project.dasi.auth.model.dto.UserCreateRequest;
import com.project.dasi.auth.model.dto.UserDTO;

import java.util.HashMap;

public interface UsersService {

    UserDTO createUser(UserCreateRequest userCreateRequest);

    boolean checkUseridDuplication(String userid);

    /*HashMap<String, Object> useridOverlap(String userid);*/

}
