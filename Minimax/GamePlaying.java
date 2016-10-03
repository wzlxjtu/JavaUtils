
// javac GamePlaying.java && java GamePlaying

public class GamePlaying
{
    public static void main(String[] args)
    {
        String input = "(5 (((4 7 -2) 7) 6))";
        Node root = Tree.createTree(input);
        Traverse.GeneralSearch(root, "BFS");
        // System.out.println(root.v == null);
        minimax(root);
    }
    
    private static Integer minimax(Node node) // this function implements the minimax algorithm
    {
        if (node.v != null)
            return node.v;
        else if (node.minmax == true)
        {
            return max(minimax(node));
        }
        else
        {
            return min(minimax(node));
        }
    }
}

