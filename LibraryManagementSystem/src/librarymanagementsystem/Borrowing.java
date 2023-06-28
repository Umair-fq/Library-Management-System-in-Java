/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

/**
 *
 * @author abdul
 */
public class Borrowing {
    
    private BookEntity borrowedBook;
    private ReaderEntity borrowingReader;

    public BookEntity getBorrowedBook() {
        return borrowedBook;
    }

    public Borrowing(BookEntity borrowedBook, ReaderEntity borrowingReader) {
        this.borrowedBook = borrowedBook;
        this.borrowingReader = borrowingReader;
    }

    public void setBorrowedBook(BookEntity borrowedBook) {
        this.borrowedBook = borrowedBook;
    }

    public ReaderEntity getBorrowingReader() {
        return borrowingReader;
    }

    public void setBorrowingReader(ReaderEntity borrowingReader) {
        this.borrowingReader = borrowingReader;
    }
    
    
    
}
