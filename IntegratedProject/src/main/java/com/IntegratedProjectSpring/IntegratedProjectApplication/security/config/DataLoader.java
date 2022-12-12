package com.IntegratedProjectSpring.IntegratedProjectApplication.security.config;

import com.IntegratedProjectSpring.IntegratedProjectApplication.model.AppUser;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.AppUserRole;
import com.IntegratedProjectSpring.IntegratedProjectApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
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
        user.setName("Alpha");
        user.setUsername("alpha");
        user.setPassword(hashedPassword);
        user.setEmail("alpha@alpha.com");
        user.setRole(AppUserRole.USER);


        userAdmin.setName("Stiven");
        userAdmin.setUsername("stmolinag");
        userAdmin.setPassword(hashedPassword);
        userAdmin.setEmail("stmolinag@gmail.com");
        userAdmin.setRole(AppUserRole.ADMIN);

        userRepository.save(user);
        userRepository.save(userAdmin);
    }
}
