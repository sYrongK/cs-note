package com.javanote.cs.tree;
/*
Integer Binary Tree 예시
 */
public class BinaryTree {

    //  root of Binary Tree
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int key) {
        this.root = new Node(key);
    }

    public static void main(String[] args) {
        //  empty tree 생성. root는 null이다.
        BinaryTree tree = new BinaryTree();
        
        /*
        root에 value 넣기

            1
          /   \
        null null
        */
        tree.root = new Node(1);

        /*
        root의 left, right child 채우기

                 1
              /    \
            2        3
          /   \    /   \
        null null null null
         */
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        
        /*
        root의 left child에 left,right child 추가

                         1
                      /    \
                    2        3
                  /   \    /   \
                 4   null null null
               /  \
            null null
         */
        tree.root.left.left = new Node(4);

    }
}
