public class GameMap {
    private final int GRID_SIZE = 20; // 20x20 grid
    private String[][] grid; // To represent the grid
    private int tomX, tomY; // Tom's current position

    // Constructor
    public GameMap() {
        grid = new String[GRID_SIZE][GRID_SIZE];
        initializeRooms();
        tomX = 5; // Starting position (in the middle of the Living Room)
        tomY = 5;
    }

    // Define the rooms on the grid
    private void initializeRooms() {
        // Living Room
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = "Living Room";
            }
        }

        // Kitchen
        for (int i = 10; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = "Kitchen";
            }
        }

        // Bedroom
        for (int i = 0; i < 10; i++) {
            for (int j = 10; j < 20; j++) {
                grid[i][j] = "Bedroom";
            }
        }

        // Bathroom
        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 20; j++) {
                grid[i][j] = "Bathroom";
            }
        }
    }

    // Get Tom's current room
    public String getCurrentRoom() {
        return grid[tomX][tomY];
    }

    // Move Tom by one step
    public boolean moveTom(String direction) {
        int newX = tomX;
        int newY = tomY;

        switch (direction.toLowerCase()) {
            case "north":
                newY -= 1; // Move up
                break;
            case "south":
                newY += 1; // Move down
                break;
            case "east":
                newX += 1; // Move right
                break;
            case "west":
                newX -= 1; // Move left
                break;
            default:
                System.out.println("Invalid direction. Use 'north', 'south', 'east', or 'west'.");
                return false;
        }

        // Check if the new position is within bounds
        if (newX >= 0 && newX < GRID_SIZE && newY >= 0 && newY < GRID_SIZE) {
            tomX = newX;
            tomY = newY;
            return true;
        } else {
            System.out.println("Tom can't move outside the house!");
            return false;
        }
    }

    // Get Tom's current position
    public String getPosition() {
        return "(" + tomX + ", " + tomY + ")";
    }
}
