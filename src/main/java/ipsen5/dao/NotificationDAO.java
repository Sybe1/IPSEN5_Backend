package ipsen5.dao;

import ipsen5.dto.NotificationDTO;
import ipsen5.models.Notification;
import ipsen5.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Component
public class NotificationDAO {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationDAO(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public List<Notification> getAllNotifications() {
        return this.notificationRepository.findAll();
    }

    public void createNotification(NotificationDTO notificationDTO) {
        User user = this.userRepository.findById(notificationDTO.user.getId()).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Notification notification = new Notification(notificationDTO.message, LocalDateTime.now(), user);
        this.notificationRepository.save(notification);
    }

    public void deleteNotification(UUID notificationId) {
        this.notificationRepository.findById(notificationId).orElseThrow(() -> new RuntimeException("Notification not found"));
        this.notificationRepository.deleteById(notificationId);
    }

    public List<Notification> findByUserIdAndReadFalse(UUID userId) {
        return this.notificationRepository.findByUserIdAndReadFalse(userId);
    }

    public void markAsRead(UUID notificationId) {
        Notification notification = this.notificationRepository.findById(notificationId).orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        this.notificationRepository.save(notification);
    }
}
