/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testTA;

/**
 *
 * @author user
 */
public class ShipBerth {
    private final Ship ship;
    private final Berth berth;
    private final int handling_time;
    
    public ShipBerth(Ship ship, Berth berth, int handling_time) {
        this.ship = ship;
        this.berth = berth;
        this.handling_time = handling_time;
    }
    
    public Ship getShip() {
        return ship;
    }
    public Berth getBerth() {
        return berth;
    }
    public int getHandlingTime() {
        return handling_time;
    }
}
