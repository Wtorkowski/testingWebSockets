package pl.honesit.springdemo.services;

import pl.honesit.springdemo.dto.RegistrationFormDTO;

public interface UserService {


    void registerUser(RegistrationFormDTO registrationForm);
}
