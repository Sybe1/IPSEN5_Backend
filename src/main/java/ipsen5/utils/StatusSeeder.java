package ipsen5.utils;

import ipsen5.repository.StatusRepository;
import ipsen5.models.Status;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StatusSeeder {

    private final StatusRepository statusRepository;

    public StatusSeeder(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void seedStatus(){
        Status status = new Status();
        status.setStatus("Received");
        statusRepository.save(status);

        Status status2 = new Status();
        status2.setStatus("In Review...");
        statusRepository.save(status2);

        Status status3 = new Status();
        status3.setStatus("Approved");
        statusRepository.save(status3);

        Status status4 = new Status();
        status4.setStatus("Not Approved");
        statusRepository.save(status4);
    }
}
