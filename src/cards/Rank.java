package cards;

public enum Rank {
    TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"),
    NINE(9, "9"), TEN(10, "10"), JACK(11, "Jack"), QUEEN(12, "Queen"), KING(12, "King"), ACE(13, "Ace");

    //rank of the card
    private final int rankValue;
    private final String rankName;
    //constructor
    private Rank(int rankValue, String rankName){
        this.rankValue = rankValue;
        this.rankName = rankName;
    }

    //getter
    public int getRank(){
        return rankValue;
    }

    //getter
    public String getRankName(){
        return rankName;
    }
}
