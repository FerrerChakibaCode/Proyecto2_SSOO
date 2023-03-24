package ClassesTLOU;

/**
 *
 * @author Nicolás Briceño
 */
public class EpisodeTLOU {
    private EpisodeTLOU next;
    private int id; // Identifidor unico de cada episodio
    private int counter; // Contador que al llegar a 8 escala la prioridad del episodio
    private int duration;
    private int quality; // Valor del 0 al 4 dependiendo de cada una de sus partes
    private int priority;
    private int prevQueue;
    
    /**
     *
     * @param data
     * @param id
     * @param counter
     */
    public EpisodeTLOU (int id) {
        this.next = null;
        this.id = id;
        this.counter = 0;
        this.duration = 0;//setDuration(getRandom(1,3));
        this.quality = setQuality();
        this.priority = setPriority();
    }

    public int setPriority() {
        int priority;
        if (duration > 90) {
            priority = 1;
        } else if (duration <= 90 && duration > 60) {
            priority = 2;
        } else {
            priority = 3;
        }
        prevQueue = priority;
        return priority;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPrevQueue() {
        return prevQueue;
    }

    public void setPrevQueue(int prevQueue) {
        this.prevQueue = prevQueue;
    }

    public int getDuration() {
        return duration;
    }
    
    public int getQuality() {
        return quality;
    }

    private int setQuality() {
        quality = 0;
        int randIntro = getRandom(0,100);
        int randBeg = getRandom(0,100) * getRandom(0,100); // Recordar que son 2 inicios
        int randEnd = getRandom(0,100) * getRandom(0,100); // Recordar que son 2 cierres
        int randCredit = getRandom(0,100);
        
        if (randIntro <= 75) {
            quality++;
            duration += 35;
        } 
        if (randBeg <= 84) {
            quality++;
            duration += 35;
        } 
        if (randEnd <= 80) {
            quality++;
            duration += 35;            
        }
        if (randCredit <= 85) {
            quality++;
            duration += 35;            
        }
        
        return quality;
    }
    
    public void setQuality(int quality) {
        this.quality = quality;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     *
     * @return a reference to the next EpisodeTLOU
     */
    public EpisodeTLOU getNext() {
        return next;
    }

    /**
     * Sets new EpisodeTLOU to reference to
     * @param next
     */
    public void setNext(EpisodeTLOU next) {
        this.next = next;
    }
    
    public static int getRandom(int a, int b){
        int c = (int)(Math.random()*(b-a+1)+a);
        return c;
    }
}
