package com.cursor.hw18.service.impl;

import com.cursor.hw18.model.Book;
import com.cursor.hw18.repository.BookRepo;
import com.cursor.hw18.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepository;

    @Override
    public Book findBookById(Long bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Override
    public void findBooksByGenre(String genre) {
        List<String> booksByGenre = bookRepository.findBooksByGenre(genre);

        System.err.println("There are the books of genre " + genre + ":\n");

        for (int i = 0; i < booksByGenre.size(); i++) {
            System.out.println(booksByGenre.get(i));
            if (booksByGenre.size() % 4 == 0) {
                System.out.println("\n");
            }
        }
    }

    @Override
    public void findBooksByAuthor(String authorsLastName) {
        List<String> booksByAuthorsLastName = bookRepository.findBooksByAuthor(authorsLastName);

        System.err.println("There are the books of the author - " + authorsLastName + ":");

        for (int i = 0; i < booksByAuthorsLastName.size(); i++) {
            System.out.println(booksByAuthorsLastName.get(i));
            if (booksByAuthorsLastName.size() % 4 == 0) {
                System.out.println("\n");
            }
        }
    }

    @Override
    public void showAllBook() {
        List<String> allBooks = bookRepository.showAllBooks();

        System.err.println("There are all of our books: ");

        for (int i = 0; i < allBooks.size(); i++) {
            System.out.println(allBooks.get(i));
            if (allBooks.size() % 4 == 0) {
                System.out.println("\n");
            }
        }
    }
}
