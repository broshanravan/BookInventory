package com.books.inventory.controllers;


import com.books.inventory.beans.Book;
import com.books.inventory.beans.User;
import com.books.inventory.data.BooksData;
import com.books.inventory.data.Personnel;
import com.books.inventory.enums.UserRole;
import com.books.inventory.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.books.inventory.beans.Author;


import java.util.List;

@RestController
public class BookInventoryController {

    @Autowired
    BooksData booksInventory;

    @Autowired
    Personnel personnel;

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

    @DeleteMapping("/books/remove/{userId}/{authorId}")
    public void deteteBookByAuthor(@PathVariable int userId, @PathVariable int  authorId) {
        User user = personnel.getUser(userId);
        if(user.getUserRole() != UserRole.Admin){
            throw new ForbiddenException("User in not an Administrator");

        }else if(booksInventory.authorHasBooksAssosiated(authorId)){
            throw new ForbiddenException("Author has books associated to it in the Database");
        } else{
            booksInventory.removeAuthor(authorId);
        }

    }
}


