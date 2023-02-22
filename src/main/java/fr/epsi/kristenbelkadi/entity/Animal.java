package fr.epsi.kristenbelkadi.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Animal")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "birth", length = 50, unique = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;

    @Column(name = "couleur", length = 50, unique = false)
    private String couleur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animal", nullable = false)
    private PetStore petStore;

    public Animal() {

    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", birth=" + birth + ", couleur='" + couleur + '\'' + '}';
    }
}