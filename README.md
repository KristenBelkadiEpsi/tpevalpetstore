# tp éval petstore

## structure

- le package ```entity``` regroupe les entitées de la base de donnée.
- le package ```enums``` regroupe différents types enum utilisés pour les attriobuts des entitées.
- le fichier ```src/main/resources/META-INF/persistence.xml``` gère les différentes options pour la base de données.

## consignes 

- la classe principale ```App``` permet de générer la base de donnée ainsi que d'éffectuer les requêtes demandées.
- la classe principale ```ConnectionDatabase``` permet de se connecter via une interface web (
  url: ```http://127.0.0.1:9090```) à la base de donnée H2.
- ``App`` et ``ConnectionDatabase`` ne fonctionne pas en même temps
- pour se connecter à la base de donnée via l'interface web:
    - Configuration enregistrée: ```Generic H2 (Embedded)```
    - Pilote JDBC: ```org.h2.Driver```
    - URL JDBC : ```jdbc:h2:~/petstore```
    - Nom d'utilisateur : ```root```
    - Mot de passe : ```root```