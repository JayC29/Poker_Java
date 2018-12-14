package Table;

import cards.Card;
import cards.Deck;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CommunityPile {
    List<Card> communityCards;
    ObservableList<Card> observableList;

    public CommunityPile(){
        communityCards = new ArrayList<Card>();
        observableList =  FXCollections.observableList(communityCards);
        observableList.addListener((ListChangeListener<Card>) c -> {

            while (c.next()) {
                if(c.wasAdded()){
                    c.getAddedSubList().get(0).flipCard();
                    System.out.println("Card was added! to the pile");
                }
                if(c.wasRemoved()){
                    c.getAddedSubList().get(0).flipCard();
                }
            }

        });
    }

    public void addCard(Card card){
        observableList.add(card);
    }

    //return the cards to the deck
    public void returnCards(){
        Deck.getInstance().addToDeck(observableList);
        observableList.clear();
    }

    public List<Card> getCommunityCards(){
        return observableList;
    }
}
