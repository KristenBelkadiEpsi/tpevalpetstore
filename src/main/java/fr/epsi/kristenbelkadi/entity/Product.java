package fr.epsi.kristenbelkadi.entity;

import java.util.Set;

import fr.epsi.kristenbelkadi.enums.ProdType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Product")
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code", length = 50, unique = false)
    private String code;

    @Column(name = "label", length = 50, unique = false)
    private String label;

    @Column(name = "prodType", length = 50, unique = false)
    @Enumerated
    private ProdType prodType;

    @Column(name = "price", length = 50, unique = false)
    private Double price;

    @ManyToMany
    Set<PetStore> petStores;


    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", code='" + code + '\'' + ", label='" + label + '\'' + ", prodType=" + prodType + ", price=" + price + '}';
    }
}
