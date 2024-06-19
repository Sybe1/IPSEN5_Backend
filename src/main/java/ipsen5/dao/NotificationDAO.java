package ipsen5.dao;

import ipsen5.dto.NotificationDTO;
import ipsen5.models.Notification;
import ipsen5.models.Role;
import ipsen5.models.User;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
public class NotificationDAO {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public NotificationDAO(NotificationRepository notificationRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    public void createNotificationForRole(NotificationDTO notificationDTO, String role) {
        Role tempRole = this.roleRepository.findByName(role).orElse(null);
        if (tempRole == null) {
            throw new RuntimeException("Role not found");
        }
        List<User> usersWithRole = this.userRepository.findByRole(tempRole);
        for (User user : usersWithRole) {
            Notification notification = new Notification(notificationDTO.message, LocalDateTime.now(), user);
            this.notificationRepository.save(notification);
        }
    }
}
