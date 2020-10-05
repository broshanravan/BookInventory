package com.books.inventory.beans;

import org.junit.Test;

public class TestBooks {

    @Test
    public void testingParametrizedConstructor(){

        Book adventuresOfSherlockHolmes = new Book(1,
                2,
                "Adventures of Sherlock Holmes",
                "Fiction Adventure");

        assert 1 ==  adventuresOfSherlockHolmes.getBookId();
        assert "Adventures of Sherlock Holmes".equalsIgnoreCase(adventuresOfSherlockHolmes.getBookName());
        assert 2 == adventuresOfSherlockHolmes.getAuthorId();
        assert "Fiction Adventure".equalsIgnoreCase(adventuresOfSherlockHolmes.getBookdesctiption());

    }

    @Test
    public void testingMutators(){
        Book book = new Book();
        book.setAuthorId(2);
        book.setBookName("Hamlet");
        book.setBookdesctiption("Drama");
        book.setBookId(3);


        assert 3 == book.getBookId();
        assert 2 == book.getBookId();
        assert "Hamlet".equalsIgnoreCase(book.getBookName());
        assert "Drama".equalsIgnoreCase(book.getBookdesctiption());


    }
}
