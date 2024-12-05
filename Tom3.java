public class Tom3 {
    // Attributes
    int energyLevel;
    int steps;
    boolean hasJerry;
    int currentX; // Tom's current X-coordinate
    int currentY; // Tom's current Y-coordinate
    String direction; // Tracks Tom's direction
    GameMap gameMap; // Reference to the GameMap

    // Constructor
    public Tom3() {
        this.energyLevel = 100;
        this.steps = 0;
        this.hasJerry = false;
        this.currentX = 1; // Start at Living Room (1,1)
        this.currentY = 1;
        this.direction = "NORTH";
        this.gameMap = new GameMap(); // Initialize GameMap
        System.out.println("Tom starts in the " + gameMap.getRoom(currentX, currentY));
    }

    public void changeRoom(){

    }

    public void goForward(){
        this.steps+=1;
        this.energyLevel-=2;
        if (this.steps==5){
            System.out.println("You are int the middle of the room!!");}
        else if(this.steps ==10){
            changeRoom();
        }
        else {
            goForward();
        }

    }
    

    public void goBackward(){
        this.steps-=1;
        
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

