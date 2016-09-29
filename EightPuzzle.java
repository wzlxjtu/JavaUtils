
// javac EightPuzzle.java && java EightPuzzle

import utils.Array;
import utils.Node8;
import utils.Search;
public class EightPuzzle
{
    public static void main(String[] args)
  {
    // System.out.print("Please enter the puzzle in parathesis,\nan example being: (8 7 6 5 4 3 2 1 0):\n");
    
    Node8 init = new Node8("(2 8 1 0 4 3 7 6 5)"); // initial state
    // String Input = System.console().readLine();
    // System.out.println("Your input is: " + input);
    
    
    if (Node8.goal.equals(init.state_s))
    {
      System.out.println("Search Finished, no movement requried!");
      return;
    }
    
    Node8 solution = Search.GeneralSearch(init, "BFS");
    solution.printPath();
    System.out.println("Path length: " + solution.path.size());
    System.out.println("Node visited: " + Search.nodeVisited);
    System.out.println("Max list length: " + Search.maxLength);
  }
  
}
