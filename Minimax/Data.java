
// used to store the data in a node. The data contains a value and a vector that records the pathes

import java.util.Vector;

public class Data 
{
    public Integer v; // value
    public Vector<Integer> pathes; // stores the pathes to the root
    public Data(Integer value)
    {
        v = value;
        pathes = new Vector<Integer>();
    }
}