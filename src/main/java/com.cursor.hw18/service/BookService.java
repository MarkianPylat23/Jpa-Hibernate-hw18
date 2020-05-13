package com.cursor.hw18.service;

import com.cursor.hw18.model.Book;

public interface BookService {
    Book findBookById(Long bookId);

    void findBooksByGenre(String genre);

    void findBooksByAuthor(String authorsLastName);

    void showAllBook();
}
