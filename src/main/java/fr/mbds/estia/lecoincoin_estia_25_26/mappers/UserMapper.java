package fr.mbds.estia.lecoincoin_estia_25_26.mappers;

import fr.mbds.estia.lecoincoin_estia_25_26.dtos.UserDto;
import fr.mbds.estia.lecoincoin_estia_25_26.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toEntity(UserDto userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setDob(userDTO.getDob());
        user.setMail(userDTO.getMail());
        user.setPhone(userDTO.getPhone());
        user.setPseudo(userDTO.getPseudo());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        return user;
    }

    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setDob(user.getDob());
        userDto.setMail(user.getMail());
        userDto.setPhone(user.getPhone());
        userDto.setPseudo(user.getPseudo());
        userDto.setLastName(user.getLastName());
        userDto.setFirstName(user.getFirstName());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    public List<UserDto> toDtoList(List<User> users) {
        if (users == null) {
            return List.of();
        }
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }
}
