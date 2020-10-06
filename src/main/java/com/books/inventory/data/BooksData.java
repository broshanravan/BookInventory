package com.books.inventory.data;

import java.util.List;

import com.books.inventory.beans.Book;
import com.books.inventory.beans.Author;

public interface BooksData {

    public List<Book> getLimitedNumberOfBooks(int startIndex, int limit);

    public List<Author> getLimitedNumberOfAuthor(int paageNumber,int limit);

    public List<Book>  getLimitedNumberOfBooksByAuthor(int startInex, int authorId, int limit);

    public void removeAuthor(int authorIdIn);

    public boolean authorHasBooksAssociated(int authorIdIn);

    public boolean authorExists(int authorId);

    public Author getAuthorById(int authorId);
}
