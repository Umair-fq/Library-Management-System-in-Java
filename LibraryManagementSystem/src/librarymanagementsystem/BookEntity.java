/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class BookEntity {
    
    private String ID;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private ArrayList<String> genres;
    
    public BookEntity(String ID, String authorFirstName, String authorLastName, String title, ArrayList<String> genres){
        this.ID = ID;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.genres = genres;
    }
    
    public String getID(){
        return this.ID;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getAuthorFirstName(){
        return this.authorFirstName;
    }
    
    public String getAuthorLastName(){
        return this.authorLastName;
    }
    
    public ArrayList<String> getGenres(){
        return this.genres;
    }
    
    public void setID(String ID){
        this.ID=ID;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setAuthorFirstName(String name){
        this.authorFirstName = name;
    }
    
    public void setAuthorLastName(String name){
        this.authorLastName = name;
    }
    
    public void setGenres(ArrayList<String> genres){
        this.genres = genres;
    }
    
    public void printString(){
        System.out.println("\nBook ID : "+ID+"\nAuthor Name : "+authorFirstName+" "+authorLastName+"\nBook Title : "+title);
        System.out.println("Genres : ");
        for(int i=0 ; i < genres.size() ; i++){
            System.out.print(genres.get(i)+" | ");
        }
        System.out.println("\n");
    }
    
}