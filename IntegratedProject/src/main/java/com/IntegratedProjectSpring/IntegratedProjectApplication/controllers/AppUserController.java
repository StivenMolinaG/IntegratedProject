package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.dtos.AppUserDto;
import com.IntegratedProjectSpring.IntegratedProjectApplication.model.AppUser;
import com.IntegratedProjectSpring.IntegratedProjectApplication.security.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService userService;

    public AppUserController(AppUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user) {
        AppUser savedUser = userService.create(user);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<AppUserDto> getByUsername(@PathVariable String username) {
        AppUserDto user = userService.getUserbyUsername(username);
        return ResponseEntity.ok().body(user);
    }
    /*
    @GetMapping
    public ResponseEntity<Set<AppUserDto>> getAll() {
        Set<AppUserDto> userDtos = userService.getAll();
        return ResponseEntity.ok().body(AppUserDtos);
    }*/
}
