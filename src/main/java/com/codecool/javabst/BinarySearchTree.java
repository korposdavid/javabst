package com.codecool.javabst;

import java.util.List;

// Skeleton for the Binary search tree. Feel free to modify this class.
public class BinarySearchTree {
    private BinaryTreeNode root;

    public static BinarySearchTree build(List<Integer> elements) {
        BinarySearchTree result = new BinarySearchTree();
        for (Integer element :
                elements) {
            result.add(element);
        }
        return result;
    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public boolean search(Integer toFind) {
        try {
            searchNodeByValue(toFind);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public BinaryTreeNode searchNodeByValue(Integer toFind) throws Exception {
        BinaryTreeNode actualNode = this.getRoot();
        while (!actualNode.getData().equals(toFind)) {
            if (!actualNode.hasChildren()) {
                throw new Exception("Value not found");
            }
            if (actualNode.getData() > toFind) {
                actualNode = actualNode.getLeftChild();
            } else {
                actualNode = actualNode.getRightChild();
            }
        }
        return actualNode;
    }


    public void add(Integer toAdd) {
        try {
            BinaryTreeNode actualNode = this.getRoot();
            BinaryTreeNode nodeToAdd = new BinaryTreeNode(toAdd);
            boolean nodeAdded = false;
            if (actualNode == null) {
                this.setRoot(nodeToAdd);
            } else {
                while (!nodeAdded) {
                    if (actualNode.getData() > toAdd) {
                        //go left
                        if (actualNode.getLeftChild() == null) {
                            actualNode.setLeftChild(nodeToAdd);
                            nodeAdded = true;
                        } else {
                            actualNode = actualNode.getLeftChild();
                        }
                    } else if (actualNode.getData() < toAdd) {
                        //go right
                        if (actualNode.getRightChild() == null) {
                            actualNode.setRightChild(nodeToAdd);
                            nodeAdded = true;
                        } else {
                            actualNode = actualNode.getRightChild();
                        }
                    } else {
                        throw new Exception("The value is already in the tree.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(Integer toRemove) {
        // TODO removes an element. Throws an error if its not on the tree.
        try {
            BinaryTreeNode nodeToRemove = this.searchNodeByValue(toRemove);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
