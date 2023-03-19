package Classes.TLOU;

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
    
    /**
     *
     * @param data
     * @param id
     * @param counter
     */
    public EpisodeTLOU (int id, int counter) {
        this.next = null;
        this.id = id;
        this.counter = counter;
        this.duration = setDuration(getRandom(1,3));
        System.out.println("La duración del episodio: " + this.id + ", es de " + this.duration);
        this.quality = setQuality(0);
        System.out.println("La calidad del episodio: " + this.id + ", es de " + this.quality);

    }

    public int getDuration() {
        return duration;
    }

    private int setDuration(int duration) {
        switch (duration) {
            case 1:
                this.duration = getRandom(15,59); //Pongamos 15 como el mínimo para una serie
                break;
            case 2:
                this.duration = getRandom(60,90);
                break;
            case 3:
                this.duration = getRandom(91,150); //150 porque hay series con capítulos de hasta 150 min
                break;
            default:
                break;
        }
        return duration;
    }
    
    public int getQuality() {
        return quality;
    }

    private int setQuality(int quality) {
        int randIntro = getRandom(0,100);
        int randBeg = getRandom(0,100);
        int randEnd = getRandom(0,100);
        int randCredit = getRandom(0,100);
        
        if (randIntro <= 75) {
            quality++;
        } else if (randBeg <= 84) {
            quality++;
        } else if (randEnd <= 80) {
            quality++;
        } else if (randCredit <= 85) {
            quality++;
        }
        
        return quality;
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
