#  Projet Microservices Bibliothèque 
### Auteurs : Rida ADARDOUR et Tarek OMARI

## Présentation

Ce projet met en œuvre une architecture complète pour la gestion d’une bibliothèque :
- Génération automatique d’emprunts toutes les 30 secondes
- Stockage relationnel (PostgreSQL)
- Bus de messages Kafka
- Stockage objet MinIO
- Orchestration avec Docker

---

## Schéma d’architecture

![Architecture du projet](images/architecture.png)  
*Architecture globale : l’utilisateur communique avec l’API, qui échange avec PostgreSQL, Kafka et MinIO.*

---

## 1. Compilation et déploiement du projet

- **Compilation du projet Maven**  
  ![Maven Clean Install](images/fig1.png)  
  *Lancement du build Maven (clean install) dans IntelliJ.*

- **Build Success**  
  ![Build Success](images/fig2.png)  
  *Résultat de la compilation : BUILD SUCCESS.*

---

## 2. Démarrage de l’infrastructure

- **Démarrage des conteneurs Docker**  
  ![Containers Started](images/fig3.png)  
  *Tous les conteneurs sont bien démarrés.*

- **Liste des conteneurs Docker**  
  ![docker ps](images/fig4.png)  
  *Liste détaillée des conteneurs actifs avec `docker ps`.*

---

## 3. Lancement de l’application Spring Boot

- **Démarrage de l’application**  
  ![Lancement Spring Boot](images/fig5.png)  
  *Lancement de l’application via IntelliJ.*

- **Application démarrée avec succès**  
  ![Application Ready](images/fig6.png)  
  *L’application Spring Boot est prête et fonctionne.*

- **Logs de génération d’emprunts**  
  ![Logs Emprunt](images/fig7.png)  
  *Chaque emprunt est généré automatiquement, envoyé à Kafka et MinIO.*

---

## 4. Monitoring Kafka dans IntelliJ

- **Inspection du topic Kafka "emprunts"**  
  ![Kafka Topic](images/fig8.png)  
  *Topic `emprunts` visible dans l’extension Kafka d’IntelliJ.*

- **Vue du Consumer Group**  
  ![Kafka Consumer Group](images/fig9.png)  
  *Le consumer group `biblio-group` consomme les messages du topic `emprunts`.*

---

## 5. Accès aux données dans PostgreSQL

- **Table `emprunt` avec les données générées**  
  ![Table Emprunt](images/fig10.png)  
  *Contenu de la table `emprunt` dans DataGrip.*

- **Explorateur de base de données**  
  ![Database Explorer](images/fig11.png)  
  *Les trois tables du modèle : livre, adherent, emprunt.*

- **Schéma relationnel**  
  ![Schéma relationnel](images/fig12.png)  
  *Relations entre les tables du modèle.*

---

## 6. Monitoring Kafka en CLI

- **Lecture des messages Kafka via le shell**  
  ![Kafka Shell Consumer](images/fig13.png)  
  *Affichage des messages JSON du topic `emprunts` dans le terminal du conteneur Kafka.*

---

## 7. MinIO : stockage objet

- **Page de login MinIO**  
  ![Login MinIO](images/fig14.png)  
  *Console web MinIO (localhost:9001) : accès à l’administration.*

- **Bucket `biblio` rempli d’emprunts**  
  ![Bucket MinIO](images/fig15.png)  
  *Tous les emprunts sont stockés en fichiers `.txt` dans le bucket `biblio` sur MinIO.*

---

## 8. Arborescence du projet

![Login MinIO](images/fig16.png)

---

## Conclusion

> Ce projet montre comment automatiser la gestion d’une bibliothèque grâce à une architecture microservices moderne :
> - génération d’évènements
> - persistance relationnelle
> - communication asynchrone (Kafka)
> - stockage objet distribué
---
##  Exécution rapide

```bash
# 1. Cloner le projet
git clone git repository
cd ferrovia

# 2. Lancer les services Docker (Postgres, Kafka, Zookeeper, MinIO)
docker-compose up -d

# (Optionnel) Vérifier les conteneurs
docker ps

# 3. Compiler le projet Spring Boot
mvn clean install

# 4. Lancer l’application (choisir une des deux commandes)
./mvnw spring-boot:run
# ou
mvn spring-boot:run

# 5. (Après usage) Stopper tous les services
docker-compose down




