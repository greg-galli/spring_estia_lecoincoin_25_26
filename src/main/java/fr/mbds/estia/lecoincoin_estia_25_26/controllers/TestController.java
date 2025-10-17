package fr.mbds.estia.lecoincoin_estia_25_26.controllers;

import fr.mbds.estia.lecoincoin_estia_25_26.dtos.UserDto;
import fr.mbds.estia.lecoincoin_estia_25_26.mappers.UserMapper;
import fr.mbds.estia.lecoincoin_estia_25_26.repositories.UserRepository;
import fr.mbds.estia.lecoincoin_estia_25_26.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/submit")
    public String submit(@Validated UserDto userDto, BindingResult bindingResult) {
        userService.save(userDto);
        return "test/submit";
    }

    @RequestMapping("/form")
    public String form(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "test";
    }
}
