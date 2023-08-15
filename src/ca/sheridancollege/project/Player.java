
package ca.sheridancollege.project;

public class Player {
    private String name;
    private GroupOfCards hand;

    public Player(String name) {
        this.name = name;
        hand = new GroupOfCards();
    }

    public String getName() {
        return name;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public void drawCard(Card card) {
        hand.addCard(card);
    }

    public Card playCard() {
        // Implement logic to play a card
        // For example, remove a card from hand and return it
        return null;
    }
}
