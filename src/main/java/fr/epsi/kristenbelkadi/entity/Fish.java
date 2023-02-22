package fr.epsi.kristenbelkadi.entity;

import fr.epsi.kristenbelkadi.enums.FishLivEnv;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Fish")
@Getter
@Setter
public class Fish extends Animal {

    @Column(name = "livingEnv", length = 50, unique = false)
    @Enumerated
    private FishLivEnv livingEnv;

    public Fish() {

    }

    @Override
    public String toString() {
        return "Fish{" + "livingEnv=" + livingEnv + '}';
    }
}
