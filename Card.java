public class Card {
    private int value;
    private String suit;
    private String rank;
    private int shuffle;
    public Card(int val, String su, String ra){
        this.value = val;
        this.suit = su;
        this.rank = ra;
        this.shuffle = 1;
    }
    
    public int getValue(){
        return this.value;
    }
    public String getSuit(){
        return this.suit;
    }
    public String getRank(){
        return this.rank;
    }
    
    public void setValue(int val){
        this.value = val;
    }
    public void setSuit(String su){
        this.suit = su;
    }
    public void setRank(String ra){
        this.rank = ra;
    }
    
    public String toString(){
        String ra = this.rank;
        String pn = "A ";
        String ac = "";
        if(this.rank.equals("")){
            ra = String.valueOf(value);
        }
        if(this.rank.equals("ace") || this.value == (8)){
            pn = "An ";
        }
        if(this.rank.equals("ace")){
            ac = " or 11";
        }
        return pn + ra + " of " + this.suit + " with value " + this.value + ac;
    }
}