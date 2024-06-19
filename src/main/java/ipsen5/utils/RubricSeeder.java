package ipsen5.utils;

import ipsen5.repository.RubricRepository;
import ipsen5.models.Rubric;
import org.springframework.stereotype.Component;

@Component
public class RubricSeeder {

    private final RubricRepository rubricRepository;

    public RubricSeeder(RubricRepository rubricRepository) {
        this.rubricRepository = rubricRepository;
    }

    public void seedRubric(){
        Rubric rubric = new Rubric();
        rubric.setTitle("Text Rubric");
        rubricRepository.save(rubric);

        Rubric rubric2 = new Rubric();
        rubric2.setTitle("Audio Rubric");
        rubricRepository.save(rubric2);

        Rubric rubric3 = new Rubric();
        rubric3.setTitle("Video Rubric");
        rubricRepository.save(rubric3);
    }
}
