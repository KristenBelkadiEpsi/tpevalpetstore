package fr.epsi.kristenbelkadi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cat")
@Getter
@Setter
public class Cat extends Animal {
    @Column(name = "chipId", length = 50, unique = false)
    private String chipId;

    public Cat() {

    }

    @Override
    public String toString() {
        return "Cat{" + "chipId='" + chipId + '\'' + '}';
    }
}
