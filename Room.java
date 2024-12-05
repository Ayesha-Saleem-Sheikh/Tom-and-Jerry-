public class Room {
    String name;
    int serial;

    public Room(String name, int serial){
        this.name=name;
        this.serial=serial;
    }

    public String toString(){
        return name +"("+serial+")";
    }
    
}