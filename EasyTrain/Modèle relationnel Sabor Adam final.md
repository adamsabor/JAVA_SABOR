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


#  requete SQL
### 1. Récupérer l'utilisateur (toutes les colonnes) qui a un login = ...
```sql
SELECT id,login,mdp,nom,prenom,date_embauche FROM Utilisateur WHERE login="Adam";
```

### 2. Lister les utilisateurs qui sont admin
```sql
SELECT * FROM Utilisateur WHERE role = 'ADMIN';
```

### 3. Récupérer les trajets sur une période
```sql
SELECT * FROM Trajet WHERE heureDepart BETWEEN '2024-01-01' AND '2024-12-31';
```

### 4. (a) Ajouter un employé avec toutes les informations
```sql
INSERT INTO Utilisateur (nom, prenom, email, motDePasse, dateDeNaissance, role) 
VALUES ('Dupont', 'Jean', 'jean.dupont@example.com', 'password123', '1990-04-15', 'EMPLOYE');
```

### 4. (b) Supprimer un employé avec id ou login
```sql
DELETE FROM Utilisateur WHERE id = 5 OR email = 'login@example.com';
```

### 5. Modifier le temps d'arrivée d'un trajet avec son code
```sql
UPDATE Trajet SET heureDepart = '18:00:00' WHERE id = 3;
```



