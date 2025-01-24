---
**Nom :** Adam Sabor  
**Prénom :** Adam  
**Date :** [Date]  
**Épreuve :** E5 - BTS SIO SLAM  
---

# Compte Rendu de Projet

## Modifications Apportées

- **Modification de la classe `Arret` :**  
  - Ajout de l'énumération `TypeArret` pour mieux gérer les types d'arrêt.

- **Mise à jour de la base de données :**  
  - Ajout de l'énumération `TypeArret` dans la table `arret` pour correspondre aux nouvelles exigences métier.

- **Adaptation de la couche DAO et des tests associés :**  
  - Les méthodes de la DAO ont été mises à jour afin de prendre en compte le nouveau type d'arrêt.  
  - Les tests unitaires ont été revus et ajustés en conséquence.

- **Création de la vue d'ajout d'arrêt :**  
  - Implémentation de la vue `ajoutArret-view.fxml` pour permettre l'ajout d'un arrêt.  
  - Création du contrôleur associé `AjoutArretController` afin de gérer les interactions utilisateur.

## Problèmes Rencontrés et Solutions Apportées

- **Problème :** L'ancienne DAO ne prenait pas en compte le type d'arrêt.  
  **Solution :** Refactoring de la DAO pour inclure la gestion de l'énumération.

- **Problème :** Ajustement de la vue pour correspondre aux nouvelles exigences.  
  **Solution :** Réorganisation des champs et validation des données dans le contrôleur.

---

## Difficultés Rencontrées

Je n'ai pas réussi à faire fonctionner la vue en raison d'une erreur JDBC. 
Cette erreur est regrettable car, à part ce problème de connexion, le reste de l'application devrait fonctionner comme prévu.



