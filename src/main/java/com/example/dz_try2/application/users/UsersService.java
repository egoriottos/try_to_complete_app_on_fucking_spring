package com.example.dz_try2.application.users;

import com.example.dz_try2.domain.entity.User;
import com.example.dz_try2.presentation.users.dto.commands.UpdateUserCommand;
import com.example.dz_try2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User create(User userFromCommand) {
        User user = userRepository.save(userFromCommand);

        return user;
    }

    public User update(Long id, User userFromCommand, UpdateUserCommand commands) {
        var user = getById(id);

        if (!user.getName().equals(userFromCommand.getName())) user.setName(userFromCommand.getName());

        User saved = userRepository.save(user);
        commands.setUpdatedAt(LocalDateTime.now());

        return saved;
    }
}
