
// javac EightPuzzle.java && java EightPuzzle

import utils.Array;
import utils.Node8;
import java.util.Hashtable;
public class EightPuzzle
{
  private static String goal = "(1 2 3 8 0 4 7 6 5)";
  // This hash table is used to store the visited states. Value can be true or null.
  // Keys are in string. True indicates that a state is already visited.
  private static Hashtable<String, Boolean> visited_states = new Hashtable<String, Boolean>();
  
  public static void main(String[] args)
  {
    System.out.print("Please enter the puzzle in parathesis,\nan example being: (8 7 6 5 4 3 2 1 0):\n");
    
    Node8 init = new Node8("(8 7 6 5 4 3 2 1 0)"); // initial state
    // String Input = System.console().readLine();
    // System.out.println("Your input is: " + input);
    
    visited_states.put(init.state_s, true);
    
    if (goal.equals(init.state_s))
    {
      System.out.println("Search Finished, no movement requried!");
      return;
    }
    
    Node8 node = Node8.left(init);
    node = Node8.up(node);
    node = Node8.right(node);
    node = Node8.up(node);
    // if (node == null)
    // {
    //   System.out.println("can't move!");
    // }
    // else
    // {
    //   node.state_a.print();
    //   System.out.println(node.state_s);
    // }
    node.printPath();
    
  }
  
  
  
}
