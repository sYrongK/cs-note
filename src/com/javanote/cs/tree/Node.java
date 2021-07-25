package com.javanote.cs.tree;

/*
Integer data의 tree node 예시
 */
public class Node {

    public int key;
    public Node left, right;

    public Node(int item) {
        this.key = item;
        this.left = right = null;
    }
}
