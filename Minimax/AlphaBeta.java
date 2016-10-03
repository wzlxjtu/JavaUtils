
// This file implements the Alpha Beta pruning algorithm
// If root is a max node, should call the function like 'root.data = AlphaBeta.maxValue(root);' to solve the problem

public class AlphaBeta
{
    public static Data maxValue(Node node)
    {
        if (node.data.v != null)
            return node.data;
        node.data.v = Integer.MIN_VALUE;
        for (int i = 0; i < node.children.size(); i++)
        {
            Node child = node.children.get(i);
            child.alpha = node.alpha;
            child.beta = node.beta;
            node.data.v = max(node.data.v, minValue(child).v);
            if (node.data.v >= node.beta)
            {
                System.out.print("MAX cut after " + node.data.v + " in subtree (");
                Traverse.GeneralSearch(node, "BFS");
                System.out.println("  )");
                return node.data;
            }
                
            node.alpha = max(node.alpha,node.data.v);
        }
        return node.data;
    }
    
    public static Data minValue(Node node)
    {
        if (node.data.v != null)
            return node.data;
        node.data.v = Integer.MAX_VALUE;
        for (int i = 0; i < node.children.size(); i++)
        {
            Node child = node.children.get(i);
            child.alpha = node.alpha;
            child.beta = node.beta;
            node.data.v = min(node.data.v, maxValue(child).v);
            if (node.data.v <= node.alpha)
            {
                System.out.print("MIN cut after " + node.data.v + " in subtree (");
                Traverse.GeneralSearch(node, "BFS");
                System.out.println("  )");
                return node.data;
            }
            node.beta = min(node.beta,node.data.v);
        }
        return node.data;
    }
    
    public static Integer max(Integer x, Integer y)
    {
        if (x > y)
            return x;
        else
            return y;
    }
    
    public static Integer min(Integer x, Integer y)
    {
        if (x < y)
            return x;
        else
            return y;
    }
}