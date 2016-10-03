
// This class use a recursive function to parse the input and generate a tree
// An example for an valid input: (5 (((4 7 -2) 7) 6))

import java.util.Vector;

public class Tree
{
    private static int index;
    
    public static Node createTree(String input)
    {
        index = 0;
        Node root = new Node(null,null,true);
        parseInput(input.substring(1, input.length() - 1), root);
        return root;
    }
    
    public static void parseInput(String input, Node parent)
    {
        boolean m = !parent.minmax; // flip between min and max layer
        while (index < input.length())
        {
            Node node = new Node(null, parent, m);
            char c = input.charAt(index);
            index++;
            if (c == ' ')
            {
                continue;
            }
            else if (c == '(')
            {
                parent.children.add(node);
                parseInput(input, node);
            }
            else if (c == ')')
            {
                return;
            }
            else if (c == '-')
            {
                node.v =  Integer.parseInt(input.substring(index-1, index+1));
                parent.children.add(node);
                index++;
            }
            else
            {
                node.v =  Character.getNumericValue(c);
                parent.children.add(node);
            }
        }
        return;
    }
    
    public static <E> void printVector(Vector<E> inputArray)
    {
        for (int i = 0; i < inputArray.size(); i++)
            System.out.print(inputArray.get(i));
        System.out.println("");
    }
    
    // public static void printTree(Node node)
    // {
    //     System.out.println(node.v);
    //     int i = 0;
    //     while(i < node.children.size())
    //     {
    //         printTree(node.children.get(i));
    //         i++;
    //     }
    // }
}

