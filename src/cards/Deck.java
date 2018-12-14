package cards;

import Table.CommunityPile;
import player.Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//deck class singleton
public class Deck {
    private static Deck deckInstance = null;
    public List<Card> cards;

    //creates new card for each suit and rank
    private Deck(){
        cards = new ArrayList<Card>();
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    //if deck has not been created then create one, otherwise returned previously created
    public static Deck getInstance(){
        if(deckInstance == null){
            deckInstance = new Deck();
        }
        return deckInstance;
    }

    //add back the cards passed into the deck
    public void addToDeck(List<Card> cards){
        this.cards.addAll(cards);
    }

    //deals each player cards
    public void dealCards(List<Hand> hands, int cardsPerHand){
        for(int i=0; i < cardsPerHand; i++)
        {
            for(int j=0; j < hands.size(); j++)
            {
                hands.get(j).addCard(chooseRandomCard());
            }
        }
    }

    public void addToCommunityPile(CommunityPile communityPile, Integer numberToAdd){
        for(int i = 0; i < numberToAdd; i++){
            communityPile.addCard(chooseRandomCard());
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    //chooses random card from deck and returns it
    private Card chooseRandomCard(){
        Random r = new Random();
        int randInt = r.nextInt(cards.size());
        return cards.remove(randInt);
    }
}
