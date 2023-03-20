/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.GOT;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author emilo
 */
public class MainGOT {

    public static EpisodeGOT firstEpisode = new EpisodeGOT(123123);

    // Hacemos las 3 colas
    public static QueueGOT firstQueue;
    public static QueueGOT secondQueue;
    public static QueueGOT thirdQueue;
    public static QueueGOT strengthQueue;
    public static Integer IdCounter;

    public MainGOT() {
        loadQueues();
        loadManager(IdCounter);

    }

    public void loadQueues() {
        this.firstQueue = new QueueGOT(1);
        this.secondQueue = new QueueGOT(2);
        this.thirdQueue = new QueueGOT(3);
        this.strengthQueue = new QueueGOT(0);
    }

    public void loadManager(Integer counter) {
        ManagerGOT manager;
        try {
            manager = new ManagerGOT(firstQueue, secondQueue, thirdQueue, strengthQueue);
            manager.start();
        } catch (ParseException ex) {
            Logger.getLogger(MainGOT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
