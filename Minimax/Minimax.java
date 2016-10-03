
// This file implements the minimax algorithm
// If root is a max node, should call the function like 'root.data = Minimax.max(root);' to solve the problem

public class Minimax
{
    public static Data minimax(Node node) // this function implements the minimax algorithm
    {
        if ((node.data.v == null) && (node.minmax == true))
        {
            return max(node);
        }
        else if ((node.data.v == null) && (node.minmax == false))
        {
            return min(node);
        }
        else // (node.data.v != null)
            return node.data;
    }
    
    public static Data max(Node node)
    {
        Data maximum = new Data(Integer.MIN_VALUE);
        Integer max_branch = null;
        for (int i = 0; i < node.children.size(); i++)
        {
            Node child = node.children.get(i);
            if (child.data.v == null)
                child.data = minimax(child);
            if (child.data.v > maximum.v)
            {
                maximum = child.data;
                max_branch = i+1;
            }
        }
        if (max_branch != null)
            maximum.pathes.add(max_branch);
        return maximum;
    }
    
    public static Data min(Node node)
    {
        Data minimum = new Data(Integer.MAX_VALUE);
        Integer min_branch = null;
        for (int i = 0; i < node.children.size(); i++)
        {
            Node child = node.children.get(i);
            if (child.data.v == null)
                child.data = minimax(child);
            if (child.data.v < minimum.v)
            {
                minimum = child.data;
                min_branch = i+1;
            }
        }
        if (min_branch != null)
            minimum.pathes.add(min_branch);
        return minimum;
    }
}