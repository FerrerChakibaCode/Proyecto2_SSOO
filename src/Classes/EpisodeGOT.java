/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author emilo
 */
public class EpisodeGOT {
    private Integer id; // Identifidor unico de cada episodio
    private Integer counter; // Contador que al llegar a 8 escala la prioridad del episodio
    private Integer randomPower; // Por ahora este sera el comparador para ver quien gana la batalla, es un numero random que tengo que ver como generarlo
    
    public EpisodeGOT(Integer id, Integer counter) {
        this.id = id;
        this.counter = counter;
        this.randomPower = (int) Math.floor(Math.random() * 100);
    }

    public Integer getId() {
        return id;
    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getRandomPower() {
        return randomPower;
    }

    public void setRandomPower(Integer randomPower) {
        this.randomPower = randomPower;
    }
    
    
}
