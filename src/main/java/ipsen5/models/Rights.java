package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Rights {
    @GeneratedValue
    @Id
    private long id;
    private String name;

    public Rights(){

    }

    public Rights(String name){
        this.name = name;
    }

}
