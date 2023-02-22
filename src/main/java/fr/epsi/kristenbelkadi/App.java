package fr.epsi.kristenbelkadi;

import fr.epsi.kristenbelkadi.entity.Address;
import fr.epsi.kristenbelkadi.entity.Animal;
import fr.epsi.kristenbelkadi.entity.Cat;
import fr.epsi.kristenbelkadi.entity.Fish;
import fr.epsi.kristenbelkadi.entity.PetStore;
import fr.epsi.kristenbelkadi.entity.Product;
import fr.epsi.kristenbelkadi.enums.FishLivEnv;
import fr.epsi.kristenbelkadi.enums.ProdType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.h2.tools.Server;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-jpa-petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Hello World!");
        // remplissage des tables
        Address address1 = new Address();
        Address address2 = new Address();
        Address address3 = new Address();
        PetStore petStore1 = new PetStore();
        PetStore petStore2 = new PetStore();
        PetStore petStore3 = new PetStore();

        address1.setNumber("1");
        address2.setNumber("2");
        address3.setNumber("3");
        address1.setStreet("Street1");
        address2.setStreet("Street2");
        address3.setStreet("Street3");
        address1.setZipCode("ZipCode1");
        address2.setZipCode("ZipCode2");
        address3.setZipCode("ZipCode3");
        address1.setCity("City1");
        address2.setCity("City2");
        address3.setCity("City3");
        address1.setPetStore(petStore1);
        address2.setPetStore(petStore2);
        address3.setPetStore(petStore3);


        petStore1.setName("PetStore1");
        petStore2.setName("PetStore2");
        petStore3.setName("PetStore3");
        petStore1.setManagerName("Manager1");
        petStore2.setManagerName("Manager2");
        petStore3.setManagerName("Manager3");
        petStore1.setAddress(address1);
        petStore2.setAddress(address2);
        petStore3.setAddress(address3);


        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();
        animal1.setBirth(new java.util.Date());
        animal1.setCouleur("red");
        animal1.setPetStore(petStore1);
        animal2.setBirth(new java.util.Date());
        animal2.setCouleur("blue");
        animal2.setPetStore(petStore2);
        animal3.setBirth(new java.util.Date());
        animal3.setCouleur("green");
        animal3.setPetStore(petStore3);

        petStore1.setAnimals(new HashSet<>(Arrays.asList(animal1)));
        petStore2.setAnimals(new HashSet<>(Arrays.asList(animal2)));
        petStore3.setAnimals(new HashSet<>(Arrays.asList(animal3)));

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        product1.setLabel("Product1");
        product2.setLabel("Product2");
        product3.setLabel("Product3");
        product1.setPrice(1.0);
        product2.setPrice(2.0);
        product3.setPrice(3.0);
        product1.setLabel("Product1");
        product2.setLabel("Product2");
        product3.setLabel("Product3");
        product1.setProdType(ProdType.FOOD);
        product2.setProdType(ProdType.CLEANING);
        product3.setProdType(ProdType.ACCESSORY);
        product1.setCode("Code1");
        product2.setCode("Code2");
        product3.setCode("Code3");
        product1.setPetStores(Collections.singleton(petStore1));
        product2.setPetStores(Collections.singleton(petStore2));
        product3.setPetStores(Collections.singleton(petStore3));


        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        cat1.setBirth(new java.util.Date());
        cat1.setCouleur("red");
        cat1.setPetStore(petStore1);
        cat1.setChipId("ChipId1");
        cat2.setBirth(new java.util.Date());
        cat2.setCouleur("blue");
        cat2.setPetStore(petStore2);
        cat2.setChipId("ChipId2");
        cat3.setBirth(new java.util.Date());
        cat3.setCouleur("green");
        cat3.setPetStore(petStore3);
        cat3.setChipId("ChipId3");

        Fish fish1 = new Fish();
        Fish fish2 = new Fish();
        Fish fish3 = new Fish();
        fish1.setBirth(new java.util.Date());
        fish1.setCouleur("red");
        fish1.setPetStore(petStore1);
        fish1.setLivingEnv(FishLivEnv.SEA_WATER);
        fish2.setBirth(new java.util.Date());
        fish2.setCouleur("blue");
        fish2.setPetStore(petStore2);
        fish2.setLivingEnv(FishLivEnv.FRESH_WATER);
        fish3.setBirth(new java.util.Date());
        fish3.setCouleur("green");
        fish3.setPetStore(petStore3);
        fish3.setLivingEnv(FishLivEnv.SEA_WATER);


        em.persist(address1);
        em.persist(address2);
        em.persist(address3);
        em.persist(petStore1);
        em.persist(petStore2);
        em.persist(petStore3);
        em.persist(animal1);
        em.persist(animal2);
        em.persist(animal3);
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(cat1);
        em.persist(cat2);
        em.persist(cat3);
        em.persist(fish1);
        em.persist(fish2);
        em.persist(fish3);
        em.getTransaction().commit();
        TypedQuery<Address> findAllAddress = em.createQuery("from Address", Address.class);
        for (Address a : findAllAddress.getResultList()) {
            System.out.println(a.getStreet());
        }
        Scanner lecture = new Scanner(System.in);
        System.out.println("saisir l'id de la animalerie dont vous voulez la liste des animaux");
        Long petStoreId = Long.valueOf(lecture.next());
        PetStore petStore = em.find(PetStore.class, petStoreId);
        System.out.printf("animalerie: %s\n", petStore);
        ;
        if (petStore == null) {
            System.out.println("l'animalerie n'éxiste pas ");
        } else {
            System.out.println(petStore.getAnimals());
        }

        em.close();
        emf.close();


    }
}
