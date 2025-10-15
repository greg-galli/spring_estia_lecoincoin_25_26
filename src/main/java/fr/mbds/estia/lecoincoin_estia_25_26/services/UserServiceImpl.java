package fr.mbds.estia.lecoincoin_estia_25_26.services;

import fr.mbds.estia.lecoincoin_estia_25_26.dtos.UserDto;
import fr.mbds.estia.lecoincoin_estia_25_26.mappers.UserMapper;
import fr.mbds.estia.lecoincoin_estia_25_26.model.User;
import fr.mbds.estia.lecoincoin_estia_25_26.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return null;
        }
        return userMapper.toDto(userOptional.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserDto createUser(UserDto user) {
        return save(user);
    }

    @Override
    public void deleteUser(UserDto user) {
        userRepository.delete(userMapper.toEntity(user));
    }

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User userEntity = userMapper.toEntity(userDto);
        userEntity = userRepository.save(userEntity);
        return userMapper.toDto(userEntity);
    }
}
