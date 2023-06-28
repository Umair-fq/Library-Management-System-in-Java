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
public class Queue {
    
    private ArrayList<waiting> waiting = new ArrayList<>();
    
    public void enqueue(waiting w){
        waiting.add(w);
    }
    
    public waiting dequeue(){
        if(waiting.isEmpty()) return null;
        waiting w = waiting.get(0);
        waiting.remove(0);
        return w;
    }

    
    public ArrayList<waiting> getList(){
        return waiting;
    }
    
     public waiting dequeue(BookEntity book){
         Queue tempWaiting = new Queue();
         
         for(int i=0 ; i < Library.waitingList.getList().size() ; i++){
             if(Library.waitingList.getList().get(i).getBook().equals(book)){
                 tempWaiting.enqueue(Library.waitingList.getList().get(i));
                 Library.waitingList.getList().remove(Library.waitingList.getList().get(i));
             }
         }
         
        return tempWaiting.dequeue();
    }

    
}
