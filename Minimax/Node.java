
// This file defines a node in a minimax tree

import java.util.Vector;

public class Node
{
    public Data data;
    public Node parent; // reference to the parent node
    public Vector<Node> children; // reference to all the children nodes
    public boolean minmax; // node flag. false for min node, and true for max node
    public Integer alpha,beta; // alpha and beta for alpha-beta pruning
    
    public Node(Integer value, Node parent_node, boolean m, Integer path) // m: minmax flag; path: no. of branch
    {
        data = new Data(value);
        if (path != null)
            data.pathes.add(path);
        parent = parent_node;
        children = new Vector<Node>();
        minmax = m;
        alpha = Integer.MIN_VALUE;
        beta = Integer.MAX_VALUE;
    }
    
}