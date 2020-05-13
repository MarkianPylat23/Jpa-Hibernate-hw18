package com.cursor.hw18.service.impl;

import com.cursor.hw18.model.Author;
import com.cursor.hw18.model.Book;
import com.cursor.hw18.repository.AuthorRepo;
import com.cursor.hw18.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepo authorRepository;

    @Override
    public void addData(String firstName, String lastName, List<Book> books) {
        authorRepository.save(new Author(firstName, lastName, books));
    }
}
