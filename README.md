---

# MapJpa

A **Spring Boot JPA Demo Application** with environment-specific configuration for **local development** and **production deployment on Railway**.
This project was mainly created to practice **Spring Boot + JPA + MySQL** and test **profile-based configuration management**.

---

## 📌 Project Overview

* **Framework:** Spring Boot 3.3.x
* **Database:** MySQL (local for dev, Railway-managed for prod)
* **Persistence Layer:** Spring Data JPA (Repository pattern)
* **Build Tool:** Maven
* **Deployment Target:** Railway cloud platform

The project demonstrates:

1. Using **Spring Profiles** (`dev`, `prod`) to separate environment-specific configs.
2. Mapping entities with **JPA & Hibernate**.
3. Externalizing database credentials for **secure deployments**.
4. Running on **Java 21** inside Railway containers.

---

## ⚙️ Tech Stack

* **Java:** 21
* **Spring Boot:** 3.3.4
* **Spring Data JPA** for ORM
* **MySQL 8**
* **Maven** for build lifecycle
* **Railway** for hosting

---

## 🗂️ Project Structure

```
MapJpa/
 ├── src/main/java/jpa/mapping/mapjpa
 │    ├── MapJpaApplication.java        # Spring Boot main entry
 │    ├── entity/                       # JPA entities
 │    ├── repository/                   # JPA repositories
 │    └── controller/                   # REST controllers
 ├── src/main/resources/
 │    ├── application.properties        # Common + profile activation
 │    ├── application-dev.properties    # Local dev DB configs
 │    └── application-prod.properties   # Railway DB configs
 └── pom.xml                            # Maven dependencies
```

---

## 🚀 Running Locally (Dev Profile)

1. Ensure you have **MySQL** running locally.
   Example schema:

   ```sql
   CREATE DATABASE mapjpa;
   CREATE USER 'devuser'@'localhost' IDENTIFIED BY 'devpassword';
   GRANT ALL PRIVILEGES ON mapjpa.* TO 'devuser'@'localhost';
   FLUSH PRIVILEGES;
   ```

2. Update `src/main/resources/application-dev.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/mapjpa
   spring.datasource.username=devuser
   spring.datasource.password=devpassword
   ```

3. Run with dev profile:

   ```bash
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
   ```

---

## 🌐 Deploying to Railway (Prod Profile)

1. Push code to GitHub.

2. Connect repo to [Railway](https://railway.app/).

3. Add **environment variables** in Railway:

   ```
   ENV=prod
   ```

   Railway automatically injects DB credentials for MySQL plugin, but if using manual setup, make sure they are present in `application-prod.properties`.

4. Railway builds using Maven and starts the app with:

   ```
   java -jar target/MapJpa-0.0.1-SNAPSHOT.jar
   ```

5. Logs can be checked with:

   ```
   railway logs
   ```

---

## 🔑 Profiles & Configurations

* **application.properties**
  Contains common properties and sets profile dynamically:

  ```properties
  spring.application.name=MapJpa
  spring.profiles.active=${ENV:dev}
  ```

* **application-dev.properties**
  Local MySQL connection + Hibernate config.

* **application-prod.properties**
  Railway MySQL connection + tuned Hibernate settings.

⚠️ **Important:** Don’t put inline comments on property values, Spring treats them as part of the value.

---

## 🛠️ Common Issues & Fixes

1. **App crashes on Railway with profile `prod`:**
   → Usually due to inline comments inside `application-prod.properties`.
   ✅ Fix by putting comments on their own lines.

2. **Always running in `dev` mode:**
   → Happens if `ENV` variable not set in Railway.
   ✅ Add `ENV=prod` in Railway environment settings.

3. **MySQL connection refused:**
   → Ensure DB is created, user exists, and credentials match.
   ✅ On Railway, check `MYSQLHOST`, `MYSQLUSER`, `MYSQLPASSWORD`, etc.

---

## 📝 Future To-Do

* [ ] Add example REST endpoints for testing CRUD operations.
* [ ] Create seed data / migrations with Flyway or Liquibase.
* [ ] Add integration tests.
* [ ] Improve error handling & logging.

---

## 📖 Why This Project Exists

This repo was made to:

* Practice Spring Data JPA mappings.
* Understand how to separate configs for local and cloud deployments.
* Test out **Railway deployment workflow** with Java 21 + Maven.

When you come back later, remember:
👉 The key learning here is **Spring Profiles** (`dev` vs `prod`) and how they control which DB the app connects to.

---

