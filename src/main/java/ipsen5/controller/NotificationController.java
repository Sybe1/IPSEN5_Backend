package ipsen5.controller;

import ipsen5.dao.NotificationDAO;
import ipsen5.dto.NotificationDTO;
import ipsen5.models.Notification;
import ipsen5.models.User;
import ipsen5.dao.NotificationRepository;
import ipsen5.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationDAO notificationDAO;

    public NotificationController(NotificationDAO notificationDAO) {
        this.notificationDAO = notificationDAO;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('NOTIFICATION_POST') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationDAO.createNotification(notificationDTO);
        return ResponseEntity.ok("Created a new Notification");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('NOTIFICATION_DELETE') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteNotification(@PathVariable UUID id) {
        notificationDAO.deleteNotification(id);
        return ResponseEntity.ok("Deleted Notification with id " + id);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('NOTIFICATION_GET') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Notification>> getUnreadNotificationsForUser(@PathVariable UUID userId) {
        List<Notification> notifications = notificationDAO.findByUserIdAndReadFalse(userId);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('NOTIFICATION_GET') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<String> testGetAll() {
        return ResponseEntity.ok("TEST");
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('NOTIFICATION_PUT') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('PUTTEN')")
    public ResponseEntity<String> markNotificationAsRead(@PathVariable UUID id) {
        notificationDAO.markAsRead(id);
        return ResponseEntity.ok("Marked Notification with id " + id + " as read");
    }

}