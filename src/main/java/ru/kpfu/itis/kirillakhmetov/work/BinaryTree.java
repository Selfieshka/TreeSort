package ru.kpfu.itis.kirillakhmetov.work;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;
    private int size = 0;
    private int numberIterations = 0;
    private List<Integer> sortedElemTree;


    public void add(Integer elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        Node newNode = new Node(elem);
        if (root == null) {
            this.root = newNode;
            numberIterations++;
        } else {
            Node current = root;
            boolean flag = true;

            while (flag) {
                numberIterations++;
                if (newNode.getValue() < current.getValue()) {
                    if (current.getLeft() != null) {
                        current = current.getLeft();
                    } else {
                        current.setLeft(newNode);
                        flag = false;
                    }
                } else if (newNode.getValue() > current.getValue()) {
                    if (current.getRight() != null) {
                        current = current.getRight();
                    } else {
                        current.setRight(newNode);
                        flag = false;
                    }
                } else {
                    throw new DuplicateElementException();
                }
            }
        }
        size++;
    }

    public List<Integer> sort() {
        if (root != null) {
            sortedElemTree = new ArrayList<>();
            Node newRoot = root;
            inOrder(newRoot);
            return sortedElemTree;
        } else {
            throw new EmptyTreeException();
        }
    }

    private void inOrder(Node node) {
        numberIterations++;
        if (node.getLeft() != null) {
            inOrder(node.getLeft());
        }
        sortedElemTree.add(node.getValue());
        if (node.getRight() != null) {
            inOrder(node.getRight());
        }
    }

    public int getSize() {
        return size;
    }

    public int getNumberIterations() {
        return numberIterations;
    }
}