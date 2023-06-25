/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/*Gurleen kaur Gill
2023-06-24
*/

public class WarPlayer extends Player {

    private GroupOfCards hand;

    public WarPlayer(String name) {
        super(name);
        hand = new GroupOfCards(0);
    }

    public GroupOfCards getHand() {
        return hand;
    }

    public Card playCard() {
        return hand.getCards().remove(0);
    }

    @Override
    public void play() {
        // Logic for playing a turn in the War game
        // Implement according to the rules of the game
    }
}

