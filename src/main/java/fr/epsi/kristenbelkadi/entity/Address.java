package fr.epsi.kristenbelkadi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Address")
@Getter
@Setter

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", length = 50, unique = false)
    private String number;

    @Column(name = "street", length = 50, unique = false)
    private String street;

    @Column(name = "zipCode", length = 50, unique = false)
    private String zipCode;

    @Column(name = "city", length = 50, unique = false)
    private String city;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private PetStore petStore;

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", number='" + number + '\'' + ", street='" + street + '\'' + ", zipCode='" + zipCode + '\'' + ", city='" + city + '\'' + '}';
    }
}
