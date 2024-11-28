import java.util.ArrayList;

public class Tom3 {
    // Attributes
    int energyLevel;
    int steps;
    boolean hasJerry;
    ArrayList<String> location; // Map of rooms
    int currentIndex; // Tracks Tom's current position in the map
    String direction;

    // Constructor
    public Tom3() {
        this.energyLevel = 100;
        this.steps = 0;
        this.hasJerry = false;
        this.location = new ArrayList<>(2);
        this.currentIndex = 0; // Start in the Living Room 
        this.direction= "North";

        this.location.add("Living Room");
        this.location.add("Kitchen");
        //this.location.add("washroom");
        }

    public void changeRoom(){
        if (this.currentIndex== 0){
            currentIndex += 1;
            System.out.println("Tom is now in the " + this.location.get(currentIndex));
        }else if (this.currentIndex==1){
            currentIndex -=1;
            System.out.println("Tom is now in the " + this.location.get(currentIndex));

        }else{
            throw new RuntimeException("Tom is outside the hosue");
        }

    }

    public void goForward(){
        this.steps+=1;
        this.energyLevel-=2;
        if (this.steps==5){
            System.out.println("You are in the middle of the room!!");}
        else if(this.steps ==10){
            changeRoom();
        } 
        else {
            goForward();
        }   

    }
    

    public void goBackward(){
        this.steps+=1;
        this.energyLevel-=2;
        if (this.steps==5){
            System.out.println("You are in the middle of the room!!");}
        else if(this.steps ==10){
            changeRoom();
        } 
        else {
            goBackward();
        }   
    }

    public void goRight(){
        // Change direction when turning right
        if (this.direction.equals("NORTH")) {
            this.direction = "EAST";
        } else if (this.direction.equals("EAST")) {
            this.direction = "SOUTH";
        } else if (this.direction.equals("SOUTH")) {
            this.direction = "WEST";
        } else if (this.direction.equals("WEST")) {
            this.direction = "NORTH";
        }
        System.out.println("Tom turned right. Now facing: " + this.direction);
    
    }

    public void goLeft(){
        // Change direction when turning left
        if (this.direction.equals("NORTH")) {
        this.direction = "WEST";
        } else if (this.direction.equals("WEST")) {
        this.direction = "SOUTH";
        } else if (this.direction.equals("SOUTH")) {
        this.direction = "EAST";
        } else if (this.direction.equals("EAST")) {
        this.direction = "NORTH";
        }
        System.out.println("Tom turned left. Now facing: " + this.direction);
    }


    public static void main(String[] args) {
        Tom3 tom = new Tom3();
        /*tom.changeRoom();
        tom.changeRoom();*/
        tom.goForward();
        tom.goForward();
    }
}
