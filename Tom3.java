public class Tom3 {
    // Attributes
    private int energyLevel;
    private int steps;
    private boolean hasJerry;
    private int currentX; // Tom's current X-coordinate
    private int currentY; // Tom's current Y-coordinate
    private GameMap gameMap; // Reference to the GameMap

    // Constructor
    public Tom3() {
        this.energyLevel = 100;
        this.steps = 0;
        this.hasJerry = false;
        this.currentX = 5; // Starting position
        this.currentY = 5;
        this.gameMap = new GameMap();
        System.out.println("Tom starts in the " + gameMap.getRoom(currentX, currentY));
    }

    // Move Tom based on direction
    public void moveTom(String direction) {
        if (energyLevel <= 0) {
            System.out.println("Tom is out of energy and can't move!");
            return;
        }

        int newX = currentX;
        int newY = currentY;

        switch (direction.toLowerCase()) {
            case "north":
                newY += 1; // Positive Y direction
                break;
            case "south":
                newY -= 1; // Negative Y direction
                break;
            case "east":
                newX += 1; // Positive X direction
                break;
            case "west":
                newX -= 1; // Negative X direction
                break;
            default:
                System.out.println("Invalid direction! Use 'north', 'south', 'east', or 'west'.");
                return;
        }

        // Check if new position is valid
        if (gameMap.getRoom(newX, newY).equals("Unknown Room")) {
            System.out.println("Tom can't move outside the house!");
        } else {
            currentX = newX;
            currentY = newY;
            steps++;
            energyLevel -= 2;
            System.out.println("Tom moved " + direction.toUpperCase() + " to (" + currentX + ", " + currentY + ") - " 
                               + gameMap.getRoom(currentX, currentY));
            if (steps % 5 == 0) {
                System.out.println("Tom is now in the middle of the room!");
            }
        }
    }

    // Display Tom's current status
    public void displayStatus() {
        System.out.println("Tom's Position: (" + currentX + ", " + currentY + ")");
        System.out.println("Current Room: " + gameMap.getRoom(currentX, currentY));
        System.out.println("Energy Level: " + energyLevel);
        System.out.println("Total Steps: " + steps);
    }

    public static void main(String[] args) {
        Tom3 tom = new Tom3();

        // Simulate Tom's movement
        tom.moveTom("north");
        tom.displayStatus();

        tom.moveTom("north");
        tom.displayStatus();

        tom.moveTom("east");
        tom.displayStatus();

        tom.moveTom("south");
        tom.displayStatus();

        tom.moveTom("west");
        tom.displayStatus();
    }
}


