package sample;

public enum  GameStates {
    Blinds("Blinds Bet",0),
    PreFlop("Pre-Flop",1),
    Flop("Flop",2),
    Turn("Turn",3),
    River("River",4);

    //type of state
    private String stateType;
    private Integer stateTypeNumber;

    //constructor
    GameStates(String stateType, int stateTypeNumber){
        this.stateType = stateType;
        this.stateTypeNumber = stateTypeNumber;
    }

    //getter
    public String getState(){
        return stateType;
    }

    //getter
    public Integer getStateNumber(){
        return stateTypeNumber;
    }

    //setter
    public GameStates startState(){
        this.stateType = "Blinds";
        return this;
    }

    //setter
    public void setState(String state){
        this.stateType = state;
    }

    //setter
    public void setStateTypeNumber(Integer state){
        this.stateTypeNumber = state;
    }
}