package ipsen5.utils;

import ipsen5.dao.UserRepository;
import ipsen5.models.User;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Seeder {
    private UserRepository userRepository;

    public Seeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener
    public void seed(){
        this.seedUser();
    }


    private void seedUser(){
        User user = new User();
        user.setEmail("test@mail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
        userRepository.save(user);
    }
}
