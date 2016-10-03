// This file defines a node in a minimax tree

import java.util.Vector;

public class Node
{
    public Integer v; // value
    public Node parent; // reference to the parent node
    public Vector<Node> children; // reference to all the children nodes
    public boolean minmax; // node flag. false for min node, and true for max node
    
    public Node(Integer value, Node parent_node, boolean m)
    {
        v = value;
        parent = parent_node;
        children = new Vector<Node>();
        minmax = m;
    }
    
    public Integer maxChild()
    {
        Integer max = Integer.MIN_VALUE;
        if (children.size() == 0)
            return null;
        for (int i = 0; i < children.size(); i++)
        {
            if (children.get(i).v > max)
                max = children.get(i).v;
        }
        return max;
    }
    
    public Integer minChild()
    {
        Integer min = Integer.MAX_VALUE;
        if (children.size() == 0)
            return null;
        for (int i = 0; i < children.size(); i++)
        {
            if (children.get(i).v < min)
                min = children.get(i).v;
        }
        return min;
    }
}