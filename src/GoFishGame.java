/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author princewilliroka
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GoFishGame extends Game {
    private GoFishDeck deck;
    private Scanner scanner;

    public GoFishGame(String gamename) {
        this.gamename = gamename;
        this.deck = new GoFishDeck();  // Initialize the deck
        this.scanner = new Scanner(System.in);  // For reading user input
    }

    @Override
    public String getName() {
        return this.gamename;
    }

    @Override
    public void play() {
        // Start the game
        System.out.println("Game is starting...");
        
        GoFishPlayer player1 = new GoFishPlayer("Player 1");
        GoFishPlayer player2 = new GoFishPlayer("Player 2");

        // Add players to the game
        players.add(player1);
        players.add(player2);

        // Call the game loop
        gameLoop();
    }

    @Override
    public void declareWinner() {
        // Check for the player with most books (sets of four cards of the same rank)
        GoFishPlayer winner = null;
        int maxBooks = 0;

        for (Player player : players) {
            GoFishPlayer goFishPlayer = (GoFishPlayer) player;
            int bookCount = goFishPlayer.getBookCount();
            if (bookCount > maxBooks) {
                maxBooks = bookCount;
                winner = goFishPlayer;
            }
        }

        if (winner != null) {
            System.out.println("Winner is " + winner.getName() + " with " + maxBooks + " books!");
        } else {
            System.out.println("No winner yet!");
        }
    }

    public void gameLoop() {
        int currentPlayerIndex = 0;

        while (!deck.isEmpty()) {
            // Get the current player
            GoFishPlayer currentPlayer = (GoFishPlayer) players.get(currentPlayerIndex);
            System.out.println(currentPlayer.getName() + "'s turn!");

            // Ask the player for a card
            askForCard(currentPlayer);

            // Check if the player has completed any books (4 cards of the same rank)
            checkForBooks(currentPlayer);

            // Print the player's hand after their turn
            System.out.println(currentPlayer.getName() + "'s hand: " + currentPlayer.getHand());

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        // After the game loop ends, declare the winner
        declareWinner();
    }

    public void askForCard(GoFishPlayer currentPlayer) {
        System.out.println(currentPlayer.getName() + ", ask for a card rank:");
        String rankAsked = scanner.nextLine().toUpperCase();

        // Check if the opponent has the card
        for (Player opponent : players) {
            if (opponent != currentPlayer) {
                GoFishPlayer goFishOpponent = (GoFishPlayer) opponent;

                // If opponent has the card, they give it to the current player
                if (goFishOpponent.hasRank(rankAsked)) {
                    GoFishCard card = goFishOpponent.getHand().get(0);  // Simplified logic to take the first card
                    currentPlayer.addCard(card);
                    goFishOpponent.removeCardsOfRank(rankAsked);
                    System.out.println(currentPlayer.getName() + " got a " + rankAsked + " from " + opponent.getName());
                    return; // End the turn after a successful request
                }
            }
        }

        // If the opponent does not have the card, it's "Go Fish"
        System.out.println("Go Fish!");
        GoFishCard drawnCard = deck.drawCard();
        currentPlayer.addCard(drawnCard);
        System.out.println(currentPlayer.getName() + " drew a " + drawnCard);
    }

    public void checkForBooks(GoFishPlayer player) {
        // Check if player has a book (4 cards of the same rank)
        for (String rank : GoFishDeck.getRanks()) {
            if (player.hasRank(rank)) {
                player.checkForBooks();
                System.out.println(player.getName() + " has completed a book of " + rank + "s!");
            }
        }
    }
}
