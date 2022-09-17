public class Player {
    private int sum;
    private int cash;
    private int bet;

    public Player(int cash){
        this.cash=cash;

    }
    public boolean betChecker(){
        if(bet<cash){
            cash = cash - bet;
            return true;

        } else{
            bet = 0;
            return false;
        }
    }
    public void setBet(int bet){
        this.bet=bet;
    }

    public int getBet() {
        return bet;
    }
    public int getSum() {
        return sum;
    }
    public int getCash() {
        return cash;
    }
    public void setSum(int sum){
        this.sum=sum;
    }

    public void betSuccess(){
        cash = cash + 2*bet;

    }
}
