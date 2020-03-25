package com.cursor.hw18.service;

import com.cursor.hw18.model.Book;

import java.util.List;

public interface AuthorService {
    void addData(String firstName, String lastName, List<Book> books);
}
