import java.util.*;
import java.math.*;
class Demo {
    public static void main(String[] args) {
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
            System.out.println("Current Hand: " + player.getSum());
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


