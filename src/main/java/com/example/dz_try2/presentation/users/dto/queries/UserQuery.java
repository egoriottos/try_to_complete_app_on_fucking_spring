package com.example.dz_try2.presentation.users.dto.queries;

import com.example.dz_try2.domain.valueObject.TimeInfo;
import lombok.Data;

@Data
public class UserQuery {
    Long id;
    String name;
    String mail;
    TimeInfo timeInfo;
}
