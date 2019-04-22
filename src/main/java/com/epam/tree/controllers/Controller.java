package com.epam.tree.controllers;

import com.epam.tree.models.BinaryTree;

public class Controller<K, V> {
    private BinaryTree<K, V> binaryTree = new BinaryTree<>();

    public void printMap() {
        binaryTree.printMap();
    }

    public void fillInBinaryTree(K key, V value) {
        binaryTree.insertIntoMap(key, value);
    }

    public void searchInBinaryTree(K key) {
        binaryTree.searchByKey(key);
    }

    public void removeByKey(K key) {
        binaryTree.removeByKey(key);
    }
}
