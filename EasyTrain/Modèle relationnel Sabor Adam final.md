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
### 1. Récupérer l'utilisateur qui a login = ... et un mdp = ...
 SELECT id, login, mdp, nom, prenom, role, date_embauche,
FROM utilisateur
WHERE login='unloginparticulier'
AND mdp = SHA2 ('lemdpsaisie' 256);


### 2. Lister les utilisateurs qui sont admin
SELECT id, login, mdp, nom, prenom, role, date_embauche
FROM utilisateur
WHERE role='ADMIN';


### 3. Récupérer les trajets sur une période
SELECT code, tempsDepart, tempsArrivee, arretDepart_id, arretArrivee_id, ad.nom as nomAD, ad.id as idAD,
aa.nom as nomAA, aa.id as idAA
FROM arret ad JOIN trajet t ON ad.id=t.arretDepart_id
               JOIN = Arret aa ON t.arretArrivee_id=aa.id
WHERE temps_depart BETWEEN '<date1>' AND '<date2>'
   AND temps_arrivee BETWEEN '<date1>' AND '<date2>'

### 4. (a) Ajouter un employé avec toutes les informations
INSERT INTO utilisateur (login, mdp, nom, prenom, role, date_embauche)
VALUES ('leLogin', SHA2('leLogin', 256), 'leNom', 'leprenom', 'EMPLOYE', '<date>')


### 4. (b) Supprimer un employé avec id ou login
DELETE FROM utilisateur WHERE id =3 ou
DELETE FROM utilisateur WHERE login ='leLogin'


### 5. Modifier le temps d'arrivée d'un trajet avec son code
UPDATE trajet SET tempsArrivee='<nouvelledate>', tempsDepart='<nouvelledate2>'[,...]
   WHERE code='LeCode';


