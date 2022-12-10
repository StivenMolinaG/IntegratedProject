package com.IntegratedProjectSpring.IntegratedProjectApplication.controllers;

import com.IntegratedProjectSpring.IntegratedProjectApplication.security.AppUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService userService;

    public AppUserController(AppUserService userService) {
        this.userService = userService;
    }

    /*@PostMapping
    public ResponseEntity<AppUserDto> createUser(@RequestBody User user) {
        AppUserDto savedUser = userService.save(user);
        return ResponseEntity.ok().body(savedUser);
    }
    @GetMapping("/{username}")
    public ResponseEntity<AppUserDto> getByUsername(@PathVariable String username) {
        AppUserDto user = userService.getByUsername(username);
        return ResponseEntity.ok().body(user);
    }
    @GetMapping
    public ResponseEntity<Set<AppUserDto>> getAll() {
        Set<AppUserDto> userDtos = userService.getAll();
        return ResponseEntity.ok().body(AppUserDtos);
    }*/
}
