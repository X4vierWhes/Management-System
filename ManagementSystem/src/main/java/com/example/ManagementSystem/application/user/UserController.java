package com.example.ManagementSystem.application.user;

import com.example.ManagementSystem.application.user.dto.PasswordDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import com.example.ManagementSystem.domain.utils.UserRegistration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserController {

    @GetMapping("/{username}")
    ResponseEntity<List<UserDTO>> getAllByPrefix(@RequestParam String prefix);

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers();

    @GetMapping("/all/active")
    public ResponseEntity<List<UserDTO>> getAllActiveUsers();

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserRegistration data);

    @PostMapping("/{username}/update")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String username, @RequestBody UserDTO data);

    @PatchMapping("/{username}/update/password")
    ResponseEntity<UserDTO> updatePasswd(@PathVariable String username, @RequestBody PasswordDTO dto);

    @PatchMapping("/{username}/disable")
    ResponseEntity<Void> shadowDelete(@PathVariable String username);

    @DeleteMapping("/{username}/delete")
    ResponseEntity<Integer> deleteUser(@PathVariable String username);

}
