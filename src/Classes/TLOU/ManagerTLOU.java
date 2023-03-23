/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.TLOU;

import Interfaces.main;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Nicolás Briceño
 */
public class ManagerTLOU extends Thread{
    // Hacemos las 3 colas
    public static QueueTLOU firstQueue;
    public static QueueTLOU secondQueue;
    public static QueueTLOU thirdQueue;
    public static QueueTLOU backupQueue;
    public static int idCounter;
    private boolean stop;

    public ManagerTLOU() {
        ManagerTLOU.firstQueue = new QueueTLOU(1);
        ManagerTLOU.secondQueue = new QueueTLOU(2);
        ManagerTLOU.thirdQueue = new QueueTLOU(3);
        ManagerTLOU.backupQueue = new QueueTLOU(4);
        readJson();
    }
    
    @Override
    public void run() {
        while (!stop) {
            try {
                idCounter++;
                EpisodeTLOU episode = new EpisodeTLOU(idCounter);
                if (episode.getDuration() <= 59) {
                    thirdQueue.EnqueueNode(episode);
                } else if (episode.getDuration() >= 60 && episode.getDuration() <= 90) {
                    secondQueue.EnqueueNode(episode);
                } else if (episode.getDuration() > 90) {
                    firstQueue.EnqueueNode(episode);
                }
                updateQueuesLabels();
                writeJson();
                
                updateCounters(firstQueue);
                updateCounters(secondQueue);
                updateCounters(thirdQueue);
                
                Thread.sleep(10000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ManagerTLOU.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void updateQueuesLabels() {
        main.queue1TLOU.setText(firstQueue.PrintQueue());
        main.queue2TLOU.setText(secondQueue.PrintQueue());
        main.queue3TLOU.setText(thirdQueue.PrintQueue());
    }
    
    public void updateCounters(QueueTLOU queue) {
        for (int i = 0; i < queue.getSize(); i++) {
            EpisodeTLOU episodeAux = queue.Dequeue(); // Asignamos el aux al primer elemento de la cola
            episodeAux.setNext(null);
            if (queue.getNumber() == 1) {
                episodeAux.setCounter(episodeAux.getCounter() + 1);
                queue.EnqueueNode(episodeAux);

            } else {
                if (episodeAux.getCounter() >= 8) {
                    episodeAux.setCounter(0);
                    if (queue.getNumber() == 3) {
                        episodeAux.setPriority(2);
                        secondQueue.EnqueueNode(episodeAux); // Sube la prioridad del elemento
                    } else if (queue.getNumber() == 2) {
                        episodeAux.setPriority(1);
                        firstQueue.EnqueueNode(episodeAux); // Sube la prioridad del elemento
                    }
                } else {
                    episodeAux.setCounter(episodeAux.getCounter() + 1);
                    queue.EnqueueNode(episodeAux);
                }
            }
            updateQueuesLabels();
        }
    }
    
    public static void readJson() {

        JSONParser parser = new JSONParser();

        try ( Reader reader = new FileReader("src/Assets/dataTLOU.json")) {
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
        
       try ( FileWriter file = new FileWriter("src/Assets/dataTLOU.json")) {
            file.write(object.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
    }
    
    
    
}
