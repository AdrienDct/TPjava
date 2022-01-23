# Projet Java - Adrien Duchâtel 3DA

![Earth](https://user-images.githubusercontent.com/97739867/150701543-a12090eb-45d5-4618-8c7a-9184087933b6.PNG)

----

## Réalisations : 
- [x] Class Aeroport         : constructeur et getters.
- [x] Class World            : constructeur, calcul de distance et recherche d'aéroport.
- [x] Class Earth            : constructeur, création de Sphère et affichage de sphère rouge.
- [x] Class Interface        : création des éléments, interactions avec l'utilisateur (zoom, recherche d'aéroports)
- [x] Class Flight           : constructeur.
- [x] Class JsonFlightFiller : récupération des données dans le JSON, création de flights.

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


