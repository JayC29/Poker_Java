package sample;

import Table.CommunityPile;
import cards.Deck;
import player.Hand;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static GameManager instance = null;
    public GameStates state;
    private Deck deck;
    public CommunityPile communityPile;
    public List<Hand> players;

    private GameManager(){
        state = GameStates.Blinds;
        deck = Deck.getInstance();
        communityPile = new CommunityPile();
        this.players = new ArrayList<Hand>();
        players.add(new Hand());
        players.add(new Hand());
    }

    //if GameManager has not been created then create one, otherwise returned previously created
    public static GameManager getInstance(){
        if(instance == null){
            instance = new GameManager();
        }
        return instance;
    }

    public String getState(){
        System.out.println("returning " + state.getState());
        return state.getState();
    }

    public void setState(String state){
        this.state.setState(state);
    }

    public void setStateNumber(Integer stateNumber){
        this.state.setStateTypeNumber(stateNumber);
    }

    public Integer getStateNumber(){
       return this.state.getStateNumber();
    }

    //starts a brand new game
    public  void startGame(Integer initialBettingAmount){
        //make sure each player returns their cards, and resets their money
        for(Hand player: players) {
           player.returnCards();
           player.setChipAmount(initialBettingAmount);
        }

        //re-shuffle deck
        deck.shuffle();

        //set state to initial
        state = GameStates.Blinds;
    }

    public void startPreFlop(){
        deck.dealCards(players, 2);
        System.out.println("size of deck after deal " + deck.cards.size());
    }

    public void startFlop(){
        deck.addToCommunityPile(communityPile, 3);
        System.out.println("size of deck after adding to community pile FLOP " + deck.cards.size());
    }

    public void startTurn(){
        deck.addToCommunityPile(communityPile, 1);
        System.out.println("size of deck after adding to community pile TURN " + deck.cards.size());
    }

}
