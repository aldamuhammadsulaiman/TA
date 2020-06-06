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
public class Langkah1Comparator implements Comparator<Langkah1>{

    @Override
    public int compare(Langkah1 o1, Langkah1 o2) {
        return o1.arrivalTime.compareTo(o2.handlingTime);
        
    }
    
}
