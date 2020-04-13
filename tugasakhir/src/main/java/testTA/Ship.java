/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testTA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author user
 */
public class Ship {
    private final int number;
    private final int arrival_time;
    private int waiting_time;
    private ShipBerth berth;
    private List<ShipBerth> possible_berth = new ArrayList<>();
    
    
    public Ship(int number, int arrival_time) {
        this.number = number;
        this.arrival_time = arrival_time;
        waiting_time = 0;
    }
    
    public int getNumber(){
        return number;
    }
    public int getArrivalTime() {
        return arrival_time;
    }
    public ShipBerth getFinalBerth() {
        return berth;
    }
    public void setFinalBerth(ShipBerth berth) {
        this.berth = berth;
    }
    public List<ShipBerth> getPossibleBerth() {
        return possible_berth;
    }
    public void addPossibleBerth(ShipBerth sb) {
        possible_berth.add(sb);
    }
    public void sortPossibleBerth() {
        Collections.sort(possible_berth, (b1,b2) -> b1.getHandlingTime()-b2.getHandlingTime());
    }
    public int getWaitingTIme() {
        return waiting_time;
    }
    public void increaseWaitingTime() {
        this.waiting_time++;
    }
    
    
    
}
