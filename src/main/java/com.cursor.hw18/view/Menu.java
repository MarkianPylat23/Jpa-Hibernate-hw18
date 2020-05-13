package com.cursor.hw18.view;

public abstract class Menu {
    protected abstract void showMenu();

    protected void takeStepBack() {
    }

    protected void exit() {
        System.err.println("Thank you for visiting our library!");
        System.exit(0);
    }

    protected void showItems(String[] items) {
        for (String item : items) {
            System.out.println("===========================");
            System.out.println(item);
        }
    }
}
