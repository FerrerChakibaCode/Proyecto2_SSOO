/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author emilo
 */
public class Node<T> {
    private T data;
    private Node next;
    
    /**
     *
     * @param datum
     */
    public Node (T datum) {
        this.data = datum;
        this.next = null;
    }

    /**
     * Get Node's data
     * @return the data inside Node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets new data to Node
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @return a reference to the next Node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets new Node to reference to
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
    
    
}
