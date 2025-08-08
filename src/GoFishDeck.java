/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author princewilliroka
 */
import java.util.ArrayList;

public class GoFishDeck extends GroupOfCards {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public GoFishDeck() {
        super(52); // Initialize the deck with 52 cards based on the standard 52-card deck.
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                // Adding GoFishCard objects to the deck
                cards.add(new GoFishCard(rank, suit));
            }
        }
    }

    public GoFishCard drawCard() {
        // We return a GoFishCard when drawing a card from the deck
        return (GoFishCard) super.dealCard();  // Casting to GoFishCard
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    public static String[] getRanks() {
        return RANKS;
    }
}


