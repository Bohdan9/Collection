package com.epam.tree.models;

import org.apache.log4j.Logger;

public class BinaryTree<K, V> {
    private final static Logger logger = Logger.getLogger(String.valueOf(BinaryTree.class));
    private Node root;

    public void insertIntoMap(K key, V value) {
        if (root == null) {
            this.root = new Node(key, value);
        } else {
            insertNode(this.root, key, value);
        }
    }

    private Node insertNode(Node node, K key, V value) {
        if (node == null) {
            node = new Node(key, value);
        } else {
            if (key.toString().compareTo(node.getKey().toString()) < 0) {
                node.setLeft(insertNode(node.getLeft(), key, value));
            } else if (key.toString().compareTo(node.getKey().toString()) > 0) {
                node.setRight(insertNode(node.getRight(), key, value));
            } else {
                node = insertNode(node, key, value);
            }
        }
        return node;
    }

    public void removeByKey(K key) {
        removeNode(this.root, key);
    }

    private Node removeNode(Node root, K key) {

        if (root == null) {
            return root;
        }
        if (key.toString().compareTo(root.getKey().toString()) < 0) {
            root.setLeft(removeNode(root.getLeft(), key));
        } else if (key.toString().compareTo(root.getKey().toString()) > 0) {
            root.setRight(removeNode(root.getRight(), key));
        } else {
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            } else if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            } else {
                K minKey = minKey(root.getRight());
                root.setKey(minKey);
                root.setRight(removeNode(root.getRight(), minKey));
            }
        }
        return root;
    }

    private K minKey(Node node) {
        if (node.getLeft() != null) {
            return minKey(node.getLeft());
        }
        return (K) node.getKey();
    }

    private Node search(Node node, K key) {
        if (node == null || node.getKey() == key) {
            return node;
        }
        if (key.toString().compareTo(node.getKey().toString()) < 0) {
            return search(node.getLeft(), key);
        } else {
            return search(node.getRight(), key);
        }
    }

    public void searchByKey(K key) {
        search(root, key);
    }

    private void print(Node t) {
        if (t != null) {
            print(t.getLeft());
            logger.info(t.getKey() + ":" + t.getValue() + " ");
            print(t.getRight());
        }
    }

    public void printMap() {
        print(root);
    }

}

