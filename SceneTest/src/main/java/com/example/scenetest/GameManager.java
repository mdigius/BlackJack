package com.example.scenetest;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
    private Hand player;
    private Hand cpu;
    private ArrayList<Card> deck;
    private int deckSize = 51;
    private Scanner scan = new Scanner(System.in);
    private Random random = new Random();
    private Group root;
    private Text handValueLabel;
    private Text cashLabel;
    private boolean gameRunning = false;
    private int hitCounter = 0;
    private int cpuHitCounter = 0;
    private ArrayList<ImageView> hitViews = new ArrayList<>(1);
    private ArrayList<ImageView> cpuViews = new ArrayList<>(1);
    private Text status;


    public GameManager(Hand player, Hand cpu, ArrayList<Card> deck, Group root, Text handValueLabel, Text cashLabel, Text status){
        this.player = player;
        this.cpu = cpu;
        this.deck = deck;
        this.root=root;
        this.handValueLabel = handValueLabel;
        this.cashLabel = cashLabel;
        this.status=status;
    }

    public void cpuBust(){
        status.setText("You win (CPU Bust!) Press play to restart\nCPU Hand: " + cpu.getHandValue());
        player.getBettingManager().wonBet();
        revealDealer();
        resetHands();
        cashLabel.setText("Cash: $" + player.getBettingManager().getCash());
        gameRunning=false;

    }

    public void won(){
        status.setText("You win! Press play to restart\nCPU Hand:" + cpu.getHandValue());
        player.getBettingManager().wonBet();
        revealDealer();
        resetHands();
        cashLabel.setText("Cash: $" + player.getBettingManager().getCash());
        gameRunning=false;
    }

    public void draw(){
        status.setText("Draw! Press play to restart\nCPU Hand: " + cpu.getHandValue());
        player.getBettingManager().drawBet();
        revealDealer();
        resetHands();
        cashLabel.setText("Cash: $" + player.getBettingManager().getCash());
        gameRunning = false;
    }

    public void bust(){
        status.setText("Bust! Press play to restart\nCPU Hand: " + cpu.getHandValue());
        player.getBettingManager().lostBet();
        handValueLabel.setText("Hand value: Bust! " + player.getHandValue());
        revealDealer();
        resetHands();
        cashLabel.setText("Cash: $" + player.getBettingManager().getCash());
        gameRunning = false;

    }

    public void lost(){
        status.setText("You lose! Press play to restart\nCPU Hand: " + cpu.getHandValue());
        player.getBettingManager().lostBet();
        revealDealer();
        resetHands();
        cashLabel.setText("Cash: $" + player.getBettingManager().getCash());
        gameRunning = false;
    }

    public boolean getStatus(){
        return gameRunning;
    }

    public void stand(){
        cpuControl();
        revealDealer();
        checkResult();


    }

    public boolean checkBust(Hand hand) {
        if (hand.getHandValue() > 21) {
            if (hand.hasAce() && hand.getSwappedAce() == false) {
                hand.swapAce();
                handValueLabel.setText("Hand value: " + player.getHandValue());
                return false;
            } else return true;
        } else return false;
    }

    public void hit(){
        if(gameRunning) {
            playerDrawCard();
            System.out.println(player);
            System.out.println(player.getHandValue());
            hitCounter += 1;
            hitViews.add(player.getHand().get(player.getHand().size() - 1).getCardImg());
            hitViews.get(hitCounter - 1).setLayoutX(100 + 150 * player.getHand().size() - 1);
            hitViews.get(hitCounter - 1).setLayoutY(500);
            handValueLabel.setText("Hand value: " + player.getHandValue());
            root.getChildren().add(hitViews.get(hitCounter-1));
            boolean bool = checkBust(player);
            if (bool == true) {
                stand();
            }
            if(player.getHandValue()==21){
                stand();
            }
        }
        }


    public void revealDealer(){
        ImageView cpu2 = cpu.getHand().get(1).getCardImg();
        cpu2.setTranslateX(400);
        cpu2.setTranslateY(40);
        root.getChildren().add(cpu2);

    }

    public void shuffleDeck() throws IOException {
        deckSize = 51;
        for(int i=1; i<14; i++){
            deck.add(new Card(i, 0));
            deck.add(new Card(i, 1));
            deck.add(new Card(i, 2));
            deck.add(new Card(i, 3));
        }
    }
    public void wipeDeck(){
        deck.clear();
    }
    public void playRound() throws IOException {
        for(int i = 0; i<hitViews.size(); i++){
            root.getChildren().remove(hitViews.get(i));
        }
        for(int i = 0; i<cpuViews.size(); i++){
            root.getChildren().remove(cpuViews.get(i));
        }
        status.setText("");
        hitViews.clear();
        cpuViews.clear();
        hitCounter=0;
        cpuHitCounter = 0;
        gameRunning = true;
        player.setSwappedAce(false);
        cpu.setSwappedAce(false);
        shuffleDeck();
        dealHand();
        cashLabel.setText("Cash: $" + player.getBettingManager().getCash());
        handValueLabel.setText("Hand value: " + player.getHandValue());
        System.out.println(player);
        ImageView cpu1 = cpu.getHand().get(0).getCardImg();
        cpu1.setTranslateX(250);
        cpu1.setTranslateY(40);
        root.getChildren().add(cpu1);
        ImageView cpu2 = cpu.getHand().get(0).getBackImg();
        cpu2.setTranslateX(400);
        cpu2.setTranslateY(40);
        root.getChildren().add(cpu2);
        ImageView p1 = player.getHand().get(0).getCardImg();
        p1.setTranslateX(250);
        p1.setTranslateY(500);
        root.getChildren().add(p1);
        ImageView p2 = player.getHand().get(1).getCardImg();
        p2.setTranslateX(400);
        p2.setTranslateY(500);
        root.getChildren().add(p2);


    }
    public void resetHands(){
        wipeDeck();
        player.resetValue();
        cpu.resetValue();
        player.wipeHand();
        cpu.wipeHand();
    }
    public void playerDrawCard(){
        int rand = random.nextInt(0, deckSize);
        player.addCard(deck.get(rand));
        deck.remove(rand);
        deckSize--;
    }
    public void cpuDrawCard(){
        int rand = random.nextInt(0, deckSize);
        cpu.addCard(deck.get(rand));
        deck.remove(rand);
        deckSize--;
    }
    public void cpuControl(){
        while(cpu.getHandValue()<17){
            cpuDrawCard();
            cpuHitCounter += 1;
            cpuViews.add(cpu.getHand().get(cpu.getHand().size() - 1).getCardImg());
            cpuViews.get(cpuHitCounter - 1).setLayoutX(100 + 150 * cpu.getHand().size() - 1);
            cpuViews.get(cpuHitCounter - 1).setLayoutY(40);
            root.getChildren().add(cpuViews.get(cpuHitCounter-1));
            System.out.println("CPU HAND:" + cpu);
        }
    }

    public void checkResult(){
        if(player.getHandValue()>21){
            bust();
        } else if (player.getHandValue() > cpu.getHandValue() && cpu.getHandValue() > 21 == false) {
            won();
        } else if (player.getHandValue() == cpu.getHandValue()) {
            draw();

        } else if (cpu.getHandValue() > 21 == true) {
            cpuBust();

        } else {
            lost();
        }
    }
    public void dealHand(){
        playerDrawCard();
        playerDrawCard();
        cpuDrawCard();
        cpuDrawCard();
    }
}