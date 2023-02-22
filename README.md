# tp éval petstore


## structure
- le package ```entity``` regroupe les entitées de la base de donnée.
- le package ```enums``` regroupe différents types enum utilisés pour les attriobuts des entitées.
- le fichier ```src/main/resources/META-INF/persistence.xml``` gère les différentes options pour la base de données.

## consignes

- la classe principale ```App``` permet de générer la base de donnée ainsi que d'éffectuer les requêtes demandées.
- la classe principale ```ConnectionDatabase``` permet de se connecter via une interface web (url: ```http://127.0.0.1:9090```) à la base de donnée H2.