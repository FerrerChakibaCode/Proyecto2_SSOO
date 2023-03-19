/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.TLOU;

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

    public ManagerTLOU() throws ParseException {
        ManagerTLOU.firstQueue = new QueueTLOU();
        ManagerTLOU.secondQueue = new QueueTLOU();
        ManagerTLOU.thirdQueue = new QueueTLOU();
        ManagerTLOU.backupQueue = new QueueTLOU();
        readJson();
    }
    
    @Override
    public void run() {
        while (!stop) {
            idCounter++;
            EpisodeTLOU episode = new EpisodeTLOU(idCounter, 0);
            if (episode.getDuration() <= 59) {
                thirdQueue.Enqueue(idCounter, 0);
            } else if (episode.getDuration() >= 60 && episode.getDuration() <= 90) {
                secondQueue.Enqueue(idCounter, 0);
            } else if (episode.getDuration() > 90) {
                firstQueue.Enqueue(idCounter, 0);
            }
            writeJson();
        }
    }
    
    public static void readJson() throws ParseException {

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
