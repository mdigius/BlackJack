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

        System.out.print("Welcome to BlackJack! Your starting cash is $1000.\nPlease enter the amount" +
                " you would like to bet: ");
        bet = scan.nextInt();

        for(int i=0; i<2; i++){
            int holder = 0;
            holder = random.nextInt(0,deckLength);
            System.out.println(deckID.get(holder));
            handSum = handSum + deckID.get(holder).getValue();
            deckID.remove(holder);
            deckLength = deckLength - 1;
        }
        System.out.println("Current Hand: " + handSum);
        System.out.print("Please type H to hit, or S to stand: ");
        String response = scan.next();

        if(response.equalsIgnoreCase("h")){

        }
    }
}

