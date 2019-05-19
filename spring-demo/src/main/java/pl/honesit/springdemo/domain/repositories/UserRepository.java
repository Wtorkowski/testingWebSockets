package pl.honesit.springdemo.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.honesit.springdemo.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
