public class Main {// Used to run the game
    static Game game = new Game();
    public static void main(String[] args) {
        //Clearing the terminal space
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Welcome to Connect 4!");
        System.out.println();
        System.out.println("Each turn, which alternates between Player R and Player Y, gives the player a chance to play their token in a column. The token falls in the lowest possible location in the column that's not occupied. E signals an empty column. If you have 4 in a row, you win! You play your token in one of the seven columns. Just type a number from one to seven to play in a column.");
        System.out.println();
        game.play();
    }
}
