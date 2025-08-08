/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author princewilliroka
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GoFishPlayer extends Player {
    private ArrayList<GoFishCard> hand;
    private ArrayList<String> books;

    public GoFishPlayer(String playerName) {
        this.name = playerName;
        this.hand = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public ArrayList<GoFishCard> getHand() {
        return this.hand;
    }

    public void addCard(GoFishCard card) {
        this.hand.add(card);
    }

    public void removeCardsOfRank(String rank) {
        // Remove all cards of the given rank from the player's hand
        hand.removeIf(card -> card.getRank().equals(rank));
    }

    public boolean hasRank(String rank) {
        // Check if the player has any cards of the specified rank
        return hand.stream().anyMatch(card -> card.getRank().equals(rank));
    }

    public void checkForBooks() {
        // Check if player has a book (4 cards of the same rank)
        Map<String, Integer> rankCount = new HashMap<>();

        // Count the number of cards for each rank
        for (GoFishCard card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }

        // If a rank has 4 cards, add it to the books list and remove those cards from
        // hand
        for (Map.Entry<String, Integer> entry : rankCount.entrySet()) {
            if (entry.getValue() == 4) {
                books.add(entry.getKey()); // Add the rank to the list of completed books
                removeCardsOfRank(entry.getKey()); // Remove the 4 cards of that rank
            }
        }
    }

    public int getBookCount() {
        return books.size();
    }

    @Override
    public void play() {
    }
}
