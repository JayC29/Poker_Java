package sample;

import cards.Card;
import cards.Rank;
import cards.Suit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import player.Hand;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    GameManager gm = GameManager.getInstance();
    GameStates gameStates;
    List<ImageView> player1Views;
    List<ImageView> player2Views;
    List<ImageView> communityPileViews = new ArrayList<>();

    Hand currentPlayer;
    Hand hand = new Hand();
    Card card = new Card(Rank.ACE, Suit.DIAMONDS);
    @FXML
    private Label chipAmount;
    @FXML
    private Label chipAmount1;

    @FXML
    private Label currentPhase;

    @FXML
    private ImageView playerView = new ImageView();

    @FXML
    private HBox player1ViewBox;
    @FXML
    private HBox player2ViewBox;
    @FXML
    private HBox communityPile;

    @FXML
    private TextField inputBet;

    public void bet(ActionEvent event){
        String inputText = inputBet.getText();
        boolean isNumeric = inputText.chars().allMatch( Character::isDigit );

        if(!isNumeric){
            return; //TODO show user error message
        }
        int number = Integer.parseInt(inputText);
        switch (gm.state){
            case Blinds:
                updateBet(number);
                System.out.println("new state is " + gm.state.toString());
                if(currentPlayer == gm.players.get(0)) {
                    gm.startPreFlop();
                    showCardsHands();
                }
                break;
            case PreFlop:
                System.out.println("new state is " + gm.state.toString());
                updateBet(number);
                if(currentPlayer == gm.players.get(0)) {
                    gm.startFlop();
                    showCommunityPile();
                }
                break;
            case Flop:
                System.out.println("new state is " + gm.state.toString());
                updateBet(number);
                if(currentPlayer == gm.players.get(0)) {
                    gm.startTurn();
                    showCommunityPile();
                }
                break;
        }
    }

    public void updateBet(Integer betAmount){

        if(betAmount > 0 && betAmount <= currentPlayer.chipAmount);
        {
            if(currentPlayer == gm.players.get(0)) {
                currentPlayer = gm.players.get(1);
                currentPlayer.setChipAmount(currentPlayer.chipAmount - betAmount);
                chipAmount.setText("P1 Chip Amount: " + currentPlayer.chipAmount);
            }
            else{
                currentPlayer = gm.players.get(0);
                currentPlayer.setChipAmount(currentPlayer.chipAmount - betAmount);
                chipAmount1.setText("P2 Chip Amount: " + currentPlayer.chipAmount);
                gm.state = GameStates.values()[gm.state.ordinal() + 1];
                currentPhase.setText(GameManager.getInstance().getState());
            }
        }
    }

    public void showCardsHands() {
        for (Hand player: gm.players) {
            for(Card card: player.getPlayerCards()){
                ImageView newCardDisplay = new ImageView();
                newCardDisplay.setImage( card.getImage());
                if(player == gm.players.get(0))
                    player1ViewBox.getChildren().add(newCardDisplay);
                else
                    player2ViewBox.getChildren().add(newCardDisplay);
            }
        }
        System.out.println("Finished show cards method");
    }

    public void showCommunityPile() {
        communityPile.getChildren().removeAll(communityPileViews);
/*
        for(int i = 0; i < gm.communityPile.getCommunityCards().size(); i++)
        {
            ImageView newCardDisplay = new ImageView();
            newCardDisplay.setImage( card.getImage());
            communityPileViews.add(newCardDisplay);
            communityPile.getChildren().add(communityPileViews.get(i));
        }*/

        for(Card card: gm.communityPile.getCommunityCards()){
            ImageView newCardDisplay = new ImageView();
            newCardDisplay.setImage( card.getImage());
            communityPileViews.add(newCardDisplay);
            communityPile.getChildren().add(newCardDisplay);
        }
    }


    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        //playerView.setImage("");
        currentPlayer = gm.players.get(0);
        chipAmount.setText("P1 Chip Amount: " + gm.players.get(0).getChipAmount());
        chipAmount1.setText("P2 Chip Amount: " + gm.players.get(1).getChipAmount());
        currentPhase.setText(GameManager.getInstance().getState());
    }
}
