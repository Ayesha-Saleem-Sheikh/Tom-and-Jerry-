public class GameMap {
    private final int GRID_SIZE = 20; // 20x20 grid
    private String[][] grid; // To represent the grid
    private int tomX, tomY; // Tom's current position

    // Constructor
    public GameMap() {
        grid = new String[GRID_SIZE][GRID_SIZE];
        initializeRoomsAndObjects();
        tomX = 5; // Starting position (in the middle of the Living Room)
        tomY = 5;
    }

    // Define the rooms and objects on the grid
    private void initializeRoomsAndObjects() {
        // Initialize all cells as empty
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = "Empty";
            }
        }

        // Living Room
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = "Living Room";
            }
        }
        // Add Living Room objects
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 4; j++) {
                grid[i][j] = "Sofa";
            }
        }
        for (int i = 4; i <= 5; i++) {
            for (int j = 4; j <= 6; j++) {
                grid[i][j] = "Table";
            }
        }

        // Kitchen
        for (int i = 10; i < 14; i++) {
            for (int j = 0; j < 7; j++) {
                grid[i][j] = "Kitchen";
            }
        }
        // Add Kitchen objects
        for (int i = 11; i <= 12; i++) {
            for (int j = 1; j <= 2; j++) {
                grid[i][j] = "Fridge";
            }
        }
        for (int i = 12; i <= 13; i++) {
            for (int j = 4; j <= 5; j++) {
                grid[i][j] = "Stove";
            }
        }

        // Bedroom
        for (int i = 1; i < 9; i++) {
            for (int j = 10; j < 17; j++) {
                grid[i][j] = "Bedroom";
            }
        }
        // Add Bedroom objects
        for (int i = 2; i <= 4; i++) {
            for (int j = 11; j <= 14; j++) {
                grid[i][j] = "Bed";
            }
        }
        for (int i = 5; i <= 6; i++) {
            for (int j = 15; j <= 16; j++) {
                grid[i][j] = "Wardrobe";
            }
        }

        // Bathroom
        for (int i = 11; i < 17; i++) {
            for (int j = 12; j < 17; j++) {
                grid[i][j] = "Bathroom";
            }
        }
        // Add Bathroom objects
        for (int i = 13; i <= 14; i++) {
            for (int j = 13; j <= 14; j++) {
                grid[i][j] = "Sink";
            }
        }
        for (int i = 15; i <= 16; i++) {
            for (int j = 14; j <= 15; j++) {
                grid[i][j] = "Toilet";
            }
        }
    }

    // Get Tom's current room or object
    public String getCurrentRoomOrObject() {
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
