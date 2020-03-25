package com.cursor.hw18.view.impl;

import com.cursor.hw18.controller.UserController;
import com.cursor.hw18.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class MainMenu extends Menu {

    @Autowired
    UserController userController;

    @Autowired
    UsersMenu usersMenu;

    private Scanner scanner = new Scanner(System.in);

    private String[] items = {"Press 1 to select user", "Press 0 to exit"};

    @Override
    @Autowired
    protected void showMenu() {
        showItems(items);

        String option = scanner.next();

        switch (option) {
            case "1":
                System.err.println("We haven't such user. Please try again.");
                usersMenu.showMenu();
                break;
            case "0":
                exit();
                break;
            default:
                System.err.println("Wrong option. Please try again.");
                showMenu();
        }
    }
}
