package com.signup.services;

import com.signup.dto.UserDTO;
import com.signup.entities.User;
import com.signup.repositories.UserRepository;
import com.signup.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void addUser(UserDTO userDTO) {
        checkPossibleDuplicity(userDTO);

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    private void checkPossibleDuplicity(UserDTO userDTO) {
        User userFoundByEmail = userRepository.findByEmail(userDTO.getEmail()).orElse(null);
        if (Objects.nonNull(userFoundByEmail)) throw new IllegalStateException(Messages.MESSAGE_2.getDescription());
    }

}
