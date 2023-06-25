/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

public class WarGame extends Game {

    private final int NUM_OF_CARDS = 52;
    private final int NUM_OF_PLAYERS = 2;

    private GroupOfCards deck;
    private ArrayList<Player> player;

    public WarGame() {
        super("War");
        player = new ArrayList<>();
        deck = new GroupOfCards(NUM_OF_CARDS);

        // Create players
        for (int i = 1; i <= NUM_OF_PLAYERS; i++) {
            player.add(new WarPlayer("Player " + i));
        }
    }

    @Override
    public void play() {
        // Create and shuffle the deck
        deck = createAndShuffleDeck();

        // Deal cards to players
        dealCards();

        // Play the game until a player wins
        while (!isGameOver()) {
            playRound();
        }

        // Declare the winner
        declareWinner();
    }

    private GroupOfCards createAndShuffleDeck() {
        GroupOfCards deck = new GroupOfCards(NUM_OF_CARDS);

        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.getCards().add(new Card(rank, suit));
            }
        }

        deck.shuffle();
        return deck;
    }

    private void dealCards() {
        int currentPlayer = 0;

        for (Card card : deck.getCards()) {
            players.get(currentPlayer).getHand().addCard(card);
            currentPlayer = (currentPlayer + 1) % NUM_OF_PLAYERS;
        }
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().getSize() == NUM_OF_CARDS) {
                return true;
            }
        }
        return false;
    }

    private void playRound() {
        Card[] cardsOnTable = new Card[NUM_OF_PLAYERS];

        // Each player plays a card
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            WarPlayer player = (WarPlayer) player.get(i);
            cardsOnTable[i] = player.playCard();
            System.out.println(player.getName() + " plays " + cardsOnTable[i]);
        }

        // Find the highest card rank
        int highestRankIndex = 0;
        for (int i = 1; i < NUM_OF_PLAYERS; i++) {
            if (cardsOnTable[i].getRank().ordinal() > cardsOnTable[highestRankIndex].getRank().ordinal()) {
                highestRankIndex = i;
            }
        }

        // Give the cards to the player with the highest rank
        WarPlayer roundWinner = (WarPlayer) player.get(highestRankIndex);
        roundWinner.getHand().addCards(cardsOnTable);

        System.out.println(roundWinner.getName() + " wins the round.");
    }

    @Override
    public void declareWinner() {
        WarPlayer winner = (WarPlayer) player.get(0);
        for (int i = 1; i < NUM_OF_PLAYERS; i++) {
            WarPlayer currentPlayer = (WarPlayer) player.get(i);
            if (currentPlayer.getHand().getSize() > winner.getHand().getSize()) {
                winner = currentPlayer;
            }
        }
        System.out.println(winner.getName() + " wins the game!");
    }

    public static void main(String[] args) {
        WarGame warGame = new WarGame();
        warGame.play();
    }
}

