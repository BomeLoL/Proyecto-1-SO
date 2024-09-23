/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataEstructure;

import Classes.Worker;

/**
 *
 * @author kevin
 */
public class Node {
    private Worker data;
    private Node next;
    
    public Node(Worker data){
        this.data = data;
        this.next = null;
    }
    
    public Worker getData(){
        return data;
    }
    
    public void setData(Worker data){
        this.data = data;
    }
    
    public Node getNext(){
        return next;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
}

