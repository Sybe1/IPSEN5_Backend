package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
public class Rights {
    @GeneratedValue
    @Id
    private UUID id;
    private String name;

    public Rights(){

    }

    public Rights(String name){
        this.name = name;
    }

}
