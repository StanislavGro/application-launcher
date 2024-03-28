package com.launcher.api.mapper;

import com.launcher.api.entities.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import com.launcher.api.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto map(User user);

    @InheritInverseConfiguration
    User map(UserDto userDto);
}
