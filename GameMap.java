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

    // Get the room name at specific coordinates
    public String getRoom(int x, int y) {
        if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
            return grid[x][y];
        } else {
            return "You are out of the house.";
        }
    }

    // Get Tom's current room
    public String getCurrentRoom() {
        return grid[tomX][tomY];
    }
}
