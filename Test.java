public class Test{
    public static void main(String args[]){
        Deck d1 = new Deck();
        System.out.print(d1);
        System.out.println("Shuffling");
        d1.shuffle();
        System.out.print(d1);
    }
}