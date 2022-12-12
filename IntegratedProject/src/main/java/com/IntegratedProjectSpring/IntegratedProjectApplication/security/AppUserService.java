package com.IntegratedProjectSpring.IntegratedProjectApplication.security;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.AppUserDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.AppUser;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AppUser create(AppUser user){
        return userRepository.save(user);
    }

    public AppUserDto getUserbyUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
