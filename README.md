Anime Recommender App
Overview

The Anime Recommender App is a Java console-based application that uses the Jikan API (an unofficial MyAnimeList API) to help users discover new anime based on their preferred genres.
Users can view anime suggestions, indicate whether they’ve seen a title, and build a personalized recommendation list. The app stores user data and anime information locally using an SQLite database for persistence.

Features

Genre-Based Recommendations
Users can select a genre (e.g., Action, Comedy, Romance, Horror, etc.), and the app fetches anime from the Jikan API in real time.

Interactive User Experience
The app interacts with the user in a loop, allowing them to:

Explore new anime by genre

Add unseen anime to their “Recommended List”

Return to the main menu anytime

Exit safely when finished

SQLite Database Integration
The app automatically creates and manages database tables for users, anime, and survey preferences using JDBC and SQLite.

Single-User Design
The current version is designed for a single user experience. However, a users table exists for potential expansion into a multi-user version in the future.

Project Structure
AnimeRecommenderApp/
│
├── src/
│   ├── Anime.java              # Defines the Anime model class
│   ├── Main.java               # Main entry point for the app
│   ├── JikanApiHandler.java    # Handles API requests to Jikan API
│   ├── DatabaseHandler.java    # Creates and manages the SQLite database
│   ├── RecommendedList.java    # Stores and displays user's recommended anime
│
├── lib/
│   └── json-20250517.jar       # JSON parsing library (required for API data)
│
└── anime_app.db                # SQLite database file (created automatically)

Installation and Setup
Requirements

Java 17+ (Java 21 or newer recommended)

VS Code or another Java IDE

SQLite (bundled automatically through JDBC — no manual setup required)

Add Dependencies

Download and include the json-20250517.jar file in your project:

Place it in the lib/ folder.

Add it to your classpath:

javac -cp ".;lib/json-20250517.jar" src/*.java
java -cp ".;lib/json-20250517.jar;sqlite-jdbc.jar" Main

How It Works

App Launch
The program greets the user and asks for their preferred anime genre.

Fetching Anime
The app connects to the Jikan API and fetches a list of anime under that genre.

User Interaction
The user is shown anime one by one and asked:

Have you seen this anime before? (yes/no)

If yes, it’s added to their Recommended List.

If no, the app moves on to another anime.

Database Storage
All anime and user preferences are stored locally in anime_app.db.

Menu Options
The user can:

Explore new genres

View their recommended list

Exit the app safely

Database Tables
Table	Purpose
users	Stores user information (future expansion)
anime	Stores anime details fetched from the API
survey	Stores user preferences like genre, popularity, and release type
Example Output
Welcome to the Anime Recommender!
Enter a genre you want to watch (e.g., Action, Comedy, Romance, Horror): Action

Fetching anime for genre: Action...
-------------------------------------
Title: Attack on Titan
Score: 8.8
URL: https://myanimelist.net/anime/16498
Have you seen this anime? (yes/no): no

Skipping... Moving to next suggestion.

-------------------------------------
Title: Demon Slayer
Score: 8.7
URL: https://myanimelist.net/anime/38000
Have you seen this anime? (yes/no): yes
Added to your Recommended List!

-------------------------------------
Would you like to:
1. Pick another genre
2. View your Recommended List
3. Exit
Enter your choice: 2

Your Recommended List:
- Demon Slayer (8.7)

Contributors

Developer: Chrisnel Rivera
Instructor Feedback: Haylee Liska

License

This project is open for educational use and personal development.
Data provided by the Jikan API
 — an unofficial MyAnimeList API.
