package com.viniciussantos.service.impl;

import com.viniciussantos.config.JwtProvider;
import com.viniciussantos.model.User;
import com.viniciussantos.repository.UserRepository;
import com.viniciussantos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found with id: " + id));
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromToken(jwt);
        if (email == null) {
            throw new Exception("provide valid jwt token...");
        }
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found with email: " + email);
        }
        return user;
    }
}
