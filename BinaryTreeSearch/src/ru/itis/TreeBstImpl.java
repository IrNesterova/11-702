package ru.itis;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBstImpl<T extends Comparable<T>> implements Tree<T> {

    class Node {
        private T value;
        private Node left;
        private Node right;

        Node(T value) {
            this.value = value;
        }

        Node() {

        }

    }

    private Node root;

    public TreeBstImpl() {
        this.root = null;
    }

    @Override
    public void insert(T value) {
        this.root = insert(root, value);
    }

    private Node insert(Node root, T value) {
        if (root == null) {
            root = new Node(value);
        } else if (value.compareTo(root.value) <= 0) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    @Override
    public boolean remove(T value) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.value != value) {
            parent = current;
            if (current.value.compareTo(value) > 0) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right != null) {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleleNode) {
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }

        if (successsor != deleleNode.right) {
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    @Override
    public void print() {
        print(root);
    }

    private void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.value + " ");
            print(root.right);
        }
    }

    @Override
    public boolean contains(T value) {
        Node found = contains(root, value);
        if (found == null) {
            return false;
        } else {
            return true;
        }
    }

    private Node contains(Node root, T value) {
        if (root == null) {
            return null;
        }
        int comp = root.value.compareTo(value);
        if (comp > 0) {
            return contains(root.left, value);
        } else if (comp < 0) {
            return contains(root.right, value);
        } else {
            return root;
        }
    }

    @Override
    public void printByLevels() {
        printLevels();
    }

    private void printLevels(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currentLevelCount = 1;
        int nextLevelCount = 0;
        while (!queue.isEmpty()){
            Node n = queue.remove();
            System.out.print(n.value + " ");
            if (n.left!=null){
                queue.add(n.left);
                nextLevelCount++;
            }
            if (n.right!=null){
                queue.add(n.right);
                nextLevelCount++;
            }
            currentLevelCount--;
            if (currentLevelCount==0){
                System.out.println("");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }
    }

    @Override
    public boolean isBst() {
        return isBinarySearchTree(root, root.left.value, root.right.value);
    }


    public boolean isBinarySearchTree(Node node, T min, T max) {
        if (node == null){
            return true;
        } else if (node.value.compareTo(min) < 0 || node.value.compareTo(max) > 0 ){
            return false;
        } else {
            return isBinarySearchTree(node.left, min, node.value) && isBinarySearchTree(node.right, node.value, max);
        }
    }



    public boolean isEmpty(){
        if (root == null){
            return true;
        } else {
            return false;
        }

    }
}
