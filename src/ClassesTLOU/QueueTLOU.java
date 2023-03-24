/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesTLOU;

/**
 *
 * @author Nicolás Briceño
 */

public class QueueTLOU {
    
    private EpisodeTLOU head;
    private EpisodeTLOU tail;
    private int size;
    private int number;
    
    /**
     *
     */
    public QueueTLOU(int number) {
        this.head = this.tail = null;
        this.size = 0;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void Empty() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void Enqueue(int ID, int counter) {
        EpisodeTLOU newNode = new EpisodeTLOU(ID);
        if (this.isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        size++;
    }
    
    public void EnqueueNode(EpisodeTLOU node) {
        if (this.isEmpty()) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        size++;
    }
    
    public EpisodeTLOU Dequeue() {
        EpisodeTLOU newNode = null;
        switch (this.size) {
            case 0:
                break;
            case 1:
                newNode = this.head;
                this.Empty();
                break;
            default:
                newNode = this.head;
                head = head.getNext();
                size--;
                break;
        }
        return newNode;
    }
    
    public String PrintQueue(){
        String string = "";
        for (int i = 0; i < size; i++) {
            EpisodeTLOU node = this.Dequeue();
            node.setNext(null);
            String sentence = "ID: " + Integer.toString(node.getId()) + ".TLOU " + "(Contador: " +Integer.toString(node.getCounter()) + " / Duración: " + Integer.toString(node.getDuration()) + ")" + "\n";
            this.EnqueueNode(node);
            string += sentence;
            
        }
        return string;
    }
    
    public EpisodeTLOU getHead() {
        return head;
    }
    
    public void setHead(EpisodeTLOU head) {
        this.head = head;
    }
    
    public EpisodeTLOU getTail() {
        return tail;
    }
    
    public void setTail(EpisodeTLOU tail) {
        this.tail = tail;
    }
}
