public class design{
    private final int GRID_SIZE = 20; // 20x20 grid
    private String[][] grid; // To represent the grid
    private int tomX, tomY; // Tom's current position

    // Constructor
    public design() {
        grid = new String[GRID_SIZE][GRID_SIZE];
        initializeRooms();
        tomX = 5; // Starting position (in the middle of the Living Room)
        tomY = 5;
    }

    // Define the rooms and objects on the grid based on the map
    private void initializeRooms() {
        // Fill the grid with empty spaces
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = "Empty";
            }
        }

        // Living Room
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = "Living Room";
            }
        }
        // Adding objects in the Living Room
        grid[2][3] = "Chair";  // Chair at (2, 3)
        grid[4][5] = "Table";  // Table at (4, 5)

        // Kitchen
        for (int i = 10; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = "Kitchen";
            }
        }
        // Adding objects in the Kitchen
        grid[12][5] = "Fridge";  // Fridge at (12, 5)
        grid[14][7] = "Oven";    // Oven at (14, 7)

        // Bedroom
        for (int i = 0; i < 10; i++) {
            for (int j = 10; j < 20; j++) {
                grid[i][j] = "Bedroom";
            }
        }
        // Adding objects in the Bedroom
        grid[6][12] = "Bed";     // Bed at (6, 12)
        grid[7][14] = "Closet";  // Closet at (7, 14)

        // Bathroom
        for (int i = 10; i < 20; i++) {
            for (int j = 10; j < 20; j++) {
                grid[i][j] = "Bathroom";
            }
        }
        // Adding objects in the Bathroom
        grid[13][12] = "Shower"; // Shower at (13, 12)
        grid[15][14] = "Sink";   // Sink at (15, 14)
    }

    // Get Tom's current room or object
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
