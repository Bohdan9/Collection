package com.epam.tree.view;

import com.epam.tree.controllers.Controller;
import com.epam.tree.models.constant.Constant;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final static org.apache.log4j.Logger logger = Logger.getLogger(View.class);
    private Controller<Object, Object> controller;
    private Map<String, String> menu;
    private Map<String, Printable> methodMenu;
    private Scanner scanner;

    public View() {
        controller = new Controller<>();
        scanner = new Scanner(System.in);
        menu = new LinkedHashMap<>();
        menu.put("1", Constant.FIRST_ITEM);
        menu.put("2", Constant.SECOND_ITEM);
        menu.put("3", Constant.THIRD_ITEM);
        menu.put("4", Constant.FORTH_ITEM);
        menu.put("Q", Constant.EXIT);
        methodMenu = new LinkedHashMap<>();
        methodMenu.put("1", this::insertIntoBinaryTree);
        methodMenu.put("2", this::searchByKey);
        methodMenu.put("3", this::removeElement);
        methodMenu.put("4", this::printMap);
    }

    private void insertIntoBinaryTree() {
        logger.info(("\nInsert key :"));
        String key = scanner.next();
        logger.info(("\nInsert value :"));
        String value = scanner.next();
        controller.fillInBinaryTree(key, value);
        controller.printMap();

    }

    private void removeElement() {
        System.out.println(("Set element key :"));
        String key = scanner.next();
        controller.removeByKey(key);
        controller.printMap();
    }

    private void searchByKey() {
        logger.info(("Set element key :"));
        String key = scanner.next();
        controller.searchInBinaryTree(key);
    }

    private void printMap() {
        controller.printMap();
    }

    public void show() {
        String keyMenu;
        while (true) {
            logger.info(("\nPlease, select menu point:\n"));
            for (String value : menu.values()) {
                System.out.println(value);
            }
            keyMenu = scanner.nextLine().toUpperCase();
            try {
                methodMenu.get(keyMenu).print();
            } catch (Exception e) {
                logger.error(e.getStackTrace());
            }
        }
    }
}