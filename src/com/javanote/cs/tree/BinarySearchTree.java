package com.javanote.cs.tree;
/*
이진 검색 트리 예시
 */
public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        /*
        아래와 같은 이진 탐색 트리 생성
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80
         */
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20 ! - leaf node");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30 ! - 자식 노드 하나");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50 ! - 자식 노드 둘");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }

    //  이진검색트리 : search
    public Node search(Node root, int key) {
        
        //  tree가 비어있거나, 찾는 값이 root와 같은 경우
        if (key == root.key || root == null) {
            return root;
        }

        //  찾는 값이 root보다 클 경우 오른쪽 하위 트리에서 재검색
        if (key > root.key) {
            return search(root.right, key);
        }

        //  찾는 값이 root보다 작을 경우 왼쪽 하위 트리에서 재검색
        if (key < root.key) {
            return search(root.left, key);
        }

        return null;
    }

    //  이진검색트리 : insertion
    public void insert(int key) {
        root = insertRec(root, key);
    }

    //  이진검색트리 insertion용 재귀함수
    public Node insertRec(Node root, int key) {

        //  tree가 비어있는 경우
        if (root == null) {
            root = new Node(key);
        }

        //  넣으려는 값이 root보다 작을 경우
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        
        // 넣으려는 값이 root보다 클 경우    
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        
        return root;
    }

    //  이진검색트리 : delete
    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    public Node deleteRec(Node root, int key) {
          /*
          key : 삭제하려는 값
          root : root에서부터 left 혹은 right 노드로 순차적으로 tree를 따라가
                삭제하려는 값을 key로 가진 노드를 발견할 때까지
          */

        //  node가 비어있는 경우
        if (root == null) {
            return root;
        }
        //  삭제하려는 값이 root보다 작은 경우
        if (key < root.key) {
            //  root를 왼쪽 하위 노드로 이동
            root.left = deleteRec(root.left, key);
        
        //  삭제하려는 값이 root보다 큰 경우    
        } else if (key > root.key) {
            //  root를 오른쪽 하위 노드로 이동
            root.right = deleteRec(root.right, key);

        //  삭제하려는 값이 root와 같은 경우 (마지막 재귀)
        } else {
            //  삭제하려는 값의 자식 노드 존재여부 확인!

            //  1. 자식 노드가 하나만 있거나 없는 경우
            //  삭제하려는 값이 right node만 가졌거나 자식 둘다 null인 경우
            //  root node를 right node 혹은 null로 대체
            if (root.left == null) {
                return root.right;

            //  삭제하려는 값이 left node만 가진 경우
            //  root node를 left node로 대체
            } else if (root.right == null) {
                return root.left;
            }
            
            //  2. 자식 노드 두 개 다 있는 경우
            //  오름차순에서 후속 노드 복사 root에 복사
            //  여기서의 root는 타고타고 내려온 노드잖아
            //  key만 바뀐거지 left right는 그대로
            root.key = getSuccessor(root.right);
            
            //  복사해온 후속 노드 삭제
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }
    
    //  후속 노드 successor node 구하기
    public int getSuccessor(Node root) {
        int successor = root.key;
        //  현재 root의 key보다 더 작은 값이 없을 때까지
        while (root.left != null) {
            successor = root.left.key;
            root = root.left;
        }
        return successor;
    }
    
    //  선행 노드 predecessor node 구하기

    //  Binary Search Tree 중위순회로 출력
    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {

        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
}
