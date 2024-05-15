package ipsen5.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    public Role (){
    }

    public Role(String name){
        this.name = name;
    }

}
