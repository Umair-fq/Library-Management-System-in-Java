/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarymanagementsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdul
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Library library = new Library();
        try {
            library.readBooks();
            library.readReaders();
//            library.readBorrows();
//            library.readWaitings();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(BookEntity book : Library.allBooks){
            book.printString();
        }
        for(ReaderEntity reader : Library.allReaders){
            reader.printString();
        }
        
        Scanner scan = new Scanner(System.in);
        int option;
        
        // all Options
        
        while(true){
            
            System.out.println("Enter One of the Following Options : ");
            System.out.println("1	Search Book by Title");
            System.out.println("2	Search Book by Author (FirstName + LastName)");
            System.out.println("3	List Books by Title alphabatically ");
            System.out.println("4	List Books by Author alphabatically ");
            System.out.println("5	Search Reader by ID. ");
            System.out.println("6	Search Reader by Name. ");
            System.out.println("7	List Reader by ID alphabatically ");
            System.out.println("8	List Reader by Name alphabatically ");
            System.out.println("9	Borrow Book ");
            System.out.println("10	Return Book ");
            System.out.println("11	List Books borrowed by Reader (Name). ");
            System.out.println("0	Exit Program ");
            
            option = scan.nextInt();
            scan.nextLine();

            switch(option){
                case 0 : {
                    System.exit(0);
                }
                case 1 : {
                    System.out.print("Enter Book Title : ");
                    String title = scan.nextLine();
                    BookEntity b = library.getBookbyTitle(title);
                    if(b==null)System.out.println("\n----------Book Not Found----------\n");
                    else b.printString();
                    break;
                }
                case 2 :{
                    System.out.print("Enter Auhtor Name (FirstName LastName) : ");
                    String name = scan.nextLine();
                    BookEntity b = library.getBookbyAuthor(name);
                    if(b==null)System.out.println("\n----------Book Not Found----------\n");
                    else b.printString();
                    break;
                }
                case 3 :{
                    ArrayList<BookEntity> books = library.sortBooksByTitle();
                    for(int i=0 ; i < books.size() ; i++)
                        books.get(i).printString();
                    break;
                }
                case 4 :{
                    ArrayList<BookEntity> books = library.sortBooksByAuthor();
                    for(int i=0 ; i < books.size() ; i++)
                        books.get(i).printString();
                    break;
                }
                case 5 : {
                    System.out.print("Enter Reader ID : ");
                    String id = scan.next();
                    ReaderEntity r = library.getReaderbyID(id);
                    if (r==null) System.out.println("\n----------Reader Not Found----------\n");
                    else r.printString();
                    break;
                }
                case 6 : {
                    System.out.print("Enter Reader Name (FirstName LastName) : ");
                    String name = scan.nextLine();
                    ReaderEntity r = library.getReaderbyName(name);
                    if (r==null) System.out.println("\n----------Reader Not Found----------\n");
                    else r.printString();
                    break;
                }
                case 7 : {
                    ArrayList<ReaderEntity> readers = library.sortReadersByID();
                    for(int i=0 ; i < readers.size() ; i++)
                        readers.get(i).printString();
                    break;
                }
                case 8 : {
                    ArrayList<ReaderEntity> readers = library.sortReadersByName();
                    for(int i=0 ; i < readers.size() ; i++)
                        readers.get(i).printString();
                    break;
                }
                case 9 : {
                    System.out.print("Enter Book Title : ");
                    String title = scan.nextLine();
                    System.out.print("Enter Reader Name (FirstName LastName) : ");
                    String name = scan.nextLine();
                    library.borrowBook(name, title);
                    break;
                }
                case 10 : {
                    System.out.print("Enter Book Title : ");
                    String title = scan.nextLine();
                    System.out.print("Enter Reader Name (FirstName LastName) : ");
                    String name = scan.nextLine();
                    library.returnBook(name, title);
                    break;
                }
                case 11 : {
                    System.out.print("Enter Reader Name (FirstName LastName) : ");
                    String name = scan.nextLine();
                    library.getBorrowedBooksbyReader(name);
                    break;
                }
                default : {
                    System.out.println("\n----------Incorrect Option Try Again----------\n");
                }
            }
        }
        
    }
    
}
