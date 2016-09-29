
// javac EightPuzzle.java && java EightPuzzle

import java.util.Hashtable;

public class EightPuzzle
{
  public static String method = "ASTAR"; // BFS, DFS, IDS, GREEDY, ASTAR, IDA
  public static String heuristic = "MANHATTAN"; // "MANHATTAN" or "MISPLACE" or ""
  public static String level = "HARD"; // EASY, MEDIUM or HARD
  

  public static void main(String[] args)
  {
    Hashtable<String, String> levels = new Hashtable<String, String>();
    levels.put("EASY","(1 3 4 8 6 2 7 0 5)");
    levels.put("MEDIUM","(2 8 1 0 4 3 7 6 5)");
    levels.put("HARD","(5 6 7 4 0 8 3 2 1)");
    System.out.println("[Game Level] " + level + "  [Method] " + method + "  [Heuristic] " + heuristic);
    
    Node8 init = new Node8(levels.get(level)); // initial state
    
    Node8 solution = Search.GeneralSearch(init, method);
    
    if (solution == null)
      return;
    solution.printPath();
    System.out.println("Node visited: " + Search.nodeVisited);
    System.out.println("Max list length: " + Search.maxLength);
    System.out.println("Depth: " + solution.depth());
    
  }
  
}
