package com.codecool.javabst;

import java.util.List;

public class BinaryTreeNode {
    public Integer data;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;

    public BinaryTreeNode(Integer data) {
        this.data = data;
    }

    public boolean hasChildren() {
        return leftChild != null || rightChild != null;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public Integer getData() {
        return data;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void buildChildren(List<Integer> elements, int rootIndex, int firstIndex, int lastIndex) {
        if(firstIndex<rootIndex) {
            int newLeftIndex = (firstIndex+rootIndex)/2;
            BinaryTreeNode newLeftNode = new BinaryTreeNode(elements.get(newLeftIndex));
            this.setLeftChild(newLeftNode);
            newLeftNode.buildChildren(elements, newLeftIndex, firstIndex, rootIndex-1);
        }
        if (lastIndex > rootIndex) {
            int newRightIndex = (lastIndex+rootIndex)/2+1;
            BinaryTreeNode newRightNode = new BinaryTreeNode(elements.get(newRightIndex));
            this.setRightChild(newRightNode);
            newRightNode.buildChildren(elements, newRightIndex, rootIndex+1, lastIndex);
        }
    }
}
