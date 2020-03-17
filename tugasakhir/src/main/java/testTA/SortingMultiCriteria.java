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
public class SortingMultiCriteria {
    private double arrivalTime;
    private double handlingTime;
    /**
     * @return the arrivalTime
     */
    
    public SortingMultiCriteria(double arrivalTime, double handlingTime){
        this.arrivalTime = arrivalTime;
        this.handlingTime = handlingTime;
    }
    
    public double getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the handlingTime
     */
    public double getHandlingTime() {
        return handlingTime;
    }

    /**
     * @param handlingTime the handlingTime to set
     */
    public void setHandlingTime(double handlingTime) {
        this.handlingTime = handlingTime;
    }
    
}
