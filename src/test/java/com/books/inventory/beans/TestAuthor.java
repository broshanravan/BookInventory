package com.books.inventory.beans;

import org.junit.Test;

public class TestAuthor {

    @Test
    public void testParametrisedConstructor(){
        Author stephenKing = new Author(1, "Stephen",  "King",3);

        assert "Stephen".equalsIgnoreCase(stephenKing.getFirstName());
        assert "King".equalsIgnoreCase(stephenKing.getSurname());
        assert 1 == stephenKing.getAuthorId();
        assert 3 == stephenKing.getNumberOfBooks();
    }

    @Test
    public void testMutators(){
        Author bruce = new Author();
        bruce.setFirstName("Bruce");
        bruce.setSurname("Roshanravan");
        bruce.setAuthorId(666);
        bruce.setNumberOfBooks(0);

        assert "bruce".equalsIgnoreCase(bruce.getFirstName());
        assert "Roshanravan".equalsIgnoreCase(bruce.getSurname());
        assert 666 == bruce.getAuthorId();
        assert 0 == bruce.getNumberOfBooks();

    }
}
