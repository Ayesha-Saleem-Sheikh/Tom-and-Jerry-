import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class GameMap {
    private Table<Integer, Integer, String> roomMap;

    public GameMap() {
        roomMap = HashBasedTable.create();
        initializeRooms();
    }

    // Initialize the 2D map with room names
    private void initializeRooms() {
        roomMap.put(1, 1, "Living Room");
        roomMap.put(2, 1, "Kitchen");
        roomMap.put(1, 2, "Bedroom");
        roomMap.put(2, 2, "Bathroom");
    }

    // Get room name by coordinates
    public String getRoom(int x, int y) {
        return roomMap.get(x, y);
    }

    // Check if a room exists at given coordinates
    public boolean isRoomAvailable(int x, int y) {
        return roomMap.contains(x, y);
    }
}
