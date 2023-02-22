package fr.epsi.kristenbelkadi.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PetStore")
@Getter
@Setter

public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, unique = false)
    private String name;

    @Column(name = "managerName", length = 50, unique = false)
    private String managerName;

    @ManyToMany
    Set<Product> products;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "petStore")
    @PrimaryKeyJoinColumn
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "petStore")
    private Set<Animal> animals;

    public PetStore() {

    }

    @Override
    public String toString() {
        return "PetStore{" + "id=" + id + ", name='" + name + '\'' + ", managerName='" + managerName + '\'' + ", address=" + address + '}';
    }
}
