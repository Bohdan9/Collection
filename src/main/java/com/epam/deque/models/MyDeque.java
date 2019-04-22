package com.epam.deque.models;

import com.epam.deque.models.constant.Constant;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyDeque<Item> implements Iterable<Item> {
    private final static Logger logger = Logger.getLogger(String.valueOf(MyDeque.class));
    private Item[] deck;
    private int itemNumber;
    private int frontIndex;
    private int backIndex;

    public MyDeque() {
        deck = (Item[]) new Object[2];
        itemNumber = 0;
        frontIndex = 0;
        backIndex = deck.length - Constant.ONE;
    }

    private boolean isEmpty() {
        return itemNumber == 0;
    }

    public void size() {
        logger.info(itemNumber);
    }

    public void addAtFirst(Item item) {
        if (itemNumber == deck.length) {
            resize(2 * deck.length);
        }
        deck[frontIndex--] = item;
        if (frontIndex == 0) {
            frontIndex = deck.length - Constant.ONE;
        }
        itemNumber++;
    }

    public void addAtEnd(Item item) {
        if (itemNumber == deck.length) {
            resize(2 * deck.length);
        }
        deck[backIndex++] = item;
        if (backIndex == deck.length) {
            backIndex = 0;
        }
        itemNumber++;
    }

    public void removeFromStart() {
        if (isEmpty()) throw new NoSuchElementException("Deck is already empty!");
        if (frontIndex == backIndex - Constant.ONE) {
            frontIndex = -1;
        }
        Item item = deck[++frontIndex];
        deck[frontIndex] = null;
        itemNumber--;
        if (itemNumber > 0 && itemNumber == deck.length / Constant.FOUR) {
            resize(deck.length / Constant.TWO);
        }
    }

    public Item removeFromLast() {
        if (isEmpty()) throw new NoSuchElementException("Deck is already empty!");
        if (backIndex == 0) {
            backIndex = deck.length;
        }
        Item item = deck[--backIndex];
        deck[backIndex] = null;
        itemNumber--;
        if (itemNumber > 0 && itemNumber == deck.length / Constant.FOUR) {
            resize(deck.length / Constant.TWO);
        }
        return item;
    }

    private void resize(int size) {
        Item[] newDeck = (Item[]) new Object[size];
        for (int i = 0; i < itemNumber; i++) {
            newDeck[i] = deck[(frontIndex + 1 + i) % deck.length];
        }
        deck = newDeck;
        frontIndex = deck.length - Constant.ONE;
        backIndex = itemNumber;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    public void printDeque() {
        for (Item aDeck : deck) {
            logger.info(aDeck);
        }
    }

    private class ArrayIterator implements Iterator<Item> {

        private int current = 0;

        public boolean hasNext() {
            return current < itemNumber;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = deck[(frontIndex + Constant.ONE + current) % deck.length];
            current++;
            return item;
        }
    }
}

