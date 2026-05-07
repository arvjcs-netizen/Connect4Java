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
        game.play();
    }
}
