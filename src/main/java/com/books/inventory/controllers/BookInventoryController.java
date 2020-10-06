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

    /**
     * Retrieves limited number of Books
     * according to the page index
     * @param pageIndex
     * @param limit
     * @return
     */
    @GetMapping("/books/{pageIndex}/{limit}")
    public List<Book> getBooks(@PathVariable int pageIndex, @PathVariable int limit) {
        List<Book> booksList = booksInventory.getLimitedNumberOfBooks(pageIndex, limit);
        return booksList;
    }

    /**
     * Retrieves limited number of Authers
     * according to the page index
     * @param pageIndex
     * @param limit
     * @return
     */
    @GetMapping("/authors/{pageIndex}/{limit}")
    public List<Author> getAuthers(@PathVariable int pageIndex, @PathVariable int limit) {
        List<Author> authorsList = booksInventory.getLimitedNumberOfAuthor(pageIndex, limit);
        return authorsList;
    }

    /**
     * Retrieves limited number of books
     * for a particular author
     * according to the page index
     * @param pageIndex
     * @param authorId
     * @param limit
     * @return
     */
    @GetMapping("/author/books/{pageIndex}/{authorId}/{limit}")
    public List<Book> getLimitedNumberOfBooksByAuthor( @PathVariable  int pageIndex, @PathVariable int authorId, @PathVariable int limit) {
        if(!booksInventory.authorExists(authorId)){
            throw new ResourceNotFoundException("Author does not exist");
        }
        List<Book> booksList = booksInventory.getLimitedNumberOfBooksByAuthor(pageIndex, authorId, limit);
        if(pageIndex > booksList.size()){
            throw new ForbiddenException("index not valid");
        }
        return booksList;
    }

    /**
     * Removes an author from the database
     * in case there are no book in the database
     * associated with that author
     * @param userId
     * @param authorId
     */
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


