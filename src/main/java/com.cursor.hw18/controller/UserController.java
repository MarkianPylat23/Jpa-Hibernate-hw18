package com.cursor.hw18.controller;

import com.cursor.hw18.model.Book;
import com.cursor.hw18.model.User;
import com.cursor.hw18.service.impl.AuthorServiceImpl;
import com.cursor.hw18.service.impl.BookServiceImpl;
import com.cursor.hw18.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    AuthorServiceImpl authorService;

    @Autowired
    public void addUsersToDb() {
        userService.addUsers("Yuriy", "Danylov", "jura");
        userService.addUsers("Misha", "Borsyk", "badger");
        userService.addUsers("Roma","Liush","JS");
        userService.addUsers("Sviatoslav", "Hrynyk", "mr.Ubunta");
        userService.addUsers("Oleksiy", "Shah", "zvukach");
        userService.addUsers("Markian", "Pylat", "marek");
    }

    public Book findBookById(Long id) {
        return bookService.findBookById(id);
    }

    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    public void findBooksByGenre(String genre) {
        bookService.findBooksByGenre(genre);
    }

    public void findBooksByAuthor(String authorsLastName) {
        bookService.findBooksByAuthor(authorsLastName);
    }

    public void showAllBooks() {
        bookService.showAllBook();
    }

    public void addBookToLibrary(String authorFirstName, String authorLastName, String bookTitle, String bookGenre) {
        authorService.addData(authorFirstName, authorLastName, List.of(new Book(bookTitle, bookGenre)));
    }
}
