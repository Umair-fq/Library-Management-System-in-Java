/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

/**
 *
 * @author abdul
 */
public class waiting {
    
    private BookEntity book;
    private ReaderEntity reader;

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public ReaderEntity getReader() {
        return reader;
    }    

    public waiting(BookEntity book, ReaderEntity reader) {
        this.book = book;
        this.reader = reader;
    }

    public void setReader(ReaderEntity reader) {
        this.reader = reader;
    }
    
    
    
}
