public class game{
    private Tom3 tom; // Tom object
    private design gameMap; // Map object

    // Constructor
    public game() {
        gameMap = new design(); // Initialize the map
        tom = new Tom3(); // Initialize Tom
    }

    // Main game loop
    public void startGame() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Welcome to Tom's Adventure! Type 'north', 'south', 'east', or 'west' to move.");
        System.out.println("Type 'status' to view Tom's current status or 'exit' to quit.");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("exit")) {
                System.out.println("Exiting the game. Goodbye!");
                break;
            } else if (command.equals("status")) {
                tom.displayStatus();
                System.out.println("Current Room/Object: " + gameMap.getCurrentRoomOrObject());
            } else {
                boolean moved = gameMap.moveTom(command);
                if (moved) {
                    tom.moveTom(command);
                } else {
                    System.out.println("Move failed. Try another direction.");
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        game game = new game();
        game.startGame();
    }
}
