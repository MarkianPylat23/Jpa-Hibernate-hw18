package com.cursor.hw18.model;


import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;

@Data

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long bookId;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "genre")
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }
}
