import java.util.Random;
public class Deck{
    private Card[] Cards;
    Random rn = new Random();
    private int deckIndex = 0;
    public Deck(){
        this.Cards = new Card[52];
        for(int s = 0; s < 4; s++){
            //Creating cards 1-9 of 1 suit
            String su = "hearts";            
            if(s == 0){
                su = "hearts";
            }
            else if(s == 1){
                su = "clubs";
            }
            else if(s == 2){
                su = "spades";
            }
            else if(s == 3){
                su = "diamonds";
            }
            for (int i = 0; i < 10; i++){
                String ra = "";
                if (i == 0){
                    ra = "ace";
                }
                this.Cards[i + (13*s)] = new Card(i + 1, su, ra);
            }
            //Creating face cards
            this.Cards[10 + (13*s)] = new Card(10, su, "jack");
            this.Cards[11 + (13*s)] = new Card(10, su, "queen");
            this.Cards[12 + (13*s)] = new Card(10, su, "king");            
        }
    }
 
    public void setDeckIndex(int d){
        this.deckIndex = d;
    }
    public void shuffle(){
        for(int c = 0; c < 52; c++){
            int rando = rn.nextInt(52);
            Card temp = Cards[c];
            Cards[c] = Cards[rando];
            Cards[rando] = temp;
        }
        for(int c = 0; c < 52; c++){
            int rando = rn.nextInt(52);
            Card temp = Cards[c];
            Cards[c] = Cards[rando];
            Cards[rando] = temp;
        }
    }
    
    public void initialDeal(Player p1, Player p2){
        p1.addCard(this.Cards[deckIndex]);
        deckIndex++;
        p1.addCard(this.Cards[deckIndex]);
        deckIndex++;        
        p2.addCard(this.Cards[deckIndex]);
        deckIndex++;
        p2.addCard(this.Cards[deckIndex]);
        deckIndex++;
    }
    
    public void dealCard(Player p1){
        p1.addCard(this.Cards[deckIndex]);
        deckIndex++;
    }
    
    public String toString(){
        String temp = new String();
        for(int r = 0; r < 52; r++){
            temp+= this.Cards[r] + "\n";    
        }
        return temp;
    }
}