---
title: Modèle relationnel Sabor Adam

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



# Adam Sabor 6 requete
### 1. Récupérer l'utilisateur (toutes les colonnes) qui a un login = 'Adam'
```sql
SELECT id,login,mdp,nom,prenom,role,date_embauche FROM Utilisateur WHERE login = 'Adam';
```

### 2. Lister les utilisateurs qui sont admin
```sql
SELECT id,login,mdp,nom,prenom,role,date_embauche FROM Utilisateur WHERE role = 'ADMIN';
```

### 3. Récupérer les trajets sur une période
```sql
SELECT code,temps_depart,temps_arrive,arret_depart_id,arret_arrivee_id, FROM TRAJET WHERE temps_depart BETWEEN <date1> AND <date2> AND temps_arrivee BETWEEN <date1> AND <date2>;
```

### 4. (a) Ajouter un employé avec toutes les informations
```sql
INSERT INTO Utilisateur (id,login,mdp,nom,prenom,role,date_embauche) 
VALUES ('ADAM','Sabor', 'Adam', 'saboradam5@gmail.com', SHA2 ('ADAM',password123,256), '2003-05-05', 'ADMIN',<date>)
```

### 4. (b) Supprimer un employé avec id ou login
```sql
DELETE FROM Utilisateur WHERE id = 5 OR DELETE FROM Utilisateur WHERE iemail = 'login@example.com'

### 5. Modifier le temps d'arrivée d'un trajet avec son code
                                                                
```sql
UPDATE Trajet SET tempsarrive = <nouvelledate>,tempsDepart='<nouvelledate2>'&é"'(....) WHERE id = 3;
```



