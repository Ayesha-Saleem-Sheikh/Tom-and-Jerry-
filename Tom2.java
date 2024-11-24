import java.util.ArrayList;
import java.util.Scanner;

public class Tom2 {
    //public enum Rooms {
    //LivingRoom, DiningRoom, WashRoom
    //}

    // Attributes
    int energyLevel;
    int steps;
    boolean hasJerry;
    ArrayList<Integer> location; // Map of rooms
    int currentIndex; // Tracks Tom's current position in the map

    // Constructor
    public Tom2() {
        this.energyLevel = 100;
        this.steps = 0;
        this.hasJerry = false;
        this.location = new ArrayList<>(2);
        this.currentIndex = 0; // Start in the Living Room

        // Populate the map of rooms
        /*this.location.add(Rooms.LivingRoom);
        this.location.add(Rooms.DiningRoom);
        this.location.add(Rooms.WashRoom);/* */
    }

    // Method to display the current room
    public void lookAround() {
        if (currentIndex >= 0 && currentIndex < location.size()) {
            Rooms currentRoom = location.get(currentIndex);
            switch (currentRoom) {
                case LivingRoom -> System.out.println("You are in the Living Room. There are 2 sofas and 1 table.");
                case DiningRoom ->
                    System.out.println("You are in the Dining Room. There is a dining table and chairs.");
                case WashRoom -> System.out.println("You are in the Washroom. There is a sink and a mirror.");
            }
        } else {
            System.out.println("You are in an undefined space!");
        }
    }

    // Method to move to the next room
    public void goToNextRoom(){
        if (energyLevel <= 0) {
            throw new RuntimeException("Energy over! Restart the game.");
        
        if (currentIndex < location.size() - 1) {
            currentIndex++; // Move to the next room
            energyLevel -= 2; // Deduct energy
            steps++; // Increase steps
            System.out.println("You moved to the " + location.get(currentIndex));
        }else {
            System.out.println("You are at the last room. Can't go further!");
        }
    }

    // Method to move to the previous room
    public String  goToPreviousRoom(){
        if (energyLevel <= 0) {
            throw new RuntimeException("Energy over! Restart the game.");}
        else{
            if (currentIndex > 0) {
                currentIndex--; // Move to the previous room
                energyLevel -= 2; // Deduct energy
                steps++; // Increase steps
               return "You moved back to the " + location.get(currentIndex);
            } else {
            return "You are at the first room. Can't go back!";
        }
    }
}

    
    


// Method to move to the previous room
public String goToPreviousRoom(){
    if (energyLevel <= 0) {
        throw new RuntimeException("Energy over! Restart the game.");
    } else {
        if (currentIndex > 0) {
            currentIndex--; // Move to the previous room
            energyLevel -= 2; // Deduct energy
            steps++; // Increase steps
            return "You moved back to the " + location.get(currentIndex);
        } else {
            return "You are at the first room. Can't go back!";
        }
    }
}




    

    // Method to grab an object
    public void grab(String object) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("There is " + object + " in front of you. Do you want to grab it? (yes/no)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("yes")) {
                if (object.equalsIgnoreCase("Jerry")) {
                    hasJerry = true;
                    System.out.println("Tom grabs Jerry! You caught him!");
                } else {
                    System.out.println("Tom grabs the " + object + ".");
                }
            } else if (input.equalsIgnoreCase("no")) {
                System.out.println("Tom decides not to grab the " + object + ".");
            } else {
                System.out.println("Invalid input. Tom does nothing.");
            }
        }
    }

    // Method to jump
    public void jump() {
        if (energyLevel >= 4) {
            energyLevel -= 4;
            System.out.println("Careful when jumping!");
        } else {
            System.out.println("Not enough energy to jump!");
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Tom tom = new Tom();

        // Start the game
        tom.lookAround(); // Display the current room

        // Move between rooms
        tom.goToNextRoom(); // Move to Dining Room
        tom.lookAround();

        tom.goToNextRoom(); // Move to Washroom
        tom.lookAround();

        tom.goToPreviousRoom(); // Move back to Dining Room
        tom.lookAround();

        // Try grabbing an object
        tom.grab("Jerry");

        // Try jumping
        tom.jump();
        System.out.println("Energy Level: " + tom.energyLevel);
    }
}

}
