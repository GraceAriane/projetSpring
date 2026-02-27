
# 📚 Système de Gestion de Bibliothèque

Projet académique – Licence Développement Fullstack

## 👥 Travail en groupe

Ce projet est réalisé en équipe.
Merci de lire attentivement ce document avant de commencer à coder afin de respecter l’architecture et l’organisation définies.

---

# 🧩 Architecture du projet

Le projet est structuré en **monorepo** :

```
library-management-system/
│
├── backend/    → API REST (Spring Boot)
└── frontend/   → Application web (Angular)
```

---

# 🖥️ Backend – Spring Boot

Technologies utilisées :

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Security
* MySQL
* Maven

## 📌 Configuration requise

Avant de lancer le projet :

1. Installer MySQL
2. Créer une base de données nommée :

```sql
CREATE DATABASE library;
```

3. Vérifier que le fichier :

```
backend/src/main/resources/application.properties
```

contient la configuration correcte :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=root
spring.datasource.password=VOTRE_MOT_DE_PASSE

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Lancer le backend

Dans le dossier `backend` :

```bash
mvn clean spring-boot:run
```

Le serveur démarre sur :

```
http://localhost:8080
```

---

## 📂 Organisation du backend

Structure à respecter :

```
controller/   → Expose les endpoints REST
service/      → Contient la logique métier
repository/   → Interfaces JPA
model/        → Entités (Book, Member, Loan, etc.)
```

⚠️ Merci de respecter cette architecture pour garder le projet propre et cohérent.

---

# 🌐 Frontend – Angular

Technologies utilisées :

* Angular
* TypeScript
* Tailwind css

---

## ▶️ Lancer le frontend

Dans le dossier `frontend` :

```bash
npm install
ng serve
```

Accessible sur :

```
http://localhost:4200
```

---

# 📌 Répartition des tâches (à adapter)

Exemple d’organisation :

### 🔹 Backend

* Modélisation des entités (Book, Member, Loan)
* Création des repositories
* Implémentation des services
* Création des contrôleurs REST

### 🔹 Frontend

* Création des interfaces (liste des livres, formulaire d’ajout, etc.)
* Connexion à l’API backend
* Gestion des formulaires et validations

---

# 📘 Fonctionnalités prévues

* Gestion des livres (CRUD)
* Gestion des membres
* Gestion des emprunts
* Recherche de livres
* Historique des emprunts

---

# ⚠️ Bonnes pratiques à respecter

* Ne pas modifier le code d’un autre membre sans discussion
* Faire des commits clairs :

  ```
  feat: ajout de l'entité Book
  fix: correction endpoint Loan
  ```
* Toujours pull avant de push :

  ```
  git pull origin main
  ```

---

# 🎯 Objectif

Mettre en place une application complète de gestion de bibliothèque avec séparation claire :

* Frontend (Angular)
* Backend (Spring Boot)
* Base de données (MySQL)


