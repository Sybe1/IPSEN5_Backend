package ipsen5.services;

import ipsen5.dto.StatusDTO;
import ipsen5.models.Status;
import ipsen5.repository.StatusRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
    public List<Status> getAllStatus() {
        return this.statusRepository.findAll();
    }
    public void createStatus(StatusDTO statusDTO) {
        this.statusRepository.save(new Status(statusDTO.id, statusDTO.status));
    }
    public void editStatus(UUID id, StatusDTO statusDTO) {
        Status status = this.statusRepository.findById(id).orElseThrow(() -> new RuntimeException("Status not found"));
        status.setStatus(statusDTO.status);
        status.setStatus(statusDTO.status);
        this.statusRepository.save(status);
    }

    public void deleteStatus(UUID id) {
        this.statusRepository.findById(id).orElseThrow(() -> new RuntimeException("Status not found"));
        this.statusRepository.deleteById(id);
    }
}
