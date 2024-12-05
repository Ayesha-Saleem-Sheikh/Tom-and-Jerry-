import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
public class Game {
  public static void main(String[] args) {

    // Example ImmutableGraph with Strings as Node data
    ImmutableGraph<String> myGraph = GraphBuilder.undirected()
      .<String>immutable()
      .putEdge("Living Room", "Kitchen")
      .build();

    //System.out.println(myGraph);

    // Example ImmutableGraph with Buildings as Node data
  Room livingRoom = new Room("Living Room", 0);
  Room kitchen = new Room("Kitchne", 1);

  
    ImmutableGraph<Room> myGraph2 = GraphBuilder.undirected()
      .<Room>immutable()
      .putEdge(livingRoom, kitchen)
      //.putEdge(mcConnell, sabinReed)
      .build();

      System.out.println(myGraph2);
      System.out.println(myGraph);
      
  }

}
