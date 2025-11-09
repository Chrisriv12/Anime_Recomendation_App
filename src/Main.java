/*
 * Main.java
 * Entry point for the Anime Recommendation Application.
 * Name: Chrisnel Rivera
 * Date: 10/30/2025
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaliApiHandler api = new MaliApiHandler();
        List<Anime> recommendedList = new ArrayList<>();

        System.out.println("🎌 Welcome to the Anime Recommender!");

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1️  Search anime by genre");
            System.out.println("2️  View your recommended list");
            System.out.println("3️  Exit the program");
            System.out.print("Enter your choice (1-3): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("3")) {
                System.out.println("\n👋 Thanks for using the Anime Recommender! See you next time!");
                break;
            }

            switch (choice) {
                case "1":
                    while (true) {
                        System.out.print("\nEnter a genre you want to watch (e.g., Action, Comedy, Romance, Horror) or type 'back' to return: ");
                        String userGenre = scanner.nextLine().trim().toLowerCase();

                        if (userGenre.equals("back")) {
                            System.out.println("🔙 Returning to the main menu...");
                            break;
                        }

                        List<Anime> animeList = api.fetchAnimeByGenre(userGenre);

                        if (animeList.isEmpty()) {
                            System.out.println("  Sorry, no anime found for that genre.");
                            continue;
                        }

                        for (Anime anime : animeList) {
                            System.out.println("\n Title: " + anime.getTitle());
                            System.out.println(" Score: " + anime.getScore());
                            System.out.println(" Synopsis: " + anime.getSynopsis());
                            System.out.println(" More info: " + anime.getUrl());

                            System.out.print("\nHave you seen this anime? (yes/no/back): ");
                            String seen = scanner.nextLine().trim().toLowerCase();

                            if (seen.equals("back")) {
                                System.out.println("🔙 Returning to the main menu...");
                                break;
                            }

                            if (seen.equals("no")) {
                                recommendedList.add(anime);
                                System.out.println(" " + anime.getTitle() + " added to your recommended list!");
                            } else if (seen.equals("yes")) {
                                System.out.println(" Got it! Skipping to the next anime.");
                            } else {
                                System.out.println(" Invalid input. Skipping to the next anime.");
                            }
                        }

                        // After showing one batch of anime, ask user if they want to search another genre or return
                        System.out.print("\nWould you like to search another genre? (yes/no): ");
                        String again = scanner.nextLine().trim().toLowerCase();
                        if (!again.equals("yes")) {
                            System.out.println("🔙 Returning to the main menu...");
                            break;
                        }
                    }
                    break;

                case "2":
                    System.out.println("\n Your Recommended Anime List:");
                    if (recommendedList.isEmpty()) {
                        System.out.println("You haven’t added any anime yet!");
                    } else {
                        for (int i = 0; i < recommendedList.size(); i++) {
                            Anime a = recommendedList.get(i);
                            System.out.println((i + 1) + ". " + a.getTitle() + " ( " + a.getScore() + ")");
                        }
                    }
                    break;

                default:
                    System.out.println(" Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
