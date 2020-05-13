package com.cursor.hw18.view.impl;

import com.cursor.hw18.controller.UserController;
import com.cursor.hw18.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class LibraryMenu extends Menu {

    @Autowired
    UserController userController;

    @Autowired
    UsersMenu usersMenu;

    private Scanner scanner = new Scanner(System.in);

    private String[] exitItems = {"Press 9 to go back", "Press 0 to exit"};
    private String[] items = {"1.Search book by genre", "2.Search book by author", "3.Show all books", "4.Add book to library", "9.Back", "0.Exit"};

    @Override
    protected void showMenu() {
        showItems(items);
        String option = scanner.next();

        switch (option) {
            case "1":
                findByGenre();
                break;
            case "2":
                findByAuthor();
                break;
            case "3":
                showAllBooks();
                break;
            case "4":
                addBookToLibrary();
                break;
            case "9":
                takeStepBack();
                break;
            case "0":
                exit();
            default:
                System.err.println("Wrong option. Please try again.");
                showMenu();
        }
    }

    private void addBookToLibrary() {
        System.out.println("Enter author first name: ");
        String firstName = scanner.next().toLowerCase();

        System.out.println("Enter author last name: ");
        String lastName = scanner.next().toLowerCase();

        System.out.println("Enter book title: ");
        String title = scanner.next().toLowerCase();

        System.out.println("Enter book genre: ");
        String genre = scanner.next().toLowerCase();

        userController.addBookToLibrary(capitalizeFirstLetter(firstName), capitalizeFirstLetter(lastName), capitalizeFirstLetter(title), capitalizeFirstLetter(genre));

        System.err.println("You added new book. Here's tips. Thanks.");

        showItems(exitItems);
        showExitMenu();
    }

    private void showAllBooks() {
        userController.showAllBooks();
        showItems(exitItems);
        showExitMenu();
    }


    private void findByGenre() {
        System.out.println("Enter genre: ");

        String option = scanner.next().toLowerCase();

        switch (option) {
            case "science":
            case "biography":

                userController.findBooksByGenre(capitalizeFirstLetter(option));
                showItems(exitItems);
                showExitMenu();
        }
    }

    private void findByAuthor() {
        System.out.println("Enter author last name:");

        String option = scanner.next().toLowerCase();

        switch (option) {
            case "ford":
            case "gilbo":

                userController.findBooksByAuthor(capitalizeFirstLetter(option));
                showItems(exitItems);
                showExitMenu();
        }
    }

    private void showExitMenu() {
        String option = scanner.next();

        switch (option) {
            case "9":
                showMenu();
                break;
            case "0":
                exit();
            default:

                System.err.println("Wrong choice. Please try again.");
                showExitMenu();
        }
    }

    @Override
    protected void takeStepBack() {
        usersMenu.showMenu();
    }

    private String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
