package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@Entity
public class Biography {

    @Id
    private int id;

    private String bio;

    public Biography(String bio) {
        this.bio = bio;
    }

    public Biography(int id, String bio) {
        this.id = id;
        this.bio = bio;
    }
}