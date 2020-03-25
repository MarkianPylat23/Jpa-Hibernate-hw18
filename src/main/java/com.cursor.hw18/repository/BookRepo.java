package com.cursor.hw18.repository;

import com.cursor.hw18.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query(value = "SELECT books.*, authors.first_name, authors.last_name FROM authors INNER JOIN books ON books.author_id = authors.author_id\n" +
            "WHERE books.id=:books.id", nativeQuery = true)
    Book findBookById(@Param("books.id") Long bookId);

    @Query(value = "SELECT books.id, books.title, authors.first_name, authors.last_name FROM authors INNER JOIN books ON books.author_id = authors.author_id WHERE books.genre=:books.genre", nativeQuery = true)
    List<String> findBooksByGenre(@Param("books.genre") String genre);

    @Query(value = "SELECT books.id, books.title, authors.first_name, authors.last_name FROM authors INNER JOIN books ON books.author_id = authors.author_id WHERE authors.last_name=:authors.last_name", nativeQuery = true)
    List<String> findBooksByAuthor(@Param("authors.last_name") String authorsLastName);

    @Query(value = "SELECT books.id, books.title, authors.first_name, authors.last_name FROM authors INNER JOIN books ON books.author_id = authors.author_id", nativeQuery = true)
    List<String> showAllBooks();
}