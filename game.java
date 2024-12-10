public class Game {
    private Tom3 tom;
    private Design gameMap;

    public Game() {
        gameMap = new Design();
        tom = new Tom3();
    }

    public void startGame() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Welcome to Tom's Adventure!");
        System.out.println("Type 'north', 'south', 'east', or 'west' to move.");
        System.out.println("Type 'status' to view Tom's current status or 'exit' to quit.");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("exit")) {
                System.out.println("Exiting the game. Goodbye!");
                break;
            } else if (command.equals("status")) {
                tom.displayStatus();
            } else {
                tom.moveTom(command);
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
