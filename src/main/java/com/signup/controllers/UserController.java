package com.signup.controllers;

import com.signup.dto.UserDTO;
import com.signup.services.UserService;
import com.signup.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        try {
            userService.addUser(userDTO);
        } catch (IllegalStateException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(Messages.MESSAGE_1.getDescription());
    }

}
