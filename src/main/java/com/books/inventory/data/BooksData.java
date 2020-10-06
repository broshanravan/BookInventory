package com.books.inventory.data;

import java.util.List;

import com.books.inventory.beans.Book;
import com.books.inventory.beans.Author;

public interface BooksData {

    public List<Book> getLimitedNumberOfBooks(int startIndex, int limit);

    public List<Author> getLimitedNumberOfAuthor(int startIndex,int autherCount);

    public List<Book>  getLimitedNumberOfBooksByAuthor(int startInex, int authorId, int limit);

    public void removeAuthor(int authorIdIn);

    public boolean authorHasBooksAssosiated(int authorIdIn);
}
