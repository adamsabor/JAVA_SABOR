---
Modèle relationnel Sabor Adam

---

# Mission EasyTrain
Sabor Adam Bts sio / fait en septembre 2024

# Modèle Relationnel

## Table : Utilisateur
- **id** : `INT(3)`  
  - Clé primaire, auto-incrément
- **login** : `VARCHAR(30)`  
  - Not null, Unique
- **mdp** : `VARCHAR(256)`  
  - Not null
- **nom** : `VARCHAR(30)`  
  - Not null
- **prenom** : `VARCHAR(30)`  
  - Not null
- **dateEmbauche** : `DATETIME`  
  - Not null
- **role** : `ENUM('ADMIN', 'EMPLOYE')`  
  - Not null

---

## Table : Arret
- **id** : `INT(3)`  
  - Clé primaire, auto-incrément
- **nom** : `VARCHAR(30)`  
  - Not null

---

## Table : Trajet
- **code** : `VARCHAR(50)`  
  - Clé primaire
- **tempsDepart** : `DATETIME`  
  - Not null
- **tempsArrivee** : `DATETIME`  
  - Not null
- **arretDepart_id** : `INT(3)`  
  - Clé étrangère, référence à `Arret(id)`
- **arretArrivee_id** : `INT(3)`  
  - Clé étrangère, référence à `Arret(id)`

---
## requetes BDD potentielles
1. recuperer l'utilisateurs qui a un login = ....
   
3. lister les utilisateurs qui sont Admin
4. recuperer tout les trajets sur une une periode
5.a- Ajout d'un employé avec toute les infob- supprimer un employé avec id ou login
6. modifier le temps d'arriver d'un trajet avec son code



