package com.project.services;

import com.project.models.Account;
import com.project.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void register(Account user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }



}
