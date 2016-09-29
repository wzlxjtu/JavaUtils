
// This file implements a bunch of search algorithms for eight puzzle game
package utils;

import utils.Node8;
import java.util.Vector;
import java.util.Hashtable;

public class Search
{
    public static int nodeVisited;
    public static int maxLength;
    // This hash table is used to store the visited states. Value can be true or null.
    // Keys are in string. True indicates that a state is already visited.
    private static Hashtable<String, Boolean> visited_states;
  
    public static Node8 GeneralSearch(Node8 problem, String Que_Fn)
    {
        Node8 node;
        Vector<Node8> nodeList = new Vector<Node8>();
        visited_states = new Hashtable<String, Boolean>();
        nodeVisited = 0;
        maxLength = 0;
        
        nodeList.add(problem);
        visited_states.put(problem.state_s, true);
        
        while(true)
        {
            if (nodeList.size() > maxLength)
                maxLength = nodeList.size();
            if (nodeList.isEmpty())
            {
                System.out.println("No Solution!");
                return null;
            }
            node = nodeList.firstElement();
            nodeList.removeElementAt(0);
            nodeVisited++;
            
            if (Node8.goal.equals(node.state_s))
            {
              System.out.println("Solution:");
              return node;
            }
            if (Que_Fn.equals("BFS"))
                nodeList = Que_Fn_BFS(nodeList, expand(node));
            if (Que_Fn.equals("DFS"))
                nodeList = Que_Fn_DFS(nodeList, expand(node));
        }
    }
    
    private static Vector<Node8> Que_Fn_BFS(Vector<Node8> src, Vector<Node8> expanded)
    {
        for (int i = 0; i < expanded.size(); i++)
        {
            src.insertElementAt(expanded.get(i), src.size());
        }
        return src;
    }
    
    private static Vector<Node8> Que_Fn_DFS(Vector<Node8> src, Vector<Node8> expanded)
    {
        for (int i = 0; i < expanded.size(); i++)
        {
            src.insertElementAt(expanded.get(i), 0);
        }
        return src;
    }
    
    private static Vector<Node8> expand(Node8 node)
    {
        Vector<Node8> expandedList = new Vector<Node8>();
        // Node8 new_node;
        
        // new_node = Node8.up(node);
        // if (new_node!=null)
        // {
        //     if (!visited_states.containsKey(new_node.state_s))
        //     {
        //         visited_states.put(new_node.state_s, true);
        //         expandedList.add(new_node);
        //     }
        // }
        // new_node = Node8.down(node);
        // if (new_node!=null)
        // {
        //     if (!visited_states.containsKey(new_node.state_s))
        //     {
        //         visited_states.put(new_node.state_s, true);
        //         expandedList.add(new_node);
        //     }
        // }
        // new_node = Node8.left(node);
        // if (new_node!=null)
        // {
        //     if (!visited_states.containsKey(new_node.state_s))
        //     {
        //         visited_states.put(new_node.state_s, true);
        //         expandedList.add(new_node);
        //     }
        // }
        // new_node = Node8.right(node);
        // if (new_node!=null)
        // {
        //     if (!visited_states.containsKey(new_node.state_s))
        //     {
        //         visited_states.put(new_node.state_s, true);
        //         expandedList.add(new_node);
        //     }
        // }
        
        if (Node8.up(node)!=null)
            expandedList.add(Node8.up(node));
        if (Node8.down(node)!=null)
            expandedList.add(Node8.down(node));
        if (Node8.left(node)!=null)
            expandedList.add(Node8.left(node));
        if (Node8.right(node)!=null)
            expandedList.add(Node8.right(node));
            
        return expandedList;
    }
}