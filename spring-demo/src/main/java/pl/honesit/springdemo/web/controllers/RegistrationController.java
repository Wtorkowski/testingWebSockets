package pl.honesit.springdemo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.honesit.springdemo.dto.RegistrationFormDTO;
import pl.honesit.springdemo.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "registration";
    }

    @PostMapping
    public String processRegistrationPage(@Valid @ModelAttribute("registrationForm") RegistrationFormDTO registrationForm, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.registerUser(registrationForm);
        return "redirect:/hello.jsp";
    }
}
