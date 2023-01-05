package com.example.scenetest;
import java.util.ArrayList;

public class Hand {
    private int handValue;
    private String name;
    private ArrayList<Card> hand = new ArrayList<>(2);
    private BettingManager bettingManager = new BettingManager();
    private boolean swappedAce = false;

    public Hand(String name){
        this.name = name;
    }
    public void wipeHand(){
        hand.clear();
    }
    public void addCard(Card card){
        this.hand.add(card);
        this.handValue = this.handValue + card.getValue();
    }
    public boolean getSwappedAce(){
        return swappedAce;
    }
    public void setSwappedAce(Boolean bool){
        this.swappedAce = bool;
    }
    public ArrayList<Card> getHand(){
        return hand;
    }
    public String toString(){
        String s = "" + hand;
        return s;
    }
    public int getHandValue(){
        return handValue;
    }
    public void resetValue(){
        this.handValue = 0;
    }
    public boolean hasAce(){
        for(int i = 0; i<this.hand.size(); i++){
            if(this.hand.get(i).getValue() == 11){
                return true;
            }
        }
        return false;
    }
    public void swapAce(){
        this.handValue -= 10;
        swappedAce=true;
    }
    public BettingManager getBettingManager(){
        return bettingManager;
    }
}
