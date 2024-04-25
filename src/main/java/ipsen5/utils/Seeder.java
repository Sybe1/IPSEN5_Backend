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
    public void seed(ContextRefreshedEvent event){
        this.seedUser();
    }


    private void seedUser(){
        User user = new User();
        user.setFirst_name("Mick");
        user.setLast_name("van Amstel");
        user.setEmail("test@mail.com");
        user.setPassword(new BCryptPasswordEncoder().encode("Test123!"));
        user.setDonation_link("https://www.paypal.com/nl/home");
        userRepository.save(user);
    }
}
