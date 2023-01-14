package com.signup.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("User successfully added"),
    MESSAGE_2("The e-mail entered has already been registered");

    private final String description;

}
