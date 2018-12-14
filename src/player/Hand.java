package player;

import cards.Card;
import cards.Deck;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Card> playerHand;
    ObservableList<Card> observableList;
    public Integer chipAmount;

    //empty hand
    public Hand(){
        chipAmount = 0;
        playerHand = new ArrayList<>();
        observableList =  FXCollections.observableList(playerHand);
        observableList.addListener((ListChangeListener<Card>) c -> {

            while (c.next()) {
                if(c.wasAdded()){
                    c.getAddedSubList().get(0).flipCard();
                    System.out.println("Card was added!");
                }
                if(c.wasRemoved()){
                    c.getAddedSubList().get(0).flipCard();
                }
            }

        });
    }

    public ObservableList<Card> getObservableList() { return observableList; }

    public void addCard(Card card){
        observableList.add(card);
    }

    //return the cards to the deck
    public void returnCards(){
        Deck.getInstance().addToDeck(observableList);
        observableList.clear();
    }

    public Integer getChipAmount(){
        return chipAmount;
    }

    public void setChipAmount(Integer newAmount){
        chipAmount = newAmount;
    }

    public List<Card> getPlayerCards(){
        return playerHand;
    }


}
