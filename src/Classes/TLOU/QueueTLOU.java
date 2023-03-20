/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.TLOU;

/**
 *
 * @author emilo
 */

public class QueueTLOU {
    
    private EpisodeTLOU head;
    private EpisodeTLOU tail;
    private int size;
    
    /**
     *
     */
    public QueueTLOU() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public void Empty() {
        this.head = this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void Enqueue(int ID, int counter) {
        EpisodeTLOU newNode = new EpisodeTLOU(ID, counter);
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
    
    public QueueTLOU UpdateCounter() {
        QueueTLOU aux = new QueueTLOU();
        for (int i = 0; i < size; i++) {
            EpisodeTLOU auxNode = this.Dequeue();
            auxNode.setCounter(auxNode.getCounter() + 1);
            auxNode.setNext(null);
            if (auxNode.getCounter() < 8) {
                this.EnqueueNode(auxNode);
            }else{
                auxNode.setCounter(0);
                aux.EnqueueNode(auxNode);
            }
        }
        return aux;
    }
    /*
    public String EnqueueQueue(QueueTLOU queue){
        String string = "";
        while(!queue.isEmpty()){
            EpisodeTLOU node = queue.Dequeue();
            node.updatePriority();
            string += Integer.toString(node.getID()) + ",";
            this.EnqueueNode(node);
        }
        return string;
    }
    */
    public String PrintQueue(){
        String string = "";
        for (int i = 0; i < size; i++) {
            EpisodeTLOU node = this.Dequeue();
            node.setNext(null);
            string = "ID: " + Integer.toString(node.getId()) + ".TLOU " + "(Contador: " +Integer.toString(node.getCounter()) + ")" + "\n";
            this.EnqueueNode(node);
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
