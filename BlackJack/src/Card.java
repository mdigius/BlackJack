public class Card {
    private String suitString;
    private String valueString;
    private int value;
    private int id;

    public Card(int value, int id, String suitString){
        this.suitString=suitString;
        this.value=value;
        setValueString();

    }
    public int getValue(){
        return value;
    }
    public void testMessage(){
        System.out.println("Test");

    }
    public void setValueString(){
        switch(value){
            case 1:
                valueString = "One";
                break;
            case 2:
                valueString = "Two";
                break;
            case 3:
                valueString = "Three";
                break;
            case 4:
                valueString = "Four";
                break;
            case 5:
                valueString = "Five";
                break;
            case 6:
                valueString = "Six";
                break;
            case 7:
                valueString = "Seven";
                break;
            case 8:
                valueString = "Eight";
                break;
            case 9:
                valueString = "Nine";
                break;
            case 10:
                valueString = "Ten";
                break;
            case 11:
                valueString = "Jack";
                value = 10;
                break;
            case 12:
                valueString = "Queen";
                value = 10;
                break;
            case 13:
                valueString = "King";
                value = 10;
                break;
            case 14:
                valueString = "Ace";
                value = 11;
                break;

        }
    }
    @Override
    public String toString(){
        return valueString + " of " + suitString;
    }
}
