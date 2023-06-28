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
public class ReaderEntity {
    
    private String ID;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    
    public ReaderEntity(String ID, String firstName, String lastName, String address, String phoneNumber) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void printString(){
        System.out.println("\nReader ID : "+ID+"\nReader Name : "+firstName+" "+lastName+"\nReader Address : "+address+"\nReader Phone : "+phoneNumber+"\n");
    }
    
    
}
