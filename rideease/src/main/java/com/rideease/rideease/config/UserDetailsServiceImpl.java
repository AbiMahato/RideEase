package com.rideease.rideease.config;

import com.rideease.rideease.model.UserModel;
import com.rideease.rideease.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.getUserByUserName(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("User not found!!");
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return customUserDetails;
    }
}
