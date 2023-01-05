package com.example.scenetest;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
        Group root = new Group();
        Scene scene = new Scene(root, 1280,720);
        scene.setFill(Color.BLANCHEDALMOND);
        
        ArrayList<Card> deck = new ArrayList();
        Hand player = new Hand("Player");
        Hand cpu = new Hand("CPU");

        Text handValueLabel = new Text();
        handValueLabel.setText("Hand Value: ");
        handValueLabel.setLayoutX(150);
        handValueLabel.setLayoutY(450);
        root.getChildren().add(handValueLabel);

        TextField betField = new TextField();

        betField.prefWidth(250);
        betField.setLayoutY(460);
        betField.setLayoutX(60);
        root.getChildren().add(betField);

        Text status = new Text();
        status.setText("Welcome to blackjack!\n     Press play to start");
        status.setLayoutY(350);
        status.setLayoutX(475);
        status.setFont(Font.font("system", FontWeight.BOLD, FontPosture.REGULAR ,34));
        root.getChildren().add(status);

        Text cashLabel = new Text();
        cashLabel.setText("Cash: $1000");
        cashLabel.setLayoutX(150);
        cashLabel.setLayoutY(425);
        root.getChildren().add(cashLabel);

        Button hitButton = new Button();
        hitButton.setText("Hit");
        hitButton.setPrefSize(50,50);
        hitButton.setLayoutX(150);
        hitButton.setLayoutY(500);

        Button playButton = new Button();
        playButton.setText("Play");
        playButton.setPrefSize(50,50);
        playButton.setLayoutX(75);
        playButton.setLayoutY(575);

        Button standButton = new Button();
        standButton.setText("Stand");
        standButton.setPrefSize(50,50);
        standButton.setLayoutX(150);
        standButton.setLayoutY(575);

        Button betButton = new Button();
        betButton.setText("Bet");
        betButton.setPrefSize(50,50);
        betButton.setLayoutX(75);
        betButton.setLayoutY(500);

        root.getChildren().add(betButton);
        root.getChildren().add(playButton);
        root.getChildren().add(hitButton);
        root.getChildren().add(standButton);
        GameManager gameManager = new GameManager(player, cpu, deck,root,handValueLabel,cashLabel,status);
        stage.setTitle("BlackJack!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        hitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameManager.hit();


            }
        });
        standButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameManager.stand();


            }
        });
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent){
                if(gameManager.getStatus()==false){
                    try {
                        gameManager.playRound();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        betButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent){
                if(gameManager.getStatus()==false){
                    player.getBettingManager().setBet(Integer.parseInt(betField.getText()));
                    betField.clear();
                    cashLabel.setText("Cash: $" + player.getBettingManager().getCash());
                }
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}