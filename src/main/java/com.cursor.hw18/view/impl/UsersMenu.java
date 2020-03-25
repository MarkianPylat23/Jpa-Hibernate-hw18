package com.cursor.hw18.view.impl;

import com.cursor.hw18.controller.UserController;
import com.cursor.hw18.model.User;
import com.cursor.hw18.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class UsersMenu extends Menu {

    @Autowired
    UserController userController;

    @Autowired
    LibraryMenu libraryMenu;

    private Scanner scanner = new Scanner(System.in);
    private String[] items = {"Press 0 to exit"};

    @Override
    protected void showMenu() {
        List<User> users = userController.showAllUsers();
        int option = scanner.nextInt();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + 1 + ". " + users.get(i));
        }
        showItems(items);

        if (option <= users.size() && option != 0) {
            System.err.println("You are logged as - " + users.get(option - 1));
            libraryMenu.showMenu();
        } else if (option == 0) {
            exit();
        } else {
            System.err.println("======================\nError.Please try again.\n======================");
            showMenu();
        }
    }
}
