---
title: Modèle relationnel de la base de données `EasyTrain`

---

# Modèle relationnel `EasyTrain`
### Réalisé par : Adam Sabor,BTS SIO

## Tables

### 1. Arret

| Colonne  | Type        | Contraintes            |
|----------|-------------|------------------------|
| id       | int(11)     | PRIMARY KEY, AUTO_INCREMENT |
| nom      | varchar(100) | NULLABLE               |
| ville    | varchar(100) | NULLABLE               |

### 2. Trajet

| Colonne     | Type    | Contraintes            |
|-------------|---------|------------------------|
| id          | int(11) | PRIMARY KEY, AUTO_INCREMENT |
| heureDepart | time    | NULLABLE               |

### 3. Trajet_Arret

| Colonne    | Type    | Contraintes            |
|------------|---------|------------------------|
| trajet_id  | int(11) | PRIMARY KEY, FOREIGN KEY (`trajet_id`) REFERENCES `Trajet(id)` |
| arret_id   | int(11) | PRIMARY KEY, FOREIGN KEY (`arret_id`) REFERENCES `Arret(id)`  |

### 4. Utilisateur

| Colonne         | Type          | Contraintes            |
|-----------------|---------------|------------------------|
| id              | int(11)       | PRIMARY KEY, AUTO_INCREMENT |
| nom             | varchar(100)  | NULLABLE               |
| prenom          | varchar(100)  | NULLABLE               |
| email           | varchar(100)  | NULLABLE               |
| motDePasse      | varchar(100)  | NULLABLE               |
| dateDeNaissance | date          | NULLABLE               |
| role            | enum('ADMIN', 'PASSAGER') | NULLABLE |
