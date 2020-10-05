package om.books.inventory.brans;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("BookInventory")
public class Book {

    private int bookId;
    private int authorId;
    private String bookName;
    private String bookdesctiption;

    public Book(){

    }

    public Book(int bookId, int authorId, String bookName, String bookdesctiption) {
        this.bookId = bookId;
        this.authorId = authorId;
        this.bookName = bookName;
        this.bookdesctiption = bookdesctiption;
    }

    public String getBookdesctiption() {
        return bookdesctiption;
    }

    public void setBookdesctiption(String bookdesctiption) {
        this.bookdesctiption = bookdesctiption;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }





}
