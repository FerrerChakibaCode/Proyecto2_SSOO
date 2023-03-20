/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.GOT;

import static Classes.GOT.MainGOT.IdCounter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author emilo
 */
public class ManagerGOT extends Thread{
    // Hacemos las 4 colas
    public static QueueGOT firstQueue;
    public static QueueGOT secondQueue;
    public static QueueGOT thirdQueue;
    public static QueueGOT  strengthQueue;
    public static int idCounter;
    private boolean stop;

    public ManagerGOT(QueueGOT firstQueue, QueueGOT secondQueue, QueueGOT thirdQueue, QueueGOT strengthQueue) throws ParseException {
        this.firstQueue = firstQueue;
        this.secondQueue = secondQueue;
        this.thirdQueue = thirdQueue;
        this.strengthQueue = strengthQueue;
        readJson();
    }
    
    @Override
    public void run() {
        while (!stop) {
            try {
                Thread.sleep(1000);
                ProduceEpisode();
            } catch (InterruptedException ex) {
                Logger.getLogger(ManagerGOT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void ProduceEpisode() {
        idCounter++;
        EpisodeGOT episode = new EpisodeGOT(idCounter);
        switch (episode.getPriority()) {
            case 1:
                firstQueue.enqueue(episode);
                Interfaces.main.queue1GOT.setText(firstQueue.printQueue());
                break;
            case 2:
                secondQueue.enqueue(episode);
                Interfaces.main.queue2GOT.setText(secondQueue.printQueue());
                break;
            case 3:
                thirdQueue.enqueue(episode);
                Interfaces.main.queue3GOT.setText(thirdQueue.printQueue());
                break;
        }
        writeJson();
    }
    
    public void updateCounters(QueueGOT queue, QueueGOT nextQueue) {
        for (int i = 0; i < queue.getSize(); i++) {
            EpisodeGOT episodeAux = queue.dequeue(); // Asignamos el aux al primer elemento de la cola
            episodeAux.setNext(null);
            if (episodeAux.getCounter() >= 8) {
                episodeAux.setCounter(0);
                nextQueue.enqueue(episodeAux); // Sube la prioridad del elemento
            } else {
                episodeAux.setCounter(episodeAux.getCounter() + 1);
                queue.enqueue(episodeAux);
            }

        }
    }
    
    public  void readJson() throws ParseException {

        JSONParser parser = new JSONParser();

        try ( Reader reader = new FileReader("src/Assets/dataGOT.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            idCounter = ((Long) jsonObject.get("counter")).intValue();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeJson() {
       JSONObject object = new JSONObject();
       object.put("counter", idCounter);
        
       try ( FileWriter file = new FileWriter("src/Assets/dataGOT.json")) {
            file.write(object.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
    
    
    
}
