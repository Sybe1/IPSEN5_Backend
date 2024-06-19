package ipsen5.utils;

import ipsen5.dao.PostRepository;
import ipsen5.dao.ReactionRepository;
import ipsen5.models.Notification;
import ipsen5.models.Post;
import ipsen5.models.Reaction;
import ipsen5.models.User;
import ipsen5.dao.NotificationRepository;
import ipsen5.dao.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class NotificationSeeder {

    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;

    public NotificationSeeder(UserRepository userRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    public void seedNotification(){
        List<User> allUsers = userRepository.findAll();

        Notification notification = new Notification();
        notification.setMessage("Dit is een notificatie");
        notification.setRead(false);
        notification.setUser(allUsers.get(0));
        notification.setTimestamp(LocalDateTime.now());
        this.notificationRepository.save(notification);
    }
}