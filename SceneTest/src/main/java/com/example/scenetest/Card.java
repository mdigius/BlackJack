package com.example.scenetest;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Card {
    private int suit;
    private int face;
    private String suitString;
    private String faceString;
    private int value;
    private Image cardImg;
    private ImageView imgView;
    private ImageView backImg = new ImageView(new Image("file:src/imgs/back.png"));


    public Card(int face, int suit) throws IOException {
        this.face=face;
        this.suit=suit;
        setCard();
        setValue();
        setCardImg();
    }

    public ImageView getBackImg(){
        backImg.setFitHeight(187);
        backImg.setFitWidth(137);
        return backImg;
    }


    public void setValue(){
        if(face==1){
            this.value=11;
        } else if(face<11){
            this.value=face;
        } else{
            value = 10;
        }
    }

    public void setCard(){
        String[] faces = {null, "Ace", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        this.suitString = suits[this.suit];
        this.faceString = faces[this.face];
    }

    public String toString() {
        String s = this.faceString + " of " + this.suitString;
        return s;
    }
    public int getValue(){
        return value;
    }
    public ImageView getCardImg(){
        imgView = new ImageView(this.cardImg);
        imgView.setFitHeight(187);
        imgView.setFitWidth(137);
        return imgView;
    }

    public void setCardImg() throws IOException {
        if(this.suit==0){
            switch (face) {
                case 1 -> this.cardImg = new Image("file:src/imgs/ace_of_clubs.png");
                case 2 -> this.cardImg = new Image("file:src/imgs/2_of_clubs.png");
                case 3 -> this.cardImg = new Image("file:src/imgs/3_of_clubs.png");
                case 4 -> this.cardImg = new Image("file:src/imgs/4_of_clubs.png");
                case 5 -> this.cardImg = new Image("file:src/imgs/5_of_clubs.png");
                case 6 -> this.cardImg = new Image("file:src/imgs/6_of_clubs.png");
                case 7 -> this.cardImg = new Image("file:src/imgs/7_of_clubs.png");
                case 8 -> this.cardImg = new Image("file:src/imgs/8_of_clubs.png");
                case 9 -> this.cardImg = new Image("file:src/imgs/9_of_clubs.png");
                case 10 -> this.cardImg = new Image("file:src/imgs/10_of_clubs.png");
                case 11 -> this.cardImg = new Image("file:src/imgs/jack_of_clubs2.png");
                case 12 -> this.cardImg = new Image("file:src/imgs/queen_of_clubs2.png");
                case 13 -> this.cardImg = new Image("file:src/imgs/king_of_clubs2.png");
            }
        } else if(this.suit==1){
            switch (face) {
                case 1 -> this.cardImg = new Image("file:src/imgs/ace_of_diamonds.png");
                case 2 -> this.cardImg = new Image("file:src/imgs/2_of_diamonds.png");
                case 3 -> this.cardImg = new Image("file:src/imgs/3_of_diamonds.png");
                case 4 -> this.cardImg = new Image("file:src/imgs/4_of_diamonds.png");
                case 5 -> this.cardImg = new Image("file:src/imgs/5_of_diamonds.png");
                case 6 -> this.cardImg = new Image("file:src/imgs/6_of_diamonds.png");
                case 7 -> this.cardImg = new Image("file:src/imgs/7_of_diamonds.png");
                case 8 -> this.cardImg = new Image("file:src/imgs/8_of_diamonds.png");
                case 9 -> this.cardImg = new Image("file:src/imgs/9_of_diamonds.png");
                case 10 -> this.cardImg = new Image("file:src/imgs/10_of_diamonds.png");
                case 11 -> this.cardImg = new Image("file:src/imgs/jack_of_diamonds2.png");
                case 12 -> this.cardImg = new Image("file:src/imgs/queen_of_diamonds2.png");
                case 13 -> this.cardImg = new Image("file:src/imgs/king_of_diamonds2.png");
            }
        } else if(this.suit==2){
            switch (face) {
                case 1 -> this.cardImg = new Image("file:src/imgs/ace_of_hearts.png");
                case 2 -> this.cardImg = new Image("file:src/imgs/2_of_hearts.png");
                case 3 -> this.cardImg = new Image("file:src/imgs/3_of_hearts.png");
                case 4 -> this.cardImg = new Image("file:src/imgs/4_of_hearts.png");
                case 5 -> this.cardImg = new Image("file:src/imgs/5_of_hearts.png");
                case 6 -> this.cardImg = new Image("file:src/imgs/6_of_hearts.png");
                case 7 -> this.cardImg = new Image("file:src/imgs/7_of_hearts.png");
                case 8 -> this.cardImg = new Image("file:src/imgs/8_of_hearts.png");
                case 9 -> this.cardImg = new Image("file:src/imgs/9_of_hearts.png");
                case 10 -> this.cardImg = new Image("file:src/imgs/10_of_hearts.png");
                case 11 -> this.cardImg = new Image("file:src/imgs/jack_of_hearts2.png");
                case 12 -> this.cardImg = new Image("file:src/imgs/queen_of_hearts2.png");
                case 13 -> this.cardImg = new Image("file:src/imgs/king_of_hearts2.png");
            }
        } else if(this.suit==3){
            switch (face) {
                case 1 -> this.cardImg = new Image("file:src/imgs/ace_of_spades.png");
                case 2 -> this.cardImg = new Image("file:src/imgs/2_of_spades.png");
                case 3 -> this.cardImg = new Image("file:src/imgs/3_of_spades.png");
                case 4 -> this.cardImg = new Image("file:src/imgs/4_of_spades.png");
                case 5 -> this.cardImg = new Image("file:src/imgs/5_of_spades.png");
                case 6 -> this.cardImg = new Image("file:src/imgs/6_of_spades.png");
                case 7 -> this.cardImg = new Image("file:src/imgs/7_of_spades.png");
                case 8 -> this.cardImg = new Image("file:src/imgs/8_of_spades.png");
                case 9 -> this.cardImg = new Image("file:src/imgs/9_of_spades.png");
                case 10 -> this.cardImg = new Image("file:src/imgs/10_of_spades.png");
                case 11 -> this.cardImg = new Image("file:src/imgs/jack_of_spades2.png");
                case 12 -> this.cardImg = new Image("file:src/imgs/queen_of_spades2.png");
                case 13 -> this.cardImg = new Image("file:src/imgs/king_of_spades2.png");
            }
        }
    }
}
