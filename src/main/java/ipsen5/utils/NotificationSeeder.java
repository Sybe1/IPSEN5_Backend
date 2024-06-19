package ipsen5.utils;

import ipsen5.repository.NotificationRepository;
import ipsen5.repository.UserRepository;
import ipsen5.models.Notification;
import ipsen5.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

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