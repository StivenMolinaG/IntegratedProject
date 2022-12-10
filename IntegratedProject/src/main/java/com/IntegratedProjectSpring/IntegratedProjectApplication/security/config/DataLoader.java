package com.IntegratedProjectSpring.IntegratedProjectApplication.security.config;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.AppUser;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.AppUserRole;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DataLoader implements ApplicationRunner {
    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        AppUser user = new AppUser();
        AppUser userAdmin = new AppUser();
        String hashedPassword = passwordEncoder.encode("password");
        user.setName("Apolo");
        user.setUsername("apolo");
        user.setPassword(hashedPassword);
        user.setEmail("dh@dh.com");
        user.setRole(AppUserRole.USER);


        userAdmin.setName("Nina");
        userAdmin.setUsername("nina");
        userAdmin.setPassword(hashedPassword);
        userAdmin.setEmail("dh@dh.com");
        userAdmin.setRole(AppUserRole.ADMIN);

        userRepository.save(user);
        userRepository.save(userAdmin);
    }
}
