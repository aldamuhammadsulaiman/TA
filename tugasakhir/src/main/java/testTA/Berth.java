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
public class Berth {
    private final int number;
    private Status status;
    
    public enum Status {
        OCCUPIED, EMPTY;
    }
    
    public Berth(int number) {
        this.number = number;
        status = Status.EMPTY;
    }
    
    public int getNumber() {
        return number;
    }
    
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
    
    
}
