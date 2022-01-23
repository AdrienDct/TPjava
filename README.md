# Projet Java - Adrien Duchâtel 3DA

![Earth](https://user-images.githubusercontent.com/97739867/150701543-a12090eb-45d5-4618-8c7a-9184087933b6.PNG)

----

## Réalisations : 
- [x] Class Aeroport         : constructeur et getters.
- [x] Class World            : constructeur, calcul de distance et recherche d'aéroport.
- [x] Class Earth            : constructeur, création de Sphère et affichage de sphère rouge.
- [x] Class Interface        : création des éléments, interactions avec l'utilisateur (zoom, recherche d'aéroports)
- [x] Class Flight           : constructeur.
- [x] Class JsonFlightFiller : récupération des données dans le JSON, création de flights et ajout à la liste.

## Elements non-réalisés : 
- [ ] Classe Earth           : bon placement et rotation des sphères rouges, création de sphères jaunes.
> Le placement des sphères rouges est aléatoire et la plupart du temps les sphères se créent à l'intérieur de la Terre. Je n'ai pas réussi à trouver comment les placer au bon endroit.
> Les sphères rouges ne tournent pas avec la terre, j'ai réussi à les faire tourner sur elles-mêmes mais pas par rapport à la terre.
> Les sphères jaunes ne sont pas crées sur la terre, manque de temps pour le réaliser.
- [ ] Class JsonFlightFiller : requête via l'API aviationsStack, affichage des aéroports de départ.
> Manque de temps pour réaliser les requêtes sur l'API.
> L'appel de l'affichage des boules jaunes n'a donc pas non plus être réalisé.

----

## Erreurs et debug : 
### Placement des boules rouges
Le placement des boules rouges est aléatoire. Je leur ai donné une taille de 50 pour qu'elles soient plus facilement repérables si elles ne sont pas crées à l'intérieur de la terre.
Nous pouvons voir lors d'un clic qu'il est retourné dans la console :
 1. l'aéroport le plus proche
 2. La valeur de X, calculée à partir de la longitude et latitude de l'aéroport.
 3. La valeur de Y, idem.
 4. La valeur de Z, idem.

Les valeurs de X, Y et Z devraient placer la boule rouge sur la terre au bon emplacement, mais comme on peut le voir sur le screen ci-dessous, des boules ne sont pas collés à la terre, d'autre sont à l'intérieur, et jamais à proximité de l'endroit du clic.

![RedBalls](https://user-images.githubusercontent.com/97739867/150701642-2b95dc65-7e3f-411a-a0d8-d627af885b2f.PNG)

De plus, je n'ai pas réussi à faire tourner ces boules en même temps que la rotation de la terre.
Après plusieurs heures de recherches j'ai abandonné et décidé de continuer sur le reste du TP.


### Le chemin de la texture de la sphère
Ci-dessous, extrait de la classe "main" appelant le constructeur Earth pour créer la sphère terre et appliquer la texture dessus.

![path](https://user-images.githubusercontent.com/97739867/150702436-226c55f9-244c-41b9-97df-08aa4bf96e9d.PNG)

On peut voir que cette texture n'est pas dans le dossier "data", ou il aurait dû être, car en utilisant le chemin "./data/..." cela ne fonctionnait pas, pourtant c'est ce qui est utilisé pour joindre le csv des aéroports et le JSON.

----

## Principales difficultés : 
 - Le calcul de la distance entre deux aéroports, j'ai eu du mal à trouver la logique en comparant le premier aéroport de la liste avec les suivants, et en remplacant le "nearest" par le denrier aéroport le plus proche trouvé.
 - La rotation de la terre et plus spécifiquement la gestion de sa vitesse de rotation. 
 - Le placement des boules rouges ainsi que leur rotation avec la terre.
 - La recherche d'informations dans le JSON. Il m'a fallut du temps avant de comprendre la hiérarchie getJsonArray, getJsonObject, getString.

----

## Compétences acquises :
- Meilleure connaisance du code et de sa syntaxe de manière générale.
- Plus d'aisance et une meilleure compréhension des constructeurs, des listes, des getters, de l'interfacages entre les différentes classes et objets.
- Apprentissage du module JavaFx, de la création des objets corresspondants et leur modification.
- Meilleure connaisance de l'interface entre l'application et des actions utilisateurs.
- Apprentissage de la recherche d'éléments dans un JSON.
- Une meilleure compréhension de la programmation orienté objet.
