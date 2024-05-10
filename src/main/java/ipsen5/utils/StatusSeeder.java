package ipsen5.utils;

import ipsen5.dao.PostRepository;
import ipsen5.dao.StatusRepository;
import ipsen5.dao.SubmissionRespository;
import ipsen5.dao.UserRepository;
import ipsen5.models.Status;
import org.springframework.stereotype.Component;

@Component
public class StatusSeeder {

    private StatusRepository statusRepository;


    public StatusSeeder(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void seedStatus(){
        Status status = new Status();
        status.setStatus("Confirmed");
        statusRepository.save(status);

        Status status2 = new Status();
        status2.setStatus("In Progress...");
        statusRepository.save(status2);

        Status status3 = new Status();
        status3.setStatus("Checked");
        statusRepository.save(status3);
    }
}
