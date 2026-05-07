import java.util.Scanner;
public class Game { // Game class, used to create methods to play the game, and makes an instance of the board class.
    private boolean gameOn;
    private String player;
    Scanner input = new Scanner(System.in);
    private Board board;
    public Game(){
        player = "R";
        gameOn = true;
        board = new Board();
    }
    public void getMove(){
        System.out.println(board);
        System.out.println("Player " + player + ", What column do you want to play in?");
        int column = input.nextInt() - 1;
        while((board.dropPiece(column, player)) == false){
            System.out.println("That move was illegal, please try again.");
            column = input.nextInt() - 1;
        }
        System.out.println(board);
        if (player.equals("R")){
            player = "Y";
        }else{
            player = "R";
        }
    }
    public void findWinner(){
        if(!(board.checkBoard().equals("none"))){
            System.out.println("Player " + board.checkBoard() + " Has won the game!");
            gameOn = false;
        }
    }
    public void reset(){
        board = new Board();
        player = "R";
        gameOn = true;
    }
    public void play(){
        while(gameOn == true){
            getMove();
            findWinner();
        }
        reset();
        playAgain();
    }
    public void playAgain(){
        System.out.println("Would you like to play again?(y/n)");
        input.nextLine();
        String playAgain = input.nextLine();
        while(!((playAgain.equals("y"))||(playAgain.equals("n")))){
            System.out.println("That input was not expected, please try again, and input y or n.");
            playAgain = input.nextLine();
        }
        if (playAgain.equals("y")){
            System.out.println();
            System.out.println();
            System.out.println("Starting new game!");
            System.out.println();
            play();
        }
    }
}