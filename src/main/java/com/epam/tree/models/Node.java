package com.epam.tree.models;

public class Node<K, V> implements Comparable {
    private K key;
    private V value;
    private Node left;
    private Node right;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    Node getLeft() {
        return left;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    Node getRight() {
        return right;
    }

    void setRight(Node right) {
        this.right = right;
    }

    K getKey() {
        return key;
    }

    void setKey(K key) {
        this.key = key;
    }

    V getValue() {
        return value;
    }

    @Override
    public int compareTo(Object o) {
        return this.key.toString().compareTo(o.toString());
    }

    @Override
    public String toString() {
        return "Key: " + getKey() + "\tValue: " + getValue();
    }
}