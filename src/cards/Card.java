package cards;

import javafx.scene.image.Image;

public class Card {

    private Suit suit;
    private Rank rank;
    private Image image;
    private boolean isFaceUp;

    //constructor
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
        this.image = getImage();
        isFaceUp = false;
    }

    //getters
    public String getSuit(){
        return suit.getSuit();
    }

    public int getRank(){
        return rank.getRank();
    }

    public Image getImage(){
        if(isFaceUp == true)
            return new Image(getClass().getResource("/resources/" + this.toString() + ".png").toExternalForm(), 75, 115, true, true);
        else
            return new Image(getClass().getResource("/resources/Back.png").toExternalForm(), 75, 115, true, true);
    }

    public void flipCard(){
        isFaceUp = true;
    }


    //tostring override
    @Override
    public String toString() {
        String returnString = "";
        returnString = rank.getRankName() + " of " + suit.getSuit();
        return returnString;
    }

}
