import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);

        //Asks the user to input thier name for the player
        System.out.println("What is Player 1's name?: ");
        String p1Name = sc.nextLine(); 
        Player p1 = new Player(p1Name);

        //Asks the user to input their name for the player.
        System.out.println("What is Player 2's name?: ");
        String p2Name = sc.nextLine(); 
        Player p2 = new Player(p2Name);

        String again = "Literally any string";
        Player currentPlayer = p1;
        
        //Runs the game
        while (!again.equals("q")){
            System.out.print("\033[H\033[2J");
            System.out.println("Player 1: " + p1Name + "   vs   Player 2: " + p2Name + "\n");

            //Generates the game
            //TO DO: Create "game"
            Game b1 = new Game(p1, p2);

            //TO DO: Set a random player as the current player
            double coinFlip = Math.random();
            if (coinFlip < 0.5) {
                currentPlayer = p1;
            }
            if (coinFlip >= 0.5) {
                currentPlayer = p2;
            }

            b1.setFirstPlayer(currentPlayer);
            //This is the loop in which the game will be played
            while(!b1.isComplete()){
                //TO DO
                System.out.println("[Player " + currentPlayer.getName() + "'s turn]");
                int roundScore = b1.takePiece();
                currentPlayer.adjustScore(roundScore);
                currentPlayer = b1.getNextPlayer(currentPlayer);

            }
            
            System.out.println(currentPlayer.getName()+ " Won!!");
            System.out.println(p1.getName() +" had removed "+ p1.getScore()+" pieces!");
            System.out.println(p2.getName() +" had removed "+ p2.getScore()+" pieces!");
            System.out.println("------------------------------------------");
            System.out.println("Enter q to quit, enter anything else to play again.");
            again = sc.nextLine();
        }
        System.out.println("Thank you for playing!");
    }
}
