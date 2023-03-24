/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GOT;

import Classes.TLOU.EpisodeTLOU;
import Classes.TLOU.ManagerTLOU;
import Classes.TLOU.QueueTLOU;
import Interfaces.main;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author emilo
 */
public class AI extends Thread {

    // GOT
    public static ManagerGOT managerGOT;
    public static EpisodeGOT fighterGOT;
    public static QueueGOT firstQueueGOT;
    public static QueueGOT secondQueueGOT;
    public static QueueGOT thirdQueueGOT;
    public static QueueGOT strengthQueueGOT;
    public static int prevQueueGOT;

    // TLOU
    public static ManagerTLOU managerTLOU;
    public static EpisodeTLOU fighterTLOU;
    public static QueueTLOU firstQueueTLOU;
    public static QueueTLOU secondQueueTLOU;
    public static QueueTLOU thirdQueueTLOU;
    public static QueueTLOU backupQueueTLOU;
    public static int prevQueueTLOU;

    //Sobre el AI como tal
    public static int whoWon; // 1 for GOT, 0 for TLOU, -1 para empate
    private boolean stop;
    public static int cedulas = 3; // 9 + 10 enunciado

    public AI(ManagerGOT managerGOT, ManagerTLOU managerTLOU) {
        this.managerGOT = managerGOT;
        this.firstQueueGOT = managerGOT.firstQueue;
        this.secondQueueGOT = managerGOT.secondQueue;
        this.thirdQueueGOT = managerGOT.thirdQueue;
        this.strengthQueueGOT = managerGOT.strengthQueue;

        this.managerTLOU = managerTLOU;
        this.firstQueueTLOU = managerTLOU.firstQueue;
        this.secondQueueTLOU = managerTLOU.secondQueue;
        this.thirdQueueTLOU = managerTLOU.thirdQueue;
        this.backupQueueTLOU = managerTLOU.backupQueue;

        this.managerGOT.ProduceEpisode();
        this.managerGOT.ProduceEpisode();
        this.managerGOT.ProduceEpisode();
        this.managerGOT.ProduceEpisode();

        this.managerTLOU.ProduceEpisode();
        this.managerTLOU.ProduceEpisode();
        this.managerTLOU.ProduceEpisode();
        this.managerTLOU.ProduceEpisode();

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                getFighters();
                managerGOT.updateAllCounters();
                managerTLOU.updateAllCounters();
                Thread.sleep(cedulas * 1000);
                whichScenario();
                getFighters();
                managerGOT.updateAllCounters();
                managerTLOU.updateAllCounters();
                Thread.sleep(cedulas * 1000);
                whichScenario();
                managerGOT.ProduceEpisode();
                managerTLOU.ProduceEpisode();
            } catch (InterruptedException ex) {
                Logger.getLogger(AI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void getFighters() {
        if (!firstQueueGOT.isEmpty()) {
            fighterGOT = firstQueueGOT.dequeue();
        } else if (firstQueueGOT.isEmpty() && !secondQueueGOT.isEmpty()) {
            fighterGOT = secondQueueGOT.dequeue();
        } else if (secondQueueGOT.isEmpty() && !thirdQueueGOT.isEmpty()) {
            fighterGOT = thirdQueueGOT.dequeue();
        } else {
            fighterGOT = null;
        }

        if (!firstQueueTLOU.isEmpty()) {
            fighterTLOU = firstQueueTLOU.Dequeue();
            fighterTLOU.setPrevQueue(1);
        } else if (firstQueueTLOU.isEmpty() && !secondQueueTLOU.isEmpty()) {
            fighterTLOU = secondQueueTLOU.Dequeue();
            fighterTLOU.setPrevQueue(2);
        } else if (secondQueueTLOU.isEmpty() && !thirdQueueTLOU.isEmpty()) {
            fighterTLOU = thirdQueueTLOU.Dequeue();
            fighterTLOU.setPrevQueue(3);
        } else {
            fighterTLOU = null;
        }

        managerGOT.updateQueuesLabels();
        managerTLOU.updateQueuesLabels();

        printFighters();
    }

    /**
     * Calculates what will happen, either a fight, a draw, or if they both
     * should reinforce
     */
    public void whichScenario() {
        int odd = managerGOT.randomInt(0, 100);
        if (odd <= 40) {
            getWinner();
        }
        if (odd > 40 && odd <= 67) {
            draw();
        }
        if (odd > 67) {
            reinforceEpisodes();
        }
    }

    public void getWinner() { // NOTA: en verdad las batallas pueden NO ser por calidad, sino capaz agregar una funcion que tome la duracion y haga unos calculos locos
        if (fighterGOT != null && fighterTLOU != null) {

            if (fighterGOT.getQuality() == fighterTLOU.getQuality()) {
                int giveAdvantage = managerGOT.randomInt(0, 100);
                if (giveAdvantage > 50) {
                    fighterGOT.setQuality(fighterGOT.getQuality() + 1);
                } else {
                    fighterTLOU.setQuality(fighterTLOU.getQuality() + 1);
                }
            }
            whoWon = fighterGOT.getQuality() > fighterTLOU.getQuality() ? 1 : 0;
            if (whoWon == 1) {
                main.winner.setText("GOT");
            } else if (whoWon == 0) {
                main.winner.setText("The Last Of Us");
            }
            fighterGOT = null;
            fighterTLOU = null;
            printFighters();
        }
    }

    public void draw() {
        whoWon = -1;
        main.winner.setText("EMPATARON miloco");
    }

    public void reinforceEpisodes() {
        main.winner.setText("A reforzarse...");
        if (fighterGOT != null) {
            strengthQueueGOT.enqueue(fighterGOT);
            managerGOT.updateQueuesLabels();
        }

        if (fighterTLOU != null) {
            backupQueueTLOU.EnqueueNode(fighterTLOU);
            managerTLOU.updateQueuesLabels();
        }

    }

    public void printFighters() {
        //GOT
        if (fighterGOT != null) {
            main.idFighterGOT.setText(Integer.toString(fighterGOT.getId()));
            main.qualFighterGOT.setText(Integer.toString(fighterGOT.getQuality()));
        } else {
            main.idFighterGOT.setText("NO HAY FIGHTER");
            main.qualFighterGOT.setText("NO HAY CALIDAD");
        }
        if (fighterTLOU != null) {
            main.idFighterTLOU.setText(Integer.toString(fighterTLOU.getId()));
            main.qualFighterTLOU.setText(Integer.toString(fighterTLOU.getQuality()));
        } else {
            main.idFighterTLOU.setText("NO HAY FIGHTER");
            main.qualFighterTLOU.setText("NO HAY CALIDAD");
        }
    }

}
