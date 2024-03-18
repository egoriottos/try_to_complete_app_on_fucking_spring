package com.example.dz_try2.presentation.users;

import com.example.dz_try2.application.UserMapper;
import com.example.dz_try2.application.users.UsersService;
import com.example.dz_try2.domain.entity.User;
import com.example.dz_try2.presentation.users.dto.commands.CreateUserCommand;
import com.example.dz_try2.presentation.users.dto.commands.UpdateUserCommand;
import com.example.dz_try2.presentation.users.dto.queries.UserQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
@CrossOrigin(origins="*")
public class UsersController {
    private final UsersService usersService;
    private final UserMapper mapper;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<UserQuery> getUsers(){
        final var users = usersService.getUsers();
        return mapper.fromUsersToQueries(users);
    }

    @PostMapping
    public UserQuery create(@RequestBody CreateUserCommand command){
        User userFromCommand = modelMapper.map(command,User.class);
        User user = usersService.create(userFromCommand);
        UserQuery userQueryResponse = modelMapper.map(user, UserQuery.class);
        return userQueryResponse;
    }

    @PutMapping("/{id}")
    public UserQuery update(@PathVariable Long id, @RequestBody UpdateUserCommand command) {
        User userFromCommand = modelMapper.map(command, User.class);

        User user = usersService.update(id, userFromCommand,command);

        UserQuery userQueryResponse = modelMapper.map(user, UserQuery.class);

        return userQueryResponse;
    }
}
