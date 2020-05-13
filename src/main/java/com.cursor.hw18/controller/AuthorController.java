package com.cursor.hw18.controller;

import com.cursor.hw18.model.Book;
import com.cursor.hw18.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorThings;

    @Autowired
    public void addData() {
        authorThings.addData("Henry", "Ford", List.of(new Book("Henry Ford Autobiography", "Biography")));
        authorThings.addData("Kris", "Gilbo", List.of(new Book("StartUp for 100$", "Science")));
    }
}
