package fr.mbds.estia.lecoincoin_estia_25_26.services;

import fr.mbds.estia.lecoincoin_estia_25_26.dtos.UserDto;
import fr.mbds.estia.lecoincoin_estia_25_26.model.User;

import java.util.List;

public interface UserService {
    UserDto getUser(Long id);
    List<UserDto> getAllUsers();
    UserDto createUser(UserDto user);
    void deleteUser(UserDto user);
    UserDto save(UserDto user);
    String saveUser(UserDto userDto);
    User findByMail(String mail);
    User findByPseudo(String pseudo);
}
