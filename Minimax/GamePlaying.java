
// This is the main entrance of the Minimax problem
// To execute, enter the following command:
// javac GamePlaying.java && java GamePlaying

import java.util.Vector;

public class GamePlaying
{
    public static int case_number = 0; // choose 0 ~ 4 to select between five test cases
    
    public static Node ori_tree; // used to store the original tree with original values. n for non-leaf nodes
    private static Vector<String> inputs = new Vector<String>();
    
    public static void main(String[] args)
    {
        // Five example inputs are listed below
        inputs.add("((4 (7 9 8) 8) (((3 6 4) 2 6) ((9 2 9) 4 7 (6 4 5))))");
        inputs.add("(((1 4) (3 (5 2 8 0) 7 (5 7 1)) (8 3)) (((3 6 4) 2 (9 3 0)) ((8 1 9) 8 (3 4 ))))");
        inputs.add("(5 (((4 7 -2) 7) 6))");
        inputs.add("((8 (7 9 8) 4) (((3 6 4) 2 1) ((6 2 9) 4 7 (6 4 5))))");
        inputs.add("(((1 (4 7)) (3 ((5 2) (2 8 9) 0 -2) 7 (5 7 1)) (8 3)) (((8 (9 3 2) 5) 2 (9 (3 2) 0)) ((3 1 9) 8 (3 4 ))))");
        
        String input = inputs.get(case_number);
        
        Node root = Tree.createTree(input);
        // Traverse.GeneralSearch(root, "BFS");
        
        System.out.println("[Subtree shown in BFS order]");
        root.data = AlphaBeta.maxValue(root);
        
        root = Tree.createTree(input);
        root.data = Minimax.max(root);
        
        Tree.printPath(root.data.pathes);
        
    }
    
}

