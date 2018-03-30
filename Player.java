import java.util.ArrayList;
public class Player{
    private String name;
    private int money;
    private ArrayList<Card> hand;
    private int handTotal;
    private static int betAmount = 0;
    public Player(String nm){
        this.name = nm;
        this.money = 100;
        this.hand = new ArrayList<Card>();
    }
    
    public void setName(String nm){
        this.name = nm;
    }
    public void setMoney(int mn){
        this.money = mn;
    }
    public void newHand(){
        this.hand = new ArrayList<Card>();
    }
    
    public String getName(){
        return this.name;
    }
    public int getMoney(){
        return this.money;
    }
    public int getBetAmount(){
        return betAmount;
    }
    
    public int getTotal(){    
        int temp = 0;
        int aces = 0;
        for(int i =0; i < this.hand.size(); i++){
            if(this.hand.get(i).getRank() == "ace"){
                aces++;
            }
        }
        for(int i = 0; i < this.hand.size(); i++){
            if(this.hand.get(i).getRank() == "ace"){
                temp += 0;
            }
            else{
                temp+= this.hand.get(i).getValue();
            }
        } 
        for(int i = 0; i < aces; i++){
                if((temp + 11) <= 21){
                    temp+= 11;
                }
                else{
                    temp+= 1;
                    }
        }
        return temp;
    }
    
    public String over21(){
        if(this.getTotal() > 21){
            return "over";
        }
        else if(this.getTotal()==21){
            return "win";
        }
        else{
            return "less";
        }
    }
    
    public void addCard(Card c){
        this.hand.add(c);
    }
    
    public void bet(int b){
        this.money -= b;
        if(this.money < 0){
            this.money += b;
            System.out.println("You don't have enough money!");
        }
        else if(this.betAmount < 0){
            this.money += b;
            System.out.println("Can't have negative bet!");
        }
        else {
            System.out.println("Changing Bet");
            betAmount += b;
        }
    }
    
    
    public String toString(){
        String temp = new String();
        for(int i = 0; i < hand.size(); i++){
            temp += hand.get(i) + "\n";
        }
        return this.name + " with: \n" + temp;
    }
    
    public String showDealerCards(){
        String temp = new String();
        for(int i = 0; i < hand.size() - 1; i++){
            temp += hand.get(i) + "\n";
        }
        return this.name + " with: \n" + temp + "And one other card";
    }
}