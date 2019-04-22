package com.epam.deque.controller;

import com.epam.deque.models.MyDeque;

public class Controller<T> {
    private MyDeque<T> myDeque = new MyDeque<T>();

    public void printDeque() {
        myDeque.printDeque();
    }

    public void addFirstElement(T type) {
        myDeque.addAtFirst(type);
        myDeque.printDeque();
    }

    public void addLastElement(T type) {
        myDeque.addAtEnd(type);
        myDeque.printDeque();
    }

    public void removeFirstElement() {
        myDeque.removeFromStart();
        myDeque.printDeque();
    }

    public void removeLastElement() {
        myDeque.removeFromLast();
        myDeque.printDeque();
    }

    public void dequeSize() {
        myDeque.size();
    }

}
