package com.books.inventory.data;

import com.books.inventory.beans.Author;
import com.books.inventory.beans.Book;
import org.junit.Test;

import java.util.List;

public class TestBooksData {

    BooksData booksData = new BooksDataImpl();

    @Test
    public void testGetLimitedNumberOfBooks(){
         List<Book> books =booksData.getLimitedNumberOfBooks( 1,  2);
         assert books.size() == 2;
    }

    @Test
    public void testGetLimitedNumberOfAuthor(){
        List<Author> authors = booksData.getLimitedNumberOfAuthor(2,3);
        assert authors.size() == 3;
    }

    @Test
    public void testGetLimitedNumberOfBooksByAuthor(){
        List<Book> books  = booksData.getLimitedNumberOfBooksByAuthor(1, 2, 1);

        Book book = books.get(0);
        System.out.println(book.getBookId());
        assert "A Bunch of Old Letters".equalsIgnoreCase(book.getBookName().trim());
        assert "book Describe here".equalsIgnoreCase(book.getBookdesctiption());
        assert (book.getAuthorId()) == 1;

        assert books.size() ==1;
    }


}
