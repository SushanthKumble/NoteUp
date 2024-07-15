# Notes App

A simple and efficient notes app built using Kotlin, Dagger Hilt, Coroutines, Jetpack components, and following the MVVM architecture. This app allows users to add notes with priority, update existing notes, and delete notes.

## Features

- **Add Notes**: Create notes with a title, description, and priority.
- **Update Notes**: Modify existing notes with ease.
- **Delete Notes**: Remove notes that are no longer needed.
- **MVVM Architecture**: Clean and maintainable code structure.
- **Dependency Injection**: Using Dagger Hilt for managing dependencies.
- **Asynchronous Programming**: Using Kotlin Coroutines for background tasks.
- **Jetpack Components**: Utilizing LiveData, ViewModel, Room, Navigation, and other Jetpack libraries for a robust and lifecycle-aware application.

## Technologies Used

- **Kotlin**: The primary programming language used for Android development.
- **Dagger Hilt**: A dependency injection library for managing dependencies.
- **Coroutines**: A concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
- **XML**: Used for designing the user interface of the app.
- **Jetpack Components**: A suite of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices.
  - **LiveData**: Data objects that notify views when the underlying database changes.
  - **ViewModel**: Stores UI-related data that isn’t destroyed on app rotations.
  - **Room**: A persistence library that provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.
  - **Navigation**: A framework for navigating between fragments and activities.

## Screenshots

### Home Screen
![Home Screen](screenshots/home_screen.png)

### Add Note Screen
(others/113.png)

### Update Note Screen
others/112.png



## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/sushanthkumble/notes-app.git
