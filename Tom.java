import java.util.ArrayList;
import java.util.Scanner;

public class Tom{
    public enum Rooms{
        LivingRoom,DinningRoom ,WashRoom
    }
    
    //attributes//
    int energyLevel;
    int steps;
    boolean hasJerry;
    ArrayList<Rooms> location;

    public Tom(){
        this.energyLevel=100;
        this.steps=0;
        this.hasJerry=false;
        this.location = new ArrayList<Rooms>();
    }

    public void lookAround(){
        if (this.location == Rooms.LivingRoom){
            System.out.println("You are in the living room. In the living room there are 2 soafs and 1 table ");}
        else if (this.location== Rooms.WashRoom){
            System.out.println("You are in the washroom");
        
        }else{

        }System.out.println("You are in the kitchen ");

        }

    

 
    public void go(){
        if (this.energyLevel>0){
            if (this.energyLevel<5){
                System.out.println("Energy level getting low retreat ti the kitchen!!");
                this.energyLevel -=2;
                this.steps +=1;
            }
            else{
                this.energyLevel -=2;
                this.steps +=1;
            }}
        else{
            throw new RuntimeException("Energy over!! .Restart the game");} }
    
     public void grab(String object) {
        Scanner scanner = new Scanner(System.in);
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

    public void jump(){
        energyLevel -=4;
        System.out.println("carefull when jumping!!");}

    //public void Lookaround(){

    //}

    public static void main(String[] args) {
        Tom tom= new Tom();
    
    }


    }

    
    
    



