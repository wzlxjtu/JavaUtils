
// each node is a state in the tree for the 8 puzzle

package utils;

import utils.Array;
import java.util.Vector;
import java.lang.Math;

public class Node8 
  {
    public int h1; // heuristic based on number misplaced tiles
    public int h2; // heuristic based on total Manhattan distance
    public Vector<String> path; // list of moves
    private Array state; // an array used to store the state
    private static int[] goal = new int[] {1,2,3,8,0,4,7,6,5}; // the goal state
    private static Vector<int[]> IndexPos = ConstructIndex();
    // the correct position (x,y) for index i
    private static Vector<int[]> ManhattanPos = ConstructManhattan();
    // the correct Manhattan position (x,y) for 0 ~ 8
    
    
    public Node8(String s) // this constructor should only be used to construct the initial state
    {      
      state = new Array(StringToArray(s));
      path = new Vector<String>();
      CalculateHeuristics();
    }
    
    public Node8(Node8 node)
    {
      state = new Array(node.state);
      path = new Vector<String>(node.path);
      CalculateHeuristics();
    }
    
    public void printPath()
    {
      for (int i = 0; i < path.size(); i++)
      {
        System.out.print(path.get(i) + " ");
      }
      System.out.println("");
    }
    
    public void printPuzzle()
    {
        System.out.println("Puzzle State:");
        System.out.println(state.get(0) + " " + state.get(1) + " " + state.get(2));
        System.out.println(state.get(3) + " " + state.get(4) + " " + state.get(5));
        System.out.println(state.get(6) + " " + state.get(7) + " " + state.get(8));
    }
    
    public int depth() // return the depth of the node
    {
      return path.size();
    }
    // After each movement, a new node is generated
    public static Node8 up(Node8 src) // move 0 upward
    {
        Node8 node = new Node8(src);
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
    public static Node8 down(Node8 src) // move 0 downward
    {
        Node8 node = new Node8(src);
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
    public static Node8 left(Node8 src) // move 0 leftward
    {
        Node8 node = new Node8(src);
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
    public static Node8 right(Node8 src) // move 0 leftward
    {
        Node8 node = new Node8(src);
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
    
    public static boolean Solved(Node8 node) // return true if the goal is found
    {
      for (int i = 0; i < node.state.size(); i++)
      {
        if (node.state.get(i) != goal[i])
          return false;
      }
      return true;
    }

    private Array StringToArray(String s)// convert from string to an array of numbers
    {
      Array state_array = new Array();
      for (int i = 1; i < 18; i+=2)
      {
        state_array.add(Character.getNumericValue(s.charAt(i)));
      }
      return state_array;
    }
    
    private int ZeroPos() // find the index of zero
    {
      return state.find(0);
    }
    
    private void swap(int i, int j)
    {
      if (i > j) // make sure that i < j
      {
        int temp = i;
        i = j;
        j = temp;
      }
      state.swap(i,j);
    }
    
    private void CalculateHeuristics()
    {
      int num;
      h1 = 0;
      h2 = 0;
      for (int i = 0; i < state.size(); i++)
      {
        num = state.get(i);
        if (num != 0)
        {
          if (num != goal[i])
            h1++;
          h2 += Math.abs(IndexPos.get(i)[0] - ManhattanPos.get(num)[0]) + Math.abs(IndexPos.get(i)[1] - ManhattanPos.get(num)[1]);
        }
      }
    }
    
    private static Vector<int[]> ConstructManhattan()
    {
      Vector<int[]> ManhattanPos = new Vector<int[]>();
      ManhattanPos.addElement(new int[] {1,1});
      ManhattanPos.addElement(new int[] {0,0});
      ManhattanPos.addElement(new int[] {0,1});
      ManhattanPos.addElement(new int[] {0,2});
      ManhattanPos.addElement(new int[] {1,2});
      ManhattanPos.addElement(new int[] {2,2});
      ManhattanPos.addElement(new int[] {2,1});
      ManhattanPos.addElement(new int[] {2,0});
      ManhattanPos.addElement(new int[] {1,0});
      return ManhattanPos;
    }
    
    private static Vector<int[]> ConstructIndex()
    {
      Vector<int[]> IndexPos = new Vector<int[]>();
      IndexPos.addElement(new int[] {0,0});
      IndexPos.addElement(new int[] {0,1});
      IndexPos.addElement(new int[] {0,2});
      IndexPos.addElement(new int[] {1,0});
      IndexPos.addElement(new int[] {1,1});
      IndexPos.addElement(new int[] {1,2});
      IndexPos.addElement(new int[] {2,0});
      IndexPos.addElement(new int[] {2,1});
      IndexPos.addElement(new int[] {2,2});
      return IndexPos;
    }
  }
  
  