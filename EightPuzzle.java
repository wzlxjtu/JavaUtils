
// javac EightPuzzle.java && java EightPuzzle

import utils.Array;
import utils.Node8;
import utils.Search;
public class EightPuzzle
{
  public static void main(String[] args)
  {
    // System.out.print("Please enter the puzzle in parathesis,\nan example being: (8 7 6 5 4 3 2 1 0):\n");
    String easy = "(1 3 4 8 6 2 7 0 5)";
    String medium = "(2 8 1 0 4 3 7 6 5)";
    String hard = "(5 6 7 4 0 8 3 2 1)";
    Node8 init = new Node8(medium); // initial state
    // String Input = System.console().readLine();
    // System.out.println("Your input is: " + input);
    
    
    Node8 solution = Search.GeneralSearch(init, "GREEDY");
    
    if (solution == null)
      return;
    solution.printPath();
    System.out.println("Node visited: " + Search.nodeVisited);
    System.out.println("Max list length: " + Search.maxLength);
    System.out.println("Depth: " + solution.depth());
    
    // Node8 test = new Node8("(5 4 0 6 1 8 7 3 2)");
    // System.out.println(test.h2);
  }
  
}
