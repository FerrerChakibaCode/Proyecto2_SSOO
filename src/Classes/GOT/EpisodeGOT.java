/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.GOT;

/**
 *
 * @author emilo
 */
public class EpisodeGOT {

    private int id; // Identifidor unico de cada episodio
    private int counter; // Contador que al llegar a 8 escala la prioridad del episodio
    private int duration;
    private int quality;
    private int priority;
    private EpisodeGOT next;

    public EpisodeGOT(int id) {
        this.id = id;
        this.counter = 0;
        this.duration = setDuration();
        this.quality = setQuality();
        this.priority = setPriority();
        this.next = null;
    }
    
    public int setPriority() {
        int priority;
        if(duration > 90) priority = 1;
        else if (duration <= 90 && duration > 60) priority = 2;
        else priority = 3;

        return priority;
    }

    public int getPriority() {
        return priority;
    }

    public int setDuration() {
        duration = randomInt(30, 120);
        return duration;
    }

    public int getId() {
        return id;
    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getQuality() {
        return quality;
    }

    public int setQuality() {
        quality = 0;
        int intro = randomInt(0, 100);
        int beginning = randomInt(0, 100);
        
        //Endings tiene que ser multiplicado por otro randint porque tienen
        //que ser 2 endings producidos que sean exitosos
        int ending = randomInt(0, 100) * randomInt(0, 100);
        int credits = randomInt(0, 100);

        if (intro <= 75) quality++;
        if (beginning <= 84) quality++;
        if (ending <= 80) quality++;
        if (credits <= 85) quality++;
        

        return quality;
    }

    /**
     *
     * @return a reference to the next Node
     */
    public EpisodeGOT getNext() {
        return next;
    }

    /**
     * Sets new Node to reference to
     *
     * @param next
     */
    public void setNext(EpisodeGOT next) {
        this.next = next;
    }

    public int randomInt(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

}
