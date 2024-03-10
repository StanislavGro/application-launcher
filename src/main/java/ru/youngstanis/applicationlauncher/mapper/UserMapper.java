package ru.youngstanis.applicationlauncher.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import ru.youngstanis.applicationlauncher.dto.UserDto;
import ru.youngstanis.applicationlauncher.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto map(User user);

    @InheritInverseConfiguration
    User map(UserDto userDto);
}
