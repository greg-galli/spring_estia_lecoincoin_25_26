package fr.mbds.estia.lecoincoin_estia_25_26.controllers;

import fr.mbds.estia.lecoincoin_estia_25_26.dtos.UserDto;
import fr.mbds.estia.lecoincoin_estia_25_26.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id)
    {
        return userService.getUser(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user)
    {
        return userService.createUser(user);
    }
}
