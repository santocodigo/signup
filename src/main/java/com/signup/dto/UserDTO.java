package com.signup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt;

}
