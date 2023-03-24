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
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Nicolás Briceño
 */
public class ManagerTLOU extends Thread {

    // Hacemos las 3 colas
    public static QueueTLOU firstQueue;
    public static QueueTLOU secondQueue;
    public static QueueTLOU thirdQueue;
    public static QueueTLOU backupQueue;
    public static int idCounter;
    private static ArrayList<Integer> winners;
    public static boolean checkWin;
    public static int newWinner;
    private boolean stop;

    public ManagerTLOU() {
        ManagerTLOU.winners = new ArrayList<>();
        ManagerTLOU.checkWin = false;
        ManagerTLOU.firstQueue = new QueueTLOU(1);
        ManagerTLOU.secondQueue = new QueueTLOU(2);
        ManagerTLOU.thirdQueue = new QueueTLOU(3);
        ManagerTLOU.backupQueue = new QueueTLOU(4);
        readJson();
        ProduceEpisode();
    }

    @Override
    public void run() {
        while (!stop) {
            /*try {
                ProduceEpisode();
                Thread.sleep(10000);

            } catch (InterruptedException ex) {
                Logger.getLogger(ManagerTLOU.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }

    public static void ProduceEpisode() {
        int odd = getRandom(0, 100);
        if (odd <= 70) { // Probabilidad de 70% que se produzca un episodio
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
        }
    }

    public static void updateQueuesLabels() {
        main.queue1TLOU.setText(firstQueue.PrintQueue());
        main.queue2TLOU.setText(secondQueue.PrintQueue());
        main.queue3TLOU.setText(thirdQueue.PrintQueue());
    }

    public static void updateCounters(QueueTLOU queue) {
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
                        episodeAux.setPrevQueue(2);
                        secondQueue.EnqueueNode(episodeAux); // Sube la prioridad del elemento
                    } else if (queue.getNumber() == 2) {
                        episodeAux.setPriority(1);
                        episodeAux.setPrevQueue(1);
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

        try (Reader reader = new FileReader("src/Assets/dataTLOU.json")) {
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
        
        if (isCheckWin()) {
            System.out.println("Entre en WInners GOT");            
            winners.add(getNewWinner());
            JSONArray winList = new JSONArray();
            winList.add(winners);
            
            object.put("winners", winList);
        }
        
        try (FileWriter file = new FileWriter("src/Assets/dataTLOU.json")) {
            file.write(object.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*public static void writeWinnerJson(int newWinner) { //Para mandar los ganadores al JSON
        JSONArray winList = new JSONArray();
        winList.add(winners); //Agrega al JSONArray el array de ganadores
        winList.add(newWinner);
        
        JSONObject obj = new JSONObject();

        obj.put("counter", idCounter);
        obj.put("winners", winList);
        System.out.println(obj);
        try (FileWriter file = new FileWriter("src/Assets/dataTLOU.json")) {
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static int getRandom(int a, int b) {
        int c = (int) (Math.random() * (b - a + 1) + a);
        return c;
    }

    public static boolean isCheckWin() {
        return checkWin;
    }

    public static void setCheckWin(boolean checkWin) {
        ManagerTLOU.checkWin = checkWin;
    }

    public static int getNewWinner() {
        return newWinner;
    }

    public static void setNewWinner(int newWinner) {
        ManagerTLOU.newWinner = newWinner;
    }
}
