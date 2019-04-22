package com.epam.deque.view;

import com.epam.deque.controller.Controller;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class View {
    final static Logger logger = Logger.getLogger(String.valueOf(com.epam.tree.view.View.class));
    private Controller<String> controller;

    public View() {
        controller = new Controller<>();
    }

    private static void displayChoiceList() {
        for (Command c : Command.values())
            System.out.println(c.ordinal() + ") " + c.message());
    }

    public void printMenu() {
        outerLoop:
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                while (true) {
                    logger.info("_______MENU_______" + "\nDeque" + "\n Enter choice: ");
                    logger.info("Enter your choice:");
                    displayChoiceList();
                    int choice = scanner.nextInt();
                    if (choice == Command.ADD_FIRST_ELEMENT.ordinal()) {
                        logger.info("Add first");
                        controller.addFirstElement(scanner.next());
                    } else if (choice == Command.ADD_LAST_ELEMENT.ordinal()) {
                        logger.info("Add last");
                        controller.addLastElement(scanner.next());
                    } else if (choice == Command.DELETE_FIRST_ELEMENT.ordinal()) {
                        logger.info("Delete first");
                        controller.removeFirstElement();
                    } else if (choice == Command.DELETE_LAST_ELEMENT.ordinal()) {
                        controller.removeLastElement();
                    } else if (choice == Command.SHOW_SIZE.ordinal()) {
                        controller.dequeSize();
                    } else if (choice == Command.SHOW_DEQUE.ordinal()) {
                        controller.printDeque();
                    } else if (choice == Command.EXIT.ordinal())
                        break outerLoop;
                    else
                        logger.error("Invalid command number entered!");
                }
            } catch (Exception e) {
                logger.error("\nTRY AGAIN!!!");
            }
        }
    }
}
