package ipsen5.controller;

import ipsen5.services.NotificationService;
import ipsen5.dto.NotificationDTO;
import ipsen5.models.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://clownfish-app-5x89u.ondigitalocean.app"})
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('NOTIFICATION_POST') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<String> createNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationService.createNotification(notificationDTO);
        return ResponseEntity.ok("Created a new Notification");
    }

    @PostMapping("/createForRole/{role}")
    @PreAuthorize("hasAuthority('NOTIFICATION_POST') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('POSTEN')")
    public ResponseEntity<Map<String, String>> createNotificationForRole(@RequestBody NotificationDTO notificationDTO, @PathVariable String role) {
        this.notificationService.createNotificationForRole(notificationDTO, role);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Created new notifications for admins and mods");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('NOTIFICATION_DELETE') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('DELETEN')")
    public ResponseEntity<?> deleteNotification(@PathVariable UUID id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.ok("Deleted Notification with id " + id);
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasAuthority('NOTIFICATION_GET') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<List<Notification>> getUnreadNotificationsForUser(@PathVariable UUID userId) {
        List<Notification> notifications = notificationService.findByUserIdAndReadFalse(userId);
        return ResponseEntity.ok(notifications);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('NOTIFICATION_GET') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('GETTEN')")
    public ResponseEntity<String> testGetAll() {
        return ResponseEntity.ok("TEST");
    }

    @PutMapping("/markAsRead/{id}")
    @PreAuthorize("hasAuthority('NOTIFICATION_PUT') || hasAuthority('NOTIFICATION') || hasAuthority('ALL') || hasAuthority('PUTTEN')")
    public ResponseEntity<Map<String, String>> markNotificationAsRead(@PathVariable UUID id) {
        notificationService.markAsRead(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Marked Notification with id " + id + " as read");
        return ResponseEntity.ok(response);
    }

}