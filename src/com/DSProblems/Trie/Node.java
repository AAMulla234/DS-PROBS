package com.DSProblems.Trie;

public class Node implements Comparable
{
    String key;
    int count;
 
    // constructor
    Node(String key, int count)
    {
        this.key = key;
        this.count = count;
    }
 
    @Override
    public int compareTo(Object o)
    {
        Node node = (Node)o;
        return count - node.count;
    }
}