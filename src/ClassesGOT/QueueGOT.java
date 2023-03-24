/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesGOT;

/**
 *
 * @author emilo
 */
public class QueueGOT {

    private int number;

    private EpisodeGOT head;
    private EpisodeGOT tail;
    private int size;

    /**
     *
     */
    public QueueGOT(int number) {
        this.head = this.tail = null;
        this.size = 0;
        this.number = number;

    }

    public int getNumber() {
        return number;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Puts a new element in the queue
     *
     * @param node EpisodeGOT to be added to the queue
     */
    public void enqueue(EpisodeGOT node) {
        this.size++;
        if (isEmpty()) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    /**
     * Deletes the first element in the queue and returns its data
     *
     * @return Node contained in the first element of the QueueGOT
     */
    public EpisodeGOT dequeue() {
        if (isEmpty()) {
            return null;
        }
        EpisodeGOT temp = this.head;
        this.head = temp.getNext();
        temp.setNext(null);
        this.size--;
        return temp;
    }

    public String printQueue() {
        String string = "";

        if (size == 0) {
            return string;
        }
        for (int i = 0; i < size; i++) {
            EpisodeGOT node = this.dequeue();
            node.setNext(null);
            String eachString = "ID: " + Integer.toString(node.getId()) + ".GOT " + "(Cuenta: " + Integer.toString(node.getCounter()) + ") Duracion: " + Integer.toString(node.getDuration()) + "\n";
            this.enqueue(node);
            string += eachString;
        }
        return string;
    }

    /**
     * Returns the Head of the QueueGOT
     *
     * @return
     */
    public EpisodeGOT getHead() {
        return head;
    }

    /**
     * Returns the tail of the QueueGOT
     *
     * @return Node
     */
    public EpisodeGOT getTail() {
        return tail;
    }

    /**
     * Returns the size of the QueueGOT
     *
     * @return
     */
    public int getSize() {
        return size;
    }

}
