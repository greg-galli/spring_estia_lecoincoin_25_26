package fr.mbds.estia.lecoincoin_estia_25_26.controllers;

import fr.mbds.estia.lecoincoin_estia_25_26.dtos.UserDto;
import fr.mbds.estia.lecoincoin_estia_25_26.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

    UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }


    @PostMapping("/register")
    public String processRegistration(
            @Valid @ModelAttribute("userDto") UserDto userDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (userService.findByMail(userDto.getMail()) != null) {
            bindingResult.rejectValue("mail", "error.user", "Un compte avec cet email existe déjà.");
        }

        if (userService.findByPseudo(userDto.getPseudo()) != null) {
            bindingResult.rejectValue("pseudo", "error.user", "Ce pseudo est déjà utilisé.");
        }

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.saveUser(userDto);

        redirectAttributes.addFlashAttribute("registrationSuccess", "Inscription réussie ! Vous pouvez maintenant vous connecter.");

        return "redirect:/login";
    }
}
