
// each node is a state in the tree for the 8 puzzle

package utils;

import utils.Array;
import java.util.Vector;

public class Node8 
  {
    public String state_s; // a string used to store the state
    public Array state_a; // an array used to store the state
    public int h; // heuristic value
    public int depth; // depth from the root
    public Vector<String> path; // list of moves
    
    public Node8(String s)
    {
      state_s = s;
      state_a = new Array(StringToArray());
      h = -1;
      depth = -1;
      path = new Vector<String>();
    }
    
    public void printPath()
    {
      for (int i = 0; i < path.size(); i++)
      {
        System.out.println(path.get(i));
      }
    }
    
    // After each movement, a new node is generated
    public static Node8 up(Node8 node) // move 0 upward
    {
        if ((node.ZeroPos() != 0) && (node.ZeroPos() != 1) && (node.ZeroPos() != 2))
        {
          node.swap(node.ZeroPos(), node.ZeroPos() - 3);
          node.path.add("UP");
          return node;
        }
        else
        {
          return null;
        }
    }
    public static Node8 down(Node8 node) // move 0 downward
    {
        if ((node.ZeroPos() != 6) && (node.ZeroPos() != 7) && (node.ZeroPos() != 8))
        {
          node.swap(node.ZeroPos(), node.ZeroPos() + 3);
          node.path.add("DOWN");
          return node;
        }
        else
        {
          return null;
        }
    }
    public static Node8 left(Node8 node) // move 0 leftward
    {
        if ((node.ZeroPos() != 0) && (node.ZeroPos() != 3) && (node.ZeroPos() != 6))
        {
          node.swap(node.ZeroPos(), node.ZeroPos() - 1);
          node.path.add("LEFT");
          return node;
        }
        else
        {
          return null;
        }
      }
    public static Node8 right(Node8 node) // move 0 leftward
    {
        if ((node.ZeroPos() != 2) && (node.ZeroPos() != 5) && (node.ZeroPos() != 8))
        {
          node.swap(node.ZeroPos(), node.ZeroPos() + 1);
          node.path.add("RIGHT");
          return node;
        }
        else
        {
          return null;
        }
    }
    
    private Array StringToArray()// convert from string to an array of numbers
    {
      Array state_array = new Array();
      for (int i = 1; i < 18; i+=2)
      {
        state_array.add(Character.getNumericValue(state_s.charAt(i)));
      }
      return state_array;
    }
    
    private int ZeroPos() // find the index of zero
    {
      return state_a.find(0);
    }
    
    private void swap(int i, int j)
    {
      if (i > j) // make sure that i < j
      {
        int temp = i;
        i = j;
        j = temp;
      }
      state_a.swap(i,j);
      state_s = state_s.substring(0,2*i)+" "+state_s.charAt(2*j+1)+
      state_s.substring(2*i+2,2*j)+" "+state_s.charAt(2*i+1)+
      state_s.substring(2*j+2);
    }
  }
  
  