/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.GOT;

import Classes.Queue;
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

    public static EpisodeGOT firstEpisode = new EpisodeGOT(123123, 0);

    // Hacemos las 3 colas
    public static Queue<EpisodeGOT> firstQueue;
    public static Queue<EpisodeGOT> secondQueue;
    public static Queue<EpisodeGOT> thirdQueue;
    public static Queue<EpisodeGOT> strengthQueue;
    public static Integer IdCounter;

    public MainGOT() {
        loadQueues();
        loadManager(IdCounter);

    }

    public void loadQueues() {
        this.firstQueue = new Queue<EpisodeGOT>();
        this.secondQueue = new Queue<EpisodeGOT>();
        this.thirdQueue = new Queue<EpisodeGOT>();
        this.strengthQueue = new Queue<EpisodeGOT>();
    }

    public void loadManager(Integer counter) {
        ManagerGOT manager;
        try {
            manager = new ManagerGOT(firstQueue, secondQueue, thirdQueue, strengthQueue);
            manager.ProduceEpisode(firstQueue);
            manager.ProduceEpisode(firstQueue);
            manager.ProduceEpisode(firstQueue);
            EpisodeGOT[] arrayQueue1 = manager.GetNodes(firstQueue, 5);
            System.out.println(arrayQueue1[0].getId());
            System.out.println(arrayQueue1[1].getId());
        } catch (ParseException ex) {
            Logger.getLogger(MainGOT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
