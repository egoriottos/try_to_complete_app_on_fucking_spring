package com.example.dz_try2.application;

import com.example.dz_try2.domain.entity.User;
import com.example.dz_try2.presentation.users.dto.commands.CreateUserCommand;
import com.example.dz_try2.presentation.users.dto.commands.UpdateUserCommand;
import com.example.dz_try2.presentation.users.dto.queries.UserQuery;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserQuery fromUserToQuery(User user);

    User fromCommandToUser(CreateUserCommand command);

    User fromCommandToUser(UpdateUserCommand command);

    List<UserQuery> fromUsersToQueries(List<User> users);


}
