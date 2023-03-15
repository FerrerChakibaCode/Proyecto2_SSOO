/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.GOT;

import static Classes.GOT.MainGOT.IdCounter;
import Classes.Queue;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import javax.swing.JLabel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author emilo
 */
public class ManagerGOT extends Thread{
    // Hacemos las 3 colas
    public static Queue<EpisodeGOT> firstQueue;
    public static Queue<EpisodeGOT> secondQueue;
    public static Queue<EpisodeGOT> thirdQueue;
    public static Queue<EpisodeGOT> strengthQueue;
    public static int idCounter;
    private boolean stop;

    public ManagerGOT(Queue<EpisodeGOT> firstQueue, Queue<EpisodeGOT> secondQueue, Queue<EpisodeGOT> thirdQueue, Queue<EpisodeGOT> strengthQueue) throws ParseException {
        this.firstQueue = firstQueue;
        this.secondQueue = secondQueue;
        this.thirdQueue = thirdQueue;
        this.strengthQueue = strengthQueue;
        readJson();
    }
    
    @Override
    public void run() {
        while (!stop) {
            
        }
    }
    
    public static void ProduceEpisode(Queue queue) {
        idCounter++;
        EpisodeGOT episode = new EpisodeGOT(idCounter, 0);
        queue.enqueue(episode);
        writeJson();
        
    }
    
    public static EpisodeGOT[] GetNodes(Queue<EpisodeGOT> queue, int amount) {
        int max = 0;
        EpisodeGOT[] arr = new EpisodeGOT[amount];
        for (int i = 0; i < queue.getSize(); i++) {
            if (max == amount) {
                EpisodeGOT aux = queue.dequeue();
                queue.enqueue(aux);
            } 
            else {
                 arr[i] = queue.dequeue();
                 queue.enqueue(arr[i]);
                 max++;
            }
        }
        return arr;
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
