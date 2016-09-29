
// This file implements a bunch of search algorithms for eight puzzle game

import java.util.Vector;
import java.util.Hashtable;
import java.util.Collections;

public class Search
{
    public static int nodeVisited;
    public static int maxLength;
    
    public static Node8 GeneralSearch(Node8 problem, String Que_Fn)
    {
        // Possible choices for Que_fn are BFS, DFS, IDS, GREEDY, ASTAR, IDA
        Node8 node;
        Vector<Node8> nodeList = new Vector<Node8>();
        nodeVisited = 0;
        maxLength = 0;
        int depth_limit = 0;
        
        nodeList.add(problem);

        while(true)
        {
            if (nodeList.size() > maxLength)
                maxLength = nodeList.size();
            if (nodeList.isEmpty())
            {
                if (Que_Fn.equals("IDS"))
                {
                    depth_limit++;
                    nodeList.add(problem);
                }
                else
                {
                    System.out.println("No Solution!");
                    return null;
                }
            }
            node = nodeList.firstElement();
            nodeList.removeElementAt(0);
            nodeVisited++;
            
            if (Node8.Solved(node))
            {
              System.out.println("Solution:");
              return node;
            }
            
            if (Que_Fn.equals("BFS"))
                nodeList = Que_Fn_BFS(nodeList, node);
            if (Que_Fn.equals("DFS"))
                nodeList = Que_Fn_DFS(nodeList, node);
            if (Que_Fn.equals("IDS"))
                nodeList = Que_Fn_DLS(nodeList, node, depth_limit);
            if (Que_Fn.equals("GREEDY"))
                nodeList = Que_Fn_GREEDY(nodeList, node);
            if (Que_Fn.equals("ASTAR"))
                nodeList = Que_Fn_ASTAR(nodeList, node);
        }
    }
    
    
    private static Vector<Node8> Que_Fn_GREEDY(Vector<Node8> src, Node8 node)
    {
        Vector<Node8> expanded = expand(node);
        for (int i = 0; i < expanded.size(); i++)
        {
            expanded.get(i).f = expanded.get(i).h;
            src.addElement(expanded.get(i));
        }
        Collections.sort(src);
        return src;
    }
    
    private static Vector<Node8> Que_Fn_ASTAR(Vector<Node8> src, Node8 node)
    {
        Vector<Node8> expanded = expand(node);
        for (int i = 0; i < expanded.size(); i++)
        {
            expanded.get(i).f = expanded.get(i).h + expanded.get(i).depth();
            src.addElement(expanded.get(i));
        }
        
        // for (int i = 0; i < src.size(); i++)
        // {
        //     System.out.print(src.get(i).f + " ");
        // }
        
        Collections.sort(src);
        
        // System.out.println("");
        // for (int i = 0; i < src.size(); i++)
        // {
        //     System.out.print(src.get(i).f + " ");
        // }
        
        // System.out.println("");
        // System.out.println("");
        
        return src;
    }
    
    private static Vector<Node8> Que_Fn_BFS(Vector<Node8> src, Node8 node)
    {
        Vector<Node8> expanded = expand(node);
        for (int i = 0; i < expanded.size(); i++)
        {
            src.insertElementAt(expanded.get(i), src.size());
        }
        return src;
    }
    
    private static Vector<Node8> Que_Fn_DFS(Vector<Node8> src, Node8 node)
    {
        Vector<Node8> expanded = expand(node);
        for (int i = 0; i < expanded.size(); i++)
        {
            src.insertElementAt(expanded.get(i), 0);
        }
        return src;
    }
    
    private static Vector<Node8> Que_Fn_DLS(Vector<Node8> src, Node8 node, int depth_limit)
    {
        if (node.depth() == depth_limit)
        {
            return src;
        }
        else
        {
            Vector<Node8> expanded = expand(node);
            for (int i = 0; i < expanded.size(); i++)
            {
                src.insertElementAt(expanded.get(i), 0);
            }
            return src;
        }
    }
    
    private static Vector<Node8> expand(Node8 node)
    {
        Vector<Node8> expandedList = new Vector<Node8>();
        
        if (Node8.up(node)!=null)
        {
            if (node.path.size() > 0)
            {
                if (!node.path.lastElement().equals("DOWN")) // prune the branch: up-> down-> up-> down...
                {
                    expandedList.add(Node8.up(node));
                }
            }
            else
            {
                expandedList.add(Node8.up(node));
            }
        }
        if (Node8.down(node)!=null)
        {
            if (node.path.size() > 0)
            {
                if (!node.path.lastElement().equals("UP"))
                {
                    expandedList.add(Node8.down(node));
                }
            }
            else
            {
                expandedList.add(Node8.down(node));
            }
        }
        if (Node8.left(node)!=null)
        {
            if (node.path.size() > 0)
            {
                if (!node.path.lastElement().equals("RIGHT"))
                {
                    expandedList.add(Node8.left(node));
                }
            }
            else
            {
                expandedList.add(Node8.left(node));
            }
        }
        if (Node8.right(node)!=null)
        {
            if (node.path.size() > 0)
            {
                if (!node.path.lastElement().equals("LEFT"))
                {
                    expandedList.add(Node8.right(node));
                }
            }
            else
            {
                expandedList.add(Node8.right(node));
            }
        }
            
        return expandedList;
    }
}