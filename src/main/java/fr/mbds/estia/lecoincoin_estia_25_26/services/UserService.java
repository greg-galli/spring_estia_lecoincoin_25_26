package fr.mbds.estia.lecoincoin_estia_25_26.services;

import fr.mbds.estia.lecoincoin_estia_25_26.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    List<User> getAllUsers();
    User createUser(User user);
    void deleteUser(User user);
    User save(User user);
}
