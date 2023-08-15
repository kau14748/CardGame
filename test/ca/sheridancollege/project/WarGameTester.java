package ca.sheridancollege.project;

public class WarGameTester {

    public static void main(String[] args) {
        // Create players
        WarPlayer player1 = new WarPlayer("Player 1");
        WarPlayer player2 = new WarPlayer("Player 2");

        // Create War game
        WarGame warGame = new WarGame();
        warGame.addPlayer(player1);
        warGame.addPlayer(player2);

        // Test scenario: Draw
        player1.drawCard(new Card("Hearts", "2"));
        player2.drawCard(new Card("Clubs", "2"));
        warGame.play();
        warGame.declareWinner();

        // Test scenario: Player 1 wins
        player1.drawCard(new Card("Spades", "7"));
        player2.drawCard(new Card("Diamonds", "3"));
        warGame.play();
        warGame.declareWinner();

        // Test scenario: Player 2 wins
        player1.drawCard(new Card("Hearts", "K"));
        player2.drawCard(new Card("Clubs", "A"));
        warGame.play();
        warGame.declareWinner();
    }
}
