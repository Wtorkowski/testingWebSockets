package pl.honesit.springdemo.services.converters;

import pl.honesit.springdemo.domain.model.User;
import pl.honesit.springdemo.dto.RegistrationFormDTO;

public class ConverterFactory {


    public static User convertUser(RegistrationFormDTO registrationForm) {
        User user = new User();
        user.setFirstName(registrationForm.getFirstName());
        user.setLastName(registrationForm.getLastName());
        user.setUsername(registrationForm.getUsername());
        user.setPassword(registrationForm.getPassword());
        return user;
    }
}
