
// This file implements search algorithms to traverse the tree
// BFS, DFS

import java.util.Vector;

public class Traverse
{
    public static Node GeneralSearch(Node problem, String Que_Fn)
    {
        // Possible choices for Que_fn are BFS, DFS
        Node node;
        Vector<Node> nodeList = new Vector<Node>();
        
        nodeList.add(problem); // nodeList is the queue. problem is the root node here

        while(true)
        {
            if (nodeList.isEmpty())
            {
               return null;
            }
            // dequeue the first element
            node = nodeList.firstElement();
            nodeList.removeElementAt(0);
            
            // System.out.println(node.alpha);
            
            // PRINT alpha or beta
            // if (node.alpha == Integer.MIN_VALUE)
            //     System.out.print("  n");
            // else
            //     System.out.format("%3d", node.alpha);
            
            // PRINT value
            if (node.data.v != null)
                System.out.format("%3d", node.data.v);
            else
                System.out.print("  n");
            
            if (Que_Fn.equals("BFS"))
                nodeList = Que_Fn_BFS(nodeList, node);
            if (Que_Fn.equals("DFS"))
                nodeList = Que_Fn_DFS(nodeList, node);
        }
    }

    
    private static Vector<Node> Que_Fn_BFS(Vector<Node> src, Node node)
    {
        Vector<Node> expanded = expand(node);
        for (int i = 0; i < expanded.size(); i++)
        {
            src.insertElementAt(expanded.get(i), src.size());
        }
        return src;
    }
    
    private static Vector<Node> Que_Fn_DFS(Vector<Node> src, Node node)
    {
        Vector<Node> expanded = expand(node);
        for (int i = 0; i < expanded.size(); i++)
        {
            src.insertElementAt(expanded.get(i), 0);
        }
        return src;
    }
    
    // expand the current node and stores all the children in a vector
    private static Vector<Node> expand(Node node)
    {
        Vector<Node> expandedList = new Vector<Node>();
        for (int i = 0; i < node.children.size(); i++)
        {
            expandedList.add(node.children.get(i));
        }
        return expandedList;
    }
}