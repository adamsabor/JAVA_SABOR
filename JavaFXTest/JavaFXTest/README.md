# Explication d'un projet

adam sabor
vendredi 29 novembre 2024 

Ne jamais toucher au dossier .idea sauf si gros problème projet pour recommencer on dois le supprimer

pom.xml: fichier qui permet de :
- gerer la compilation et l'execution du projet
- permet de gérer les dependances(librairies necessaire ajouter)

[module-info.java](src/main/java/module-info.java) = directive des dépendances entre javafx et les packages java utiles
target/: dossier de sortie des classses compilées
si on a modifie quelque chose et qu'on souhzite forcer  une nouvel compilation delet dossier target et relancer le programme 

tous les fichiers`.fxml décrivent un panel (plateeau d'une dcertaine organisation pour y ajouter des objets graphiques)