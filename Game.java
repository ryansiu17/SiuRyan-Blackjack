    import java.util.Scanner;
    public class Game{
    private Player[] Players = new Player[2];
    private Deck d1;
    Scanner scan = new Scanner(System.in);
    private boolean end = false;
    public boolean noWinner = true;   
    //public boolean quit == false;
    public Game(){
        
    }
    
    public static void main(String args[]){
        Game g1 = new Game();
        g1.startGame();
    }
    
    public void dispatch(int choice){
        switch(choice){
            case 0:
                System.out.println("Bye!");
                System.exit(0);
                break;
            case 1:
                System.out.println("How much to add to bet? (Use '-' to remove)");
                Players[0].bet(scan.nextInt());
                break;
            case 2:
                System.out.println("Hitting");
                d1.dealCard(Players[0]);
                if(Players[0].getTotal() > 21){
                    System.out.println("Bust!");
                    System.out.println("You lost: $" + Players[0].getBetAmount());
                    Players[0].setMoney(Players[0].getMoney() - Players[0].getBetAmount());
                    showCards();
                    resetGame();
                    if(Players[0].getMoney() < 1){
                        System.out.println("Out of money!");
                    }
                    break;
                }
                if(Players[0].getTotal() == 21){
                    System.out.println("You Win!");
                    System.out.println("You won: $" + Players[0].getBetAmount());
                    Players[0].setMoney(Players[0].getMoney() + Players[0].getBetAmount());
                    showCards();
                    resetGame();                  
                    break;
                }
                break;
            case 3:
                System.out.println("Standing");
                stand(Players[0], Players[1]);
                break;
            default:
                System.out.println("Please enter a valid digit");
                break;
        }
    }
    
    public void startGame(){
        System.out.println("Enter Player Name: ");
        Players[0] = new Player(scan.next());
        Players[1] = new Player("Dealer");
        d1 = new Deck();
        d1.shuffle();
        d1.initialDeal(Players[0], Players[1]);
        if(Players[0].getTotal() == 21){
            System.out.println("Blackjack, You Win!");
        }       
        int choice = 1;
        System.out.println("Out of $100");
        while(choice != 0){
            if(Players[0].getMoney() <= 0){
            System.out.println("Out of money!");
            choice = 0;
        }        
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }        
    }
    
    public void showCards(){
        System.out.println(Players[0]);
        System.out.println("For a total of: " + Players[0].getTotal());
        System.out.println(Players[1]);
        System.out.println("For a total of: " + Players[1].getTotal());        
    }
    public void stand(Player p1, Player p2){
        while(noWinner == true){
            if(p2.getTotal() > 21){
                System.out.println("Dealer Busted, You win!");
                System.out.println("You won: $" + Players[0].getBetAmount());
                p1.setMoney(p1.getMoney() + p1.getBetAmount());                
                noWinner = false; 
            }            
            else if(p1.getTotal() < p2.getTotal()){
                System.out.println("You lose!");
                System.out.println("You lost: $" + Players[0].getBetAmount());
                Players[0].setMoney(Players[0].getMoney() - Players[0].getBetAmount()); 
                noWinner = false;
            }
            else{
                d1.dealCard(p2);
            }
        }
                showCards();
                resetGame();     
    }
    
    public void resetGame(){
        Players[0].newHand();
        Players[1].newHand();
        d1.shuffle();
        d1.setDeckIndex(0);
        d1.initialDeal(Players[0],Players[1]);
        noWinner = true;
    }
    public void printMenu(){
        System.out.println("\nMenu:");
        System.out.println("------------");
        System.out.println("Bet: $" + Players[0].getBetAmount());
        System.out.println("Money: $" + Players[0].getMoney());
        System.out.println("------------");
        System.out.println((Players[0]));
        System.out.println(Players[1].showDealerCards());
        System.out.println("------------");
        System.out.println("0: Quit");
        System.out.println("1: Change Bet");
        System.out.println("2: Hit");
        System.out.println("3: Stand");
        //System.out.println(Players[0].getTotal());
        }
    }