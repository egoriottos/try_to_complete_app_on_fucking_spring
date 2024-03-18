package com.example.dz_try2.presentation.users.dto.commands;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateUserCommand {
    private Long userId;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
    public LocalDateTime deletedAt;
}
