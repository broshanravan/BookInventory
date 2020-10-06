package com.books.inventory.controllers;

import com.books.inventory.beans.Book;
import com.books.inventory.beans.User;
import com.books.inventory.data.BooksData;
import com.books.inventory.data.Personnel;
import com.books.inventory.enums.UserRole;
import com.books.inventory.exceptions.ForbiddenException;
import com.books.inventory.exceptions.ResourceNotFoundException;
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

    @GetMapping("/books/{pageNumber}/{limit}")
    public List<Book> getBooks(@PathVariable int pageNumber, @PathVariable int limit) {
        List<Book> booksList = booksInventory.getLimitedNumberOfBooks(pageNumber, limit);
        return booksList;
    }

    @GetMapping("/authors/{pageNumber}/{limit}")
    public List<Author> getAuthers(@PathVariable int pageNumber, @PathVariable int limit) {
        List<Author> authorsList = booksInventory.getLimitedNumberOfAuthor(pageNumber, limit);
        return authorsList;
    }

    @GetMapping("/author/books/{startingIndex}/{authorId}/{limit}")
    public List<Book> getLimitedNumberOfBooksByAuthor(@PathVariable int authorId, @PathVariable int limit, @PathVariable  int startingIndex) {
        if(!booksInventory.authorExists(authorId)){
            throw new ResourceNotFoundException("Author does not exist");
        }
        List<Book> booksList = booksInventory.getLimitedNumberOfBooksByAuthor(startingIndex, authorId, limit);
        if(startingIndex > booksList.size()){
            throw new ForbiddenException("index not valid");
        }
        return booksList;
    }

    @DeleteMapping("/authors/remove/{userId}/{authorId}")
    public void removeAuthor(@PathVariable int userId, @PathVariable int  authorId) {
        User user = personnel.getUser(userId);
        if(user.getUserRole() != UserRole.Admin){
            throw new ForbiddenException("User in not an Administrator");
        }else if(!booksInventory.authorExists(authorId)){
            throw new ResourceNotFoundException("Author does not exist");
        }else if(booksInventory.authorHasBooksAssociated(authorId)){
            throw new ForbiddenException("Author has books associated to it in the Database");
        } else{
            booksInventory.removeAuthor(authorId);
        }
    }

}


