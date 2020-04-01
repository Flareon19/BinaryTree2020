/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: dbc2201
 *   Date: 27/02/20
 *   Time: 8:33 AM
 */

package definition;

import adt.BinaryTreeADT;

public class BinaryTree<E> implements BinaryTreeADT<E> {

    int countRight = 0;
    private Node<E> root;
    private int numberOfNodes = 0;

    @Override
    public boolean add(E data) {
        root = addRecursive(root, data);
        numberOfNodes++;
        return true;
    }

    private Node<E> addRecursive(Node<E> currentNode, E data) {
        if (currentNode == null) {
            return new Node<>(data);
        }
        if ((Integer)data < (Integer)currentNode.getData()) {
            currentNode.leftChild = addRecursive(currentNode.getLeftChild(), data);
        } else if ((Integer)data > (Integer)currentNode.getData()) {
            currentNode.rightChild = addRecursive(currentNode.getRightChild(), data);
        }
        return currentNode;
    }

    public Node<E> remove(E data) {
        root = deleteRecursive(root, data);
        return root;
    }


    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return numberOfNodes;
    }

    private Node<E> deleteRecursive(Node<E> currentNode, E data) {
        if (currentNode == null) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = currentNode;
        if (currentNode.getData().equals(data)) {
            if (currentNode.getLeftChild() == null && currentNode.rightChild == null)
                return temp;
            else {

            }
        }
        if ((Integer)data < (Integer)currentNode.getData())
            containsNodeRecursive(currentNode.getLeftChild(), data);
        else if ((Integer)data > (Integer)currentNode.getData())
            containsNodeRecursive(currentNode.getRightChild(), data);
        return null;
    }

    public boolean containsNodeRecursive(Node<E> curentNode, E data) {
        if (curentNode == null)
            return false;
        if (curentNode.getData().equals(data))
            return true;
        return (Integer)data < (Integer)curentNode.getData() ?
                containsNodeRecursive(curentNode.getLeftChild(), data) : containsNodeRecursive(curentNode.getRightChild(), data);
    }

    private void traversePreOrder(Node<E> currentNode) {
        if (currentNode != null) {
            visit(currentNode.getData());
            traversePreOrder(currentNode.getLeftChild());
            traversePreOrder(currentNode.getRightChild());
        }
    }

    private void traverseInOrder(Node<E> currentNode) {
        if (currentNode != null) {
            traverseInOrder(currentNode.getLeftChild());
            visit(currentNode.getData());
            traverseInOrder(currentNode.getRightChild());
        }
    }

    private void traversePostOrder(Node<E> currentNode) {
        if (currentNode != null) {
            traversePostOrder(currentNode.getLeftChild());
            traversePostOrder(currentNode.getRightChild());
            visit(currentNode.getData());
        }
    }

    private void visit(E data) {
        System.out.print(data+" ");
    }

    public void print() {
        traverseInOrder(root);
    }

    private static class Node<E> {
        private E data;
        private Node<E> leftChild;
        private Node<E> rightChild;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<E> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<E> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<E> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
