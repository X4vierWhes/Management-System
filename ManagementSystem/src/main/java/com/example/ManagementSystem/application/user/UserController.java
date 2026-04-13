package com.example.ManagementSystem.application.user;

import com.example.ManagementSystem.application.user.dto.PasswordDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserController {
    @GetMapping("/{username}")
    ResponseEntity<List<UserDTO>> getAllByPrefix(@RequestParam String prefix);

    @PatchMapping("/{username}")
    ResponseEntity<UserDTO> updatePasswd(@PathVariable String username, @RequestBody PasswordDTO dto);

    @PatchMapping("/{username}")
    ResponseEntity<Void> shadowDelete(@PathVariable String username);

    @DeleteMapping("/{username}")
    ResponseEntity<Integer> deleteUser(@PathVariable String username);
}
