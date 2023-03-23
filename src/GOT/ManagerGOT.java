/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GOT;

import Interfaces.main;
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
public class ManagerGOT extends Thread {

    // Hacemos las 4 colas
    public static QueueGOT firstQueue;
    public static QueueGOT secondQueue;
    public static QueueGOT thirdQueue;
    public static QueueGOT strengthQueue;
    public static int idCounter;
    private boolean stop;

    public ManagerGOT() {
        readJson();
        loadQueuesGOT();
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                ProduceEpisode();
                updateCounters(firstQueue);
                updateCounters(secondQueue);
                updateCounters(thirdQueue);

                Thread.sleep(10000);

            } catch (InterruptedException ex) {
                Logger.getLogger(ManagerGOT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void loadQueuesGOT() {
        this.firstQueue = new QueueGOT(1);
        this.secondQueue = new QueueGOT(2);
        this.thirdQueue = new QueueGOT(3);
        this.strengthQueue = new QueueGOT(0);
    }

    public static void ProduceEpisode() {
        idCounter++;
        EpisodeGOT episode = new EpisodeGOT(idCounter);
        switch (episode.getPriority()) {
            case 1:
                firstQueue.enqueue(episode);
                break;
            case 2:
                secondQueue.enqueue(episode);
                break;
            case 3:
                thirdQueue.enqueue(episode);
                break;
        }
        updateQueuesLabels();
        writeJson();
    }

    public static void updateQueuesLabels() {
        System.out.println("1: " + firstQueue.printQueue());
        System.out.println("2: " + secondQueue.printQueue());
        System.out.println("3: " + thirdQueue.printQueue());
        main.queue1GOT.setText(firstQueue.printQueue());
        main.queue2GOT.setText(secondQueue.printQueue());
        main.queue3GOT.setText(thirdQueue.printQueue());
    }

    public void updateCounters(QueueGOT queue) {
        for (int i = 0; i < queue.getSize(); i++) {
            EpisodeGOT episodeAux = queue.dequeue(); // Asignamos el aux al primer elemento de la cola
            episodeAux.setNext(null);
            if (queue.getNumber() == 1) {
                episodeAux.setCounter(episodeAux.getCounter() + 1);
                queue.enqueue(episodeAux);

            } else {
                if (episodeAux.getCounter() >= 8) {
                    episodeAux.setCounter(0);
                    if (queue.getNumber() == 3) {
                        episodeAux.changePriority(2);
                        secondQueue.enqueue(episodeAux); // Sube la prioridad del elemento
                    } else if (queue.getNumber() == 2) {
                        episodeAux.changePriority(1);
                        firstQueue.enqueue(episodeAux); // Sube la prioridad del elemento
                    }
                } else {
                    episodeAux.setCounter(episodeAux.getCounter() + 1);
                    queue.enqueue(episodeAux);
                }
            }
            updateQueuesLabels();
        }
    }

    public void readJson() {

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