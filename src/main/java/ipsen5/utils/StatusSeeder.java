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
        UUID id = UUID.fromString("f47ac10b-58cc-4372-a567-0e02b2c3d479");
        status.setId(id);
        status.setStatus("Received");
        statusRepository.save(status);

        Status status2 = new Status();
        UUID id1 = UUID.fromString("c56a4180-65aa-42ec-a945-5fd21dec0538");
        status2.setId(id1);  // Use status2 to set id
        status2.setStatus("In Review...");
        statusRepository.save(status2);

        Status status3 = new Status();
        UUID id2 = UUID.fromString("0e984725-c51c-4bf4-9960-e1c80e27aba0");
        status3.setId(id2);
        status3.setStatus("Approved");
        statusRepository.save(status3);

        Status status4 = new Status();
        UUID id3 = UUID.fromString("7f4e26d0-4c3a-11e9-910e-1fa0f49bbb4f");
        status4.setId(id3);
        status4.setStatus("Not Approved");
        statusRepository.save(status4);
    }
}
