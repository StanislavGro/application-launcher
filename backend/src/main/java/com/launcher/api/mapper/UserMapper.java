package com.launcher.api.mapper;

import com.launcher.api.dto.UserDto;
import com.launcher.api.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto map(User user);

    @InheritInverseConfiguration
    User map(UserDto userDto);
}
