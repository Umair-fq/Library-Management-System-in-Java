/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author abdul
 */
public class Library {
    
    public static ArrayList<ReaderEntity> allReaders = new ArrayList<>();
    public static ArrayList<BookEntity> allBooks = new ArrayList<>();
    
    public static ArrayList<Borrowing> borrowingsList = new ArrayList<>();
    public static Queue waitingList = new Queue();
    
    
    public void borrowBook(String readerName, String bookTitle){
        
        BookEntity book  = getBookbyTitle(bookTitle);
        if(book==null) {
            System.out.println("\n----------Book Not Found----------\n");
            return;
        }
        ReaderEntity reader = getReaderbyName(readerName);
        if(reader==null) {
            System.out.println("\n----------Reader Not Found----------\n");
            return;
        }
        
        for(int i=0 ; i < borrowingsList.size() ; i++){
            if(book.equals(borrowingsList.get(i).getBorrowedBook())){
                waiting w = new waiting(book,reader);
                waitingList.enqueue(w);
                System.out.println("\n----------Added to WaitingList----------\n");
                return;
            }
        }
        
        borrowingsList.add(new Borrowing(book,reader));
        System.out.println("\n----------Successful----------\n");

    }
    
    public void returnBook(String readerName, String bookTitle){
        
        BookEntity book  = getBookbyTitle(bookTitle);
        if(book==null) {
            System.out.println("\n----------Book Not Found----------\n");
            return;
        }
        ReaderEntity reader = getReaderbyName(readerName);
        if(reader==null) {
            System.out.println("\n----------Reader Not Found----------\n");
            return;
        }
        
        for(int i=0 ; i < borrowingsList.size() ; i++){
            if(reader.equals(borrowingsList.get(i).getBorrowingReader()) && book.equals(borrowingsList.get(i).getBorrowedBook())){
                borrowingsList.remove(borrowingsList.get(i));
                System.out.println("\n----------Successfully Returned Book----------\n");
                waiting w = waitingList.dequeue(book);
                System.out.println("\nNext Reader in Wishing : ");
                w.getReader().printString();
                return;
            }
        }
        
    }
    
    public void getBorrowedBooksbyReader(String readerName){
        
        ReaderEntity reader = getReaderbyName(readerName);
        if(reader==null) {
            System.out.println("\n----------Reader Not Found----------\n");
            return;
        }
        
        System.out.println("Books borrowed by Readers are : ");
        
        for(int i=0 ; i < borrowingsList.size() ; i++){
            if(borrowingsList.get(i).getBorrowingReader().equals(reader))
                borrowingsList.get(i).getBorrowedBook().printString();
        }
        
    }
    
    public ReaderEntity getReaderbyID(String ID){
        for( int i=0 ; i < allReaders.size() ; i++ )
            if(allReaders.get(i).getID().equals(ID)) return allReaders.get(i);
        return null;
    }
    
    public ReaderEntity getReaderbyName(String Name){
        for(int i=0 ; i < allReaders.size() ; i++){
            String name = allReaders.get(i).getFirstName() + " " + allReaders.get(i).getLastName();
            if(name.equals(Name)) return allReaders.get(i);
        }
        return null;
    }
    
    public BookEntity getBookbyTitle(String bookTitle){
        for(int i=0 ; i < allBooks.size() ; i++ )
            if(allBooks.get(i).getTitle().equals(bookTitle)) return allBooks.get(i);
        return null;
    }
    
    public BookEntity getBookbyAuthor(String bookAuthor){
        for(int i=0 ; i < allBooks.size() ; i++){
            String author = allBooks.get(i).getAuthorFirstName() + " " + allBooks.get(i).getAuthorLastName();
            if(author.equals(bookAuthor)) return allBooks.get(i);
        }
        return null;
    }
    
    public BookEntity getBook(String bookName, String bookAuthor){
        for(int i=0 ; i < allBooks.size() ; i++){
            String author = allBooks.get(i).getAuthorFirstName() + " " + allBooks.get(i).getAuthorLastName();
            if(author.equals(bookAuthor) && allBooks.get(i).getTitle().equals(bookName)) return allBooks.get(i);
        }
        return null;
    }
    
    // Sort the books alphabetically by Auhtor First Name
    public ArrayList<BookEntity> sortBooksByAuthor(){
          ArrayList<BookEntity> sorted =allBooks;
       
        int n = allBooks.size();  
        BookEntity temp ;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){
                String name = allBooks.get(j-1).getAuthorFirstName() + " " + allBooks.get(j-1).getAuthorLastName();
                String name1 = allBooks.get(j).getAuthorFirstName() +" " + allBooks.get(j).getAuthorLastName();
                if(name.compareTo(name1) >0){
                    temp = sorted.get(j-1);  
                    sorted.set(j-1, sorted.get(j));  
                    sorted.set(j, temp);  
                }  
                          
            }  
        }
        return sorted;
    }
    
    // sort the readers alphabetically by Readers Name
    public ArrayList<ReaderEntity> sortReadersByName(){
         ArrayList<ReaderEntity> sorted =allReaders;
       
        int n = allReaders.size();  
        ReaderEntity temp ;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){
                String name = allReaders.get(j-1).getFirstName() + " " + allReaders.get(j-1).getLastName();
                String name1 = allReaders.get(j).getFirstName() +" " + allReaders.get(j).getLastName();
                if(name.compareTo(name1) >0){
                    temp = sorted.get(j-1);  
                    sorted.set(j-1, sorted.get(j));  
                    sorted.set(j, temp);  
                }  
                          
            }  
        }
        return sorted;
    }
    
    // sort the Readers alphabatically by Readers ID
    public ArrayList<ReaderEntity> sortReadersByID(){
        ArrayList<ReaderEntity> sorted =allReaders;
       
        int n = allReaders.size();  
        ReaderEntity temp ;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){
                if(sorted.get(j-1).getID().compareTo(  sorted.get(j).getID()) >0){
                    //swap elements  
                    temp = sorted.get(j-1);  
                    sorted.set(j-1, sorted.get(j));  
                    sorted.set(j, temp);  
                }  
                          
            }  
        }
        return sorted;
    }
    
    // Sorts the book alphabatically by Books Title
    public ArrayList<BookEntity> sortBooksByTitle(){
        ArrayList<BookEntity> sorted =allBooks;
       
        int n = allBooks.size();  
        BookEntity temp ;  
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){
                if(sorted.get(j-1).getTitle().compareTo(  sorted.get(j).getTitle()) >0){
                    //swap elements  
                    temp = sorted.get(j-1);  
                    sorted.set(j-1, sorted.get(j));  
                    sorted.set(j, temp);  
                }  
                          
            }  
        }
        return sorted;
    }
    
    // reads the books data from file and saves it to books list
    public void readBooks() throws IOException{
        File file = new File("C:\\Users\\abdul\\OneDrive\\Documents\\NetBeansProjects\\LibraryManagementSystem\\src\\librarymanagementsystem\\books.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String[] genres = {};
                if(values.length == 5){
                     genres = values[4].split("\\|");
                }
                List<String>  list = (List<String>) Arrays.asList(genres);
                ArrayList<String> a1 = new ArrayList<>(list);
                BookEntity book = new BookEntity(values[0],values[1],values[2],values[3],a1);
                allBooks.add(book);
            }
        }
        
    }
    
    // reads the readers data from file and saves it into readers list
    public void readReaders() throws IOException{
        File file = new File("C:\\Users\\abdul\\OneDrive\\Documents\\NetBeansProjects\\LibraryManagementSystem\\src\\librarymanagementsystem\\readers.csv");
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ReaderEntity reader = new ReaderEntity(values[0],values[1],values[2],values[3],values[4]);
                allReaders.add(reader);
            }
        }
    }
    
    // reads the data of borrowers from file and saves it to borrows list
    public void readBorrows() throws IOException{
        File file = new File("C:\\Users\\abdul\\OneDrive\\Documents\\NetBeansProjects\\LibraryManagementSystem\\src\\librarymanagementsystem\\borrow.csv");
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                String bookID = values[0];
                BookEntity book = null;
                String readerID = values[1];
                ReaderEntity reader = null;
                
                for(int i=0 ; i < allBooks.size() ; i++)
                    if(allBooks.get(i).getID().equals(bookID))
                        book=allBooks.get(i);
                
                for(int i=0 ; i < allReaders.size() ; i++)
                    if(allReaders.get(i).getID().equals(readerID))
                        reader = allReaders.get(i);
                
                Borrowing borrow = new Borrowing(book,reader);
                borrowingsList.add(borrow);
            }
        }
    }
    
    public void readWaitings() throws IOException{
        File file = new File("C:\\Users\\abdul\\OneDrive\\Documents\\NetBeansProjects\\LibraryManagementSystem\\src\\librarymanagementsystem\\waiting.csv");
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                String bookID = values[0];
                BookEntity book = null;
                String readerID = values[1];
                ReaderEntity reader = null;
                
                for(int i=0 ; i < allBooks.size() ; i++)
                    if(allBooks.get(i).getID().equals(bookID))
                        book=allBooks.get(i);
                
                for(int i=0 ; i < allReaders.size() ; i++)
                    if(allReaders.get(i).getID().equals(readerID))
                        reader = allReaders.get(i);
                
                waiting w = new waiting(book,reader);
                waitingList.enqueue(w);
            }
        }
    }
    
}
