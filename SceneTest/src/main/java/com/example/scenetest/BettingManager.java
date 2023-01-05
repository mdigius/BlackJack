package com.example.scenetest;

public class BettingManager {
    private int cash = 1000;
    private int bet;

    public void setBet(int bet){
        if(bet>cash){
            System.out.println("Not enough cash!");
        } else{
            this.bet=bet;
            cash-=bet;
        }
    }
    public int getCash(){
        return cash;
    }

    public void drawBet(){
        this.cash = cash + bet;
    }

    public void wonBet(){
        this.cash = cash + 2*bet;
        bet = 0;
    }

    public void lostBet(){
        bet = 0;
    }


}
