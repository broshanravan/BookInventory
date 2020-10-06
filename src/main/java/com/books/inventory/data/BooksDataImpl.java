package com.books.inventory.data;


import com.books.inventory.beans.Book;
import org.springframework.stereotype.Component;

import java.util.*;

import com.books.inventory.beans.Author;

@Component
public class BooksDataImpl implements BooksData{


    private static Map<Integer, Book> libraryBooks = new HashMap<Integer,Book>();
    private static Map<Integer,Author> authors = new HashMap<Integer,Author>();


    /**
     * This methid finds out if there is a book
     * associated with an author,
     * in which case It will prevennt the deletion of the puther
     * @param authorIdIn
     * @return
     */
    public boolean authorHasBooksAssociated(int authorIdIn){
        Set<Integer> keySet = libraryBooks.keySet();
        for(Integer key : keySet) {
            Book book = libraryBooks.get(key);
            if(authorIdIn == book.getAuthorId()){
                return true;
            }
        }
        return false;
    }

    /**
     * before conduction any operation on the author checks
     * if the author id is valid
     * @param authorId
     * @return
     */
    public boolean authorExists(int authorId) {
        Author author = getAuthorById(authorId);
        if (author ==null){
            return false;
        }
        return true;
    }


    /**
     * Retrieves author details from the DB
     * using the ID
     * @param authorId
     * @return
     */
    public Author getAuthorById(int authorId){
        Author author = authors.get(authorId);
        return  author;
    }

    /**
     * deletes record with provider key
     * from author map
     * @param authorIdIn
     */
    public void removeAuthor(int authorIdIn) {
        Author author =authors.get(authorIdIn);
        System.out.println("REMOVING AUTHOR" + author.getFirstName()+ " " + author.getSurname() + " WITH ID OF::::::"  + authorIdIn);
        authors.remove(new Integer(authorIdIn));
    }

    /**
     * * getting a limited number of books from an
     * specific point index to different
     * page nymbers
     * @param startingIndex
     * @param limit
     * @return
     */
    public List<Book> getLimitedNumberOfBooks(int startingIndex, int limit){
        List<Book> booksList = new LinkedList<Book>();

        for  (int i =startingIndex; i< startingIndex + limit ; i++ ){
            if(i<= libraryBooks.size()) {
                Book book = libraryBooks.get(i);
                booksList.add(book);
                System.out.println(book.getBookName());
            }
        }

        return booksList;
    }

    /**
     * getting a limited number of Authors from an
     * specific point index to different
     * page nymbers
     * @param startingIndex
     * @param limit
     * @return
     */
    public List<Author> getLimitedNumberOfAuthor(int startingIndex,int limit){
        List<Author> authorsList = new LinkedList<Author>();

        for  (int i =startingIndex; i< startingIndex + limit ; i++ ){
            if(i <= authors.size()) {
                authorsList.add(authors.get(i));
            }
        }

        return authorsList;
    }


    /**
     * getting a limiter number of Books
     * by a particulas auther
     * @param startingIndex
     * @param authorId
     * @param limit
     * @return
     */
    public List<Book>  getLimitedNumberOfBooksByAuthor(int startingIndex, int authorId,int limit){
        List<Book> booksList = new LinkedList<Book>();

        for  (int i = startingIndex; i < libraryBooks.size()  ; i++ ){
            if(i<= libraryBooks.size()) {
                Book book = libraryBooks.get(i);
                booksList.add(book);
                System.out.println(i);
                System.out.println(book.getBookName());
                if (booksList.size() >= limit) {
                    break;
                }
            }

        }

        return booksList;
    }

    /**
     * in order to initialize a datasource
     * the following code runs on the fiirst initiation of this
     * Class
     */

    static{

        /** First Creating all the authers and put into the Datastor of their own */
        Author JawaharlalNehru = new Author(1,"Jawaharlal"," Nehru",2);
        authors.put(JawaharlalNehru.getAuthorId(), JawaharlalNehru);

        Author cervantes = new Author(3,"A"," Cervantes",3);
        authors.put(cervantes.getAuthorId(),cervantes);

        Author stephenKing = new Author(4,"Stephen"," King",2);
        authors.put(stephenKing.getAuthorId(), stephenKing);

        Author conanDoyle = new Author(2,"Conan"," Doyle",3);
        authors.put(conanDoyle.getAuthorId(), conanDoyle);

        Author shakespeare = new Author(5,"William"," Shakespeare",3);
        authors.put(shakespeare.getAuthorId(), shakespeare);

        Author romianRolland = new Author(6,"Romian"," Rolland",1);
        authors.put(romianRolland.getAuthorId(),romianRolland);

        Author jKRolling = new Author(7,"JK"," Rolling",3);
        authors.put(jKRolling.getAuthorId(), jKRolling);


        /** No wreating the books for each aouthor and storing it into a separate data source */

        Book bunchOfOldLetters = new Book(1,JawaharlalNehru.getAuthorId(),
                "A Bunch of Old Letters",
                "book Describe here");
        libraryBooks.put(bunchOfOldLetters.getBookId(),bunchOfOldLetters);


        Book encyclopediaOfIndiaFreedomFighters = new Book(2,
                JawaharlalNehru.getAuthorId(),
                "Encyclopedia Of Indian FreedomFighters",
                "book Describe here");
        libraryBooks.put(encyclopediaOfIndiaFreedomFighters.getBookId(),encyclopediaOfIndiaFreedomFighters);


        Book adventuresOfSherlockHolmes = new Book(3,
                conanDoyle.getAuthorId(),
                "Adventures of Sherlock Holmes",
                "book Describe here");
        libraryBooks.put(adventuresOfSherlockHolmes.getBookId(),adventuresOfSherlockHolmes);


        Book houndOftheBaskervilles = new Book(4,
                conanDoyle.getAuthorId(),
                "The Hound of the Baskervilles",
                "book Describe here");
        libraryBooks.put(houndOftheBaskervilles.getBookId(),houndOftheBaskervilles);


        Book theFinalProblem = new Book(5,
                conanDoyle.getAuthorId(),
                "The final Problem",
                "book Describe here");
        libraryBooks.put(theFinalProblem.getBookId(),theFinalProblem);


        Book donOuixote= new Book(6,
                cervantes.getAuthorId(),
                "Don Ouixote",
                "book Describe here");
        libraryBooks.put(donOuixote.getBookId(), donOuixote);


        Book exemplaryNovels = new Book(7,
                cervantes.getAuthorId(),
                "Exemplary Novels",
                "book Describe here");
        libraryBooks.put(exemplaryNovels.getBookId(),exemplaryNovels);


        Book theSiegeOfNumantia = new Book(8,
                cervantes.getAuthorId(),
                "The Siege of Numantia",
                "book Describe here");
        libraryBooks.put(theSiegeOfNumantia.getBookId(), theSiegeOfNumantia);


        Book juliusCaesar = new Book(9,
                shakespeare.getAuthorId(),
                "Julius Caesar",
                "book Describe here");
        libraryBooks.put(juliusCaesar.getBookId(),juliusCaesar);


        Book Hamlet = new Book(10,
                shakespeare.getAuthorId(),
                "Hamlet",
                "book Describe here");
        libraryBooks.put(Hamlet.getBookId(),Hamlet);


        Book romeoAndJuliet = new Book(11,
                shakespeare.getAuthorId(),
                "Romeo and Juliet",
                "book Describe here");
        libraryBooks.put(romeoAndJuliet.getBookId(), romeoAndJuliet);


        Book shawshankRedemption = new Book(12,
                stephenKing.getAuthorId(),
                "Shawshank Redemption",
                "book Describe here");
        libraryBooks.put(shawshankRedemption.getBookId(),shawshankRedemption);


        Book WolvesOfTheCalla = new Book(13,
                stephenKing.getAuthorId(),
                "Wolves of the Calla",
                "book Describe here");
        libraryBooks.put(WolvesOfTheCalla.getBookId(),WolvesOfTheCalla);


        Book jeanChristopher = new Book(14,
                romianRolland.getAuthorId(),
                "Jean Christopher",
                "book Describe here");
        libraryBooks.put(jeanChristopher.getBookId(), jeanChristopher);

    }


}

