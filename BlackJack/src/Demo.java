import java.awt.*;
import java.util.*;
import java.math.*;
import javax.swing.*;
class Demo {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        JPanel panel = new JPanel(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("BlackJack");
        JLabel title = new JLabel();
        title.setText("Current sum: ");
        title.setLocation(20,20);
        title.setSize(140,14);

        JLabel cardsLabel = new JLabel();
        cardsLabel.setLocation(20,50);
        cardsLabel.setSize(6000,14);
        cardsLabel.setText("Current Cards: ");

        JButton hitButton = new JButton("Hit");
        hitButton.setLocation(20,100);
        hitButton.setSize(100,20);




        window.setSize(1080,720);
        panel.add(hitButton);
        panel.add(title);
        panel.add(cardsLabel);
        window.add(panel);
        window.setVisible(true);




        ArrayList<Card> deckID = new ArrayList<Card>(1);
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        Card[] cards = new Card[52];
        int temporary = 0;
        for(int i=2; i<15; i++){
            cards[temporary] = new Card(i, temporary+1, "Hearts");
            temporary++;
        }
        for(int i=2; i<15; i++){
            cards[temporary] = new Card(i, temporary+1, "Diamonds");
            temporary++;
        }
        for(int i=2; i<15; i++){
            cards[temporary] = new Card(i, temporary+1, "Clubs");
            temporary++;
        }
        for(int i=2; i<15; i++){
            cards[temporary] = new Card(i, temporary+1, "Spades");
            temporary++;
        }

        for(int i=0; i<52; i++){
            deckID.add(cards[i]);
        }
        int deckLength = 51;
        int handSum = 0;
        int cash = 1000;
        int bet = 0;
        int turns = 5;

        Player player = new Player(1000);
        Player dealer = new Player(0);

        System.out.println("Welcome to BlackJack!");

        while(turns>0 && player.getCash()>0){
            System.out.print("Current cash: $" + player.getCash()+ ".\nPlease enter the amount you would like to bet: ");
            player.setBet(scan.nextInt());
            while(player.betChecker()==false){
                System.out.print("Bet exceeds cash. Enter a new amount you would like to bet: ");
                player.setBet(scan.nextInt());

            }
            for(int i=0; i<2; i++){
                int holder = 0;
                holder = random.nextInt(0,deckLength);
                System.out.println(deckID.get(holder));
                cardsLabel.setText(cardsLabel.getText() + deckID.get(holder).toString() +", ");
                player.setSum(player.getSum()+deckID.get(holder).getValue());
                deckID.remove(holder);
                deckLength = deckLength - 1;
            }
            while(dealer.getSum()<15){
                int holder = 0;
                holder = random.nextInt(0,deckLength);
                dealer.setSum(dealer.getSum()+deckID.get(holder).getValue());
                deckID.remove(holder);
                deckLength = deckLength - 1;
            }
            title.setText("Current Hand: " + player.getSum());
            System.out.print("Please type H to hit, or S to stand: ");
            String response;
            response = scan.next();
            while(response.equalsIgnoreCase("h" )){
                for(int i=0; i<1; i++){
                    int holder = 0;
                    holder = random.nextInt(0,deckLength);
                    System.out.println(deckID.get(holder));
                    player.setSum(player.getSum()+deckID.get(holder).getValue());
                    deckID.remove(holder);
                    deckLength = deckLength - 1;
                }
                System.out.print("Please type H to hit, or S to stand: ");
                response = scan.next();
            }
            System.out.println("Your sum: "+ player.getSum());
            System.out.println("Dealer sum: " + dealer.getSum());
            if(player.getSum()> dealer.getSum()){
                player.betSuccess();
                System.out.println("You win!");
            } else{
                System.out.println("You suck cock");
            }
            turns--;
            player.setSum(0);
            dealer.setSum(0);




        }


        }
    }


