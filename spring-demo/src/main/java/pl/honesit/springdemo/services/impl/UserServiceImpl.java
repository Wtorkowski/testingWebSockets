package pl.honesit.springdemo.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.honesit.springdemo.domain.model.User;
import pl.honesit.springdemo.domain.repositories.UserRepository;
import pl.honesit.springdemo.dto.RegistrationFormDTO;
import pl.honesit.springdemo.services.UserService;
import pl.honesit.springdemo.services.converters.ConverterFactory;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegistrationFormDTO registrationForm) {
        User userToRegister = ConverterFactory.convertUser(registrationForm);
        userToRegister.setPassword(passwordEncoder.encode(userToRegister.getPassword()));
        userRepository.save(userToRegister);
    }
}
