/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GOT;

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

    // TLOU
    public static ManagerGOT managerTLOU; // PONER AQUI LA CLASE DE MANAGERTLOU
    public static EpisodeGOT fighterTLOU; // PONER AQUI LA CLASE DE NICO CUANDO ESTE LISTO
    public static QueueGOT firstQueueTLOU;
    public static QueueGOT secondQueueTLOU;
    public static QueueGOT thirdQueueTLOU;
    public static QueueGOT strengthQueueTLOU;

    //Sobre el AI como tal
    public static int whoWon; // 1 for GOT, 0 for TLOU, -1 para empate
    private boolean stop;
    public static int cedulas = 10; // 9 Emilio + 10 enunciado

    public AI(ManagerGOT managerGOT, ManagerGOT managerTLOU) {
        this.managerGOT = managerGOT;
        this.firstQueueGOT = managerGOT.firstQueue;
        this.secondQueueGOT = managerGOT.secondQueue;
        this.thirdQueueGOT = managerGOT.thirdQueue;
        this.strengthQueueGOT = managerGOT.strengthQueue;

        this.managerTLOU = managerTLOU;
        this.firstQueueTLOU = managerTLOU.firstQueue;
        this.secondQueueGOT = managerTLOU.secondQueue;
        this.thirdQueueGOT = managerTLOU.thirdQueue;
        this.strengthQueueTLOU = managerTLOU.strengthQueue;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                managerGOT.ProduceEpisode();
                managerTLOU.ProduceEpisode();
                getFighters();
                Thread.sleep(cedulas * 1000);
                whichScenario();
                getFighters();
                Thread.sleep(cedulas * 1000);
                whichScenario();
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
            fighterGOT = null; // REVISAR
        }

        if (!firstQueueTLOU.isEmpty()) {
            fighterTLOU = firstQueueTLOU.dequeue();
        } else if (firstQueueTLOU.isEmpty() && !secondQueueTLOU.isEmpty()) {
            fighterTLOU = secondQueueTLOU.dequeue();
        } else if (secondQueueTLOU.isEmpty() && !thirdQueueTLOU.isEmpty()) {
            fighterTLOU = thirdQueueTLOU.dequeue();
        } else {
            fighterTLOU = null; // REVISAR
        }

        printFighters();
    }

    /**
     * Calculates what will happen, either a fight, a draw, or if they both
     * should reinforce
     */
    public void whichScenario() {
        int odd = randomInt(0, 100);
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
        if (fighterGOT.getQuality() == fighterTLOU.getQuality()) {
            int giveAdvantage = randomInt(0, 100);
            if (giveAdvantage > 50) {
                fighterGOT.setQuality(fighterGOT.getQuality() + 1);
            } else {
                fighterTLOU.setQuality(fighterTLOU.getQuality() + 1);
            }
        }
        whoWon = fighterGOT.getQuality() > fighterTLOU.getQuality() ? 1 : 0;
        if (whoWon == 1) {
            Interfaces.main.winner.setText("GOT");
        } else if (whoWon == 0) {
            main.winner.setText("The last of us");
        };

    }

    public void draw() {
        whoWon = -1;
        main.winner.setText("EMPATARON miloco");
    }

    public void reinforceEpisodes() {
        main.winner.setText("A reforzarse...");
    }

    public void printFighters() {
        //GOT
        if (fighterGOT != null) {
            main.idFighterGOT.setText(Integer.toString(fighterGOT.getId()));
            main.qualFighterGOT.setText(Integer.toString(fighterGOT.getQuality()));
        } else {
            main.idFighterGOT.setText("NO HAY FIGHTER");
            main.qualFighterGOT.setText("NO TIENE CALIDAD ALGUIEN QUE NO EXISTE");
        }
        if (fighterTLOU != null) {
            main.idFighterTLOU.setText(Integer.toString(fighterTLOU.getId()));
            main.qualFighterTLOU.setText(Integer.toString(fighterGOT.getQuality()));
        } else {
            main.idFighterTLOU.setText("NO HAY FIGHTER");
            main.qualFighterTLOU.setText("NO TIENE CALIDAD ALGUIEN QUE NO EXISTE");
        }
    }

    public int randomInt(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
