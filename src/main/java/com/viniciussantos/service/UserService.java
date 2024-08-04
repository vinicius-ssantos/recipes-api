package com.viniciussantos.service;

import com.viniciussantos.model.User;

public interface UserService {

    User findUserById(Long id) throws Exception;
    User findUserByJwt(String jwt) throws Exception;
}
