package com.books.inventory.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("BookInventory")
public class Author {
    private int authorId;
    private String firstName;
    private String surname;
    private int NumberOfBooks;

    public Author(){

    }

    public Author(int authorId, String firstName, String surname, int numberOfBooks) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.surname = surname;
        NumberOfBooks = numberOfBooks;
    }

    public int getNumberOfBooks() {
        return NumberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        NumberOfBooks = numberOfBooks;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
