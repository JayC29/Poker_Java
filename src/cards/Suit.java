package cards;

public enum Suit {
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    CLUBS("Clubs"),
    SPADES("Spades");

    //type of suit
    private final String suitType;

    //constructor
    Suit(String suitType){
        this.suitType = suitType;
    }

    //getter
    public String getSuit(){
        return suitType;
    }
}
