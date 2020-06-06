/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testTA;

import java.util.Comparator;

/**
 *
 * @author user
 */
public class Langkah1 implements Comparator<Langkah1>{
    int port;
    int number;
    Integer arrivalTime;
    Integer handlingTime;
    /**
     * @return the arrivalTime
     */
    
    public Langkah1(Integer arrivalTime, Integer handlingTime, int port, int number){
        this.number = number;
        this.port = port;
        this.arrivalTime = arrivalTime;
        this.handlingTime = handlingTime;
    }
    
    public Integer getArrivalTime() {
        return arrivalTime;
    }
    
    public int getPort() {
        return port;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the handlingTime
     */
    public Integer getHandlingTime() {
        return handlingTime;
    }

    /**
     * @param handlingTime the handlingTime to set
     */
    public void setHandlingTime(Integer handlingTime) {
        this.handlingTime = handlingTime;
    }

    @Override
    public int compare(Langkah1 o1, Langkah1 o2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}