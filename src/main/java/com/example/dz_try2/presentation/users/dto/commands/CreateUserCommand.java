package com.example.dz_try2.presentation.users.dto.commands;

import lombok.Data;

@Data
public class CreateUserCommand {
    String name;
    String email;
}
