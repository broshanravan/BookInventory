package com.books.inventory.controllers;


import com.books.inventory.beans.Book;
import com.books.inventory.data.BooksData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.books.inventory.beans.Author;

import java.util.List;

@RestController
public class BookInventoryController {

    @Autowired
    BooksData booksInventory;

    @GetMapping("/books/{startingIndex}/{limit}")
    public List<Book> getBooks(@PathVariable int startingIndex, @PathVariable int limit) {
        List<Book> booksList = booksInventory.getLimitedNumberOfBooks(startingIndex, limit);
        return booksList;
    }

    @GetMapping("/authors/{startingIndex}/{limit}")
    public List<Author> getAuthers(@PathVariable int startingIndex, @PathVariable int limit) {
        List<Author> authorsList = booksInventory.getLimitedNumberOfAuthor(startingIndex, limit);

        return authorsList;
    }

    @GetMapping("/author/books/{startingIndex}/{authorId}/{limit}")
    public List<Book> getLimitedNumberOfBooksByAuthor(@PathVariable int authorId, @PathVariable int limit, int startingIndex) {
        List<Book> booksList = booksInventory.getLimitedNumberOfBooksByAuthor(startingIndex, authorId, limit);


        return booksList;
    }

    @PostMapping("/books/Remove/{userId}/{authorId}")
    public void deteteBookByAuthor(@RequestBody int userId, @RequestBody int  authorId) {

    }
}


