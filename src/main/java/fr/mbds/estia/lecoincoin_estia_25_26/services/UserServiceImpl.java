package fr.mbds.estia.lecoincoin_estia_25_26.services;

import fr.mbds.estia.lecoincoin_estia_25_26.dtos.UserDto;
import fr.mbds.estia.lecoincoin_estia_25_26.mappers.UserMapper;
import fr.mbds.estia.lecoincoin_estia_25_26.model.GrantedAuthorityImpl;
import fr.mbds.estia.lecoincoin_estia_25_26.model.User;
import fr.mbds.estia.lecoincoin_estia_25_26.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
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

    @Override
    @Transactional
    public String saveUser(UserDto userDto) {
        User user = userRepository.findByMail(userDto.getMail()).orElse(null);
        if (user != null) {
            return "Already Exist";
        }

        user = userMapper.toEntity(userDto);
        GrantedAuthorityImpl grantedAuthority = new GrantedAuthorityImpl();
        grantedAuthority.setAuthority(userDto.getRole());
        user.setGrantedAuthorities(Collections.singletonList(grantedAuthority));

        // Encrypt password
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
        return "user Saved";
    }
}
