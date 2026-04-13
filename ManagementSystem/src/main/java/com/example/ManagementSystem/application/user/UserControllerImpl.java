package com.example.ManagementSystem.application.user;

import com.example.ManagementSystem.application.user.dto.PasswordDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import com.example.ManagementSystem.domain.user.User;
import com.example.ManagementSystem.domain.user.UserService;
import com.example.ManagementSystem.domain.utils.UserRegistration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserControllerImpl implements UserController {
    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public ResponseEntity<UserDTO> register(@RequestBody UserRegistration data) {
        User newUser = userService.create(data);
        return ResponseEntity.status(201).body(UserDTO.fromUser(newUser));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllByPrefix(String prefix) {
        var all = this.userService.getUsersStartsWith(prefix).stream().map(User::toDTO).toList();

        return ResponseEntity.ok(all);
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAll();

        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<UserDTO> updatePasswd(String username, PasswordDTO dto) {
        var user = this.userService.updatePassword(username, dto.oldPassword(), dto.newPassword());

        return ResponseEntity.ok(user.toDTO());
    }

    @Override
    public ResponseEntity<Void> shadowDelete(String username) {
        userService.shadowDelete(username);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Integer> deleteUser(String username) {
        userService.delete(username);
        return ResponseEntity.ok(1);
    }
}
