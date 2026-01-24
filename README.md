# Building a CRUD Mobile App with Kotlin and Jetpack Compose

Building a **CRUD (Create, Read, Update, Delete)** mobile app with **Kotlin and Jetpack Compose** is the recommended modern approach for Android development.  
Best practice involves using a **single-activity MVVM architecture** with **Jetpack Room** for local data persistence.

---

## Core Technologies

- **Kotlin**  
  The official and preferred language for Android development, known for its conciseness, null-safety, and modern features.

- **Jetpack Compose**  
  Android’s modern, declarative UI toolkit that simplifies and accelerates UI development with less code.

- **MVVM (Model–View–ViewModel)**  
  A robust architectural pattern that separates UI logic from business logic, improving maintainability and testability.

- **Jetpack Room**  
  An abstraction layer over SQLite that simplifies database interactions through a type-safe API and compile-time SQL validation.

- **Coroutines / Flow**  
  Kotlin’s mechanism for managing background tasks and handling asynchronous data streams, essential for database operations.

- **Hilt / Dagger (Optional)**  
  A dependency injection framework that helps manage dependencies and maintain a clean architecture.

---

## Step-by-Step Implementation Overview

A typical CRUD application built with these technologies follows a **layered architecture**.

---

## 1. Set Up Your Project

1. Start a new Android Studio project and select the **Empty Activity** template
    - Defaults to **Kotlin** and **Jetpack Compose**.

2. Add the required dependencies in `build.gradle.kts`:
    - Jetpack Compose
    - Room
    - ViewModel
    - Coroutines (and Flow)

---

## 2. Define the Data Layer

### 2.1 Entity
- Create a Kotlin **data class** representing your data model.
- Annotate it with `@Entity` to define a database table.

### 2.2 DAO (Data Access Object)
- Create an interface annotated with `@Dao`.
- Define CRUD operations using:
    - `@Insert`
    - `@Query`
    - `@Update`
    - `@Delete`

### 2.3 Database
- Create an abstract class extending `RoomDatabase`.
- Link **Entities** and **DAOs**.
- Use a `companion object` to provide a **singleton** database instance via `Room.databaseBuilder`.

---

## 3. Implement the Domain / Repository Layer

- Create a **Repository** class that abstracts data sources (Room DAO or remote APIs).
- This layer:
    - Handles business and data logic
    - Exposes data as `Flow` streams for asynchronous observation

---

## 4. Create the ViewModel

- Acts as the bridge between **UI** and **data layers**.
- Responsibilities:
    - Holds UI state
    - Executes business logic
- Uses **Coroutines** to perform background operations.
- Exposes data via:
    - `StateFlow` (recommended)
    - or `LiveData`

---

## 5. Build the UI with Jetpack Compose

### 5.1 Composable Functions
- Design the UI using `@Composable` functions.

### 5.2 UI Components
- Common composables include:
    - `TextField`
    - `Button`
    - `LazyColumn`
    - `Card`, `Scaffold`, etc.

### 5.3 State Observation
- The UI observes state from the **ViewModel**.
- Automatically updates when data changes.
- Follows **unidirectional data flow**.

### 5.4 Best Practice
- **Do not place business logic in composables**.
- Composables should only:
    - Read state
    - Display UI
    - Forward user events to the ViewModel

---

## Summary

Using **Kotlin + Jetpack Compose + MVVM + Room + Coroutines** provides a modern, scalable, and maintainable foundation for Android CRUD applications.  
This architecture ensures clean separation of concerns, responsive UI updates, and efficient data handling.