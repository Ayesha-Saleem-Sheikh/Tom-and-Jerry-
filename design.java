public class Design {
    private final int GRID_SIZE = 20; // 20x20 grid
    private String[][] grid; // To represent the grid
    private int tomX, tomY; // Tom's current position

    // Constructor
    public Design() {
        grid = new String[GRID_SIZE][GRID_SIZE];
        initializeRoomsAndObjects();
        tomX = 6; // Starting position (as per map)
        tomY = 1;
    }

    // Define the rooms, walls, doors, and objects on the grid
    private void initializeRoomsAndObjects() {
        // Initialize all cells as "Empty"
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = "Empty";
            }
        }

        // Add walls based on the provided map
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (i == 0 || j == 0 || i == GRID_SIZE - 1 || j == GRID_SIZE - 1) {
                    grid[i][j] = "Wall"; // Outer boundary walls
                }
            }
        }
        // Add walls, doors, and rooms based on the map image
        // Living Room
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                grid[i][j] = "Living Room";
            }
        }

        // Bedroom
        for (int i = 1; i <= 8; i++) {
            for (int j = 10; j <= 18; j++) {
                grid[i][j] = "Bedroom";
            }
        }

        // Kitchen
        for (int i = 11; i <= 16; i++) {
            for (int j = 1; j <= 8; j++) {
                grid[i][j] = "Kitchen";
            }
        }

        // Bathroom
        for (int i = 11; i <= 16; i++) {
            for (int j = 11; j <= 18; j++) {
                grid[i][j] = "Bathroom";
            }
        }

        // Add walls inside rooms
        grid[9][1] = "Wall"; grid[9][2] = "Wall";
        // More wall coordinates...

        // Add doors
        grid[4][9] = "Door"; // Living Room <-> Bedroom
        grid[12][9] = "Door"; // Kitchen <-> Bathroom
        grid[9][6] = "Door"; // Living Room <-> Kitchen
        grid[9][14] = "Door"; // Bedroom <-> Bathroom
    }

    // Move Tom by one step
    public boolean moveTom(String direction) {
        int newX = tomX;
        int newY = tomY;

        switch (direction.toLowerCase()) {
            case "north":
                newY -= 1;
                break;
            case "south":
                newY += 1;
                break;
            case "east":
                newX += 1;
                break;
            case "west":
                newX -= 1;
                break;
            default:
                System.out.println("Invalid direction. Use 'north', 'south', 'east', or 'west'.");
                return false;
        }

        // Check if the new position is within bounds and not a wall
        if (newX >= 0 && newX < GRID_SIZE && newY >= 0 && newY < GRID_SIZE) {
            if (grid[newY][newX].equals("Wall")) {
                System.out.println("Tom can't move there! It's blocked by a wall.");
                return false;
            } else {
                tomX = newX;
                tomY = newY;
                System.out.println("Tom moved to " + getPosition() + " in " + getCurrentRoomOrObject());
                return true;
            }
        } else {
            System.out.println("Tom can't move outside the house!");
            return false;
        }
    }

    // Get Tom's current position
    public String getPosition() {
        return "(" + tomX + ", " + tomY + ")";
    }

    // Get Tom's current room or object
    public String getCurrentRoomOrObject() {
        return grid[tomY][tomX];
    }
}
