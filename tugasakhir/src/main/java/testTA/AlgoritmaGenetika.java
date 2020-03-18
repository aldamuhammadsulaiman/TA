/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testTA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
/**
 *
 * @author user
 */
public class AlgoritmaGenetika implements Comparator<SortingMultiCriteria>{
    public static void main(String[] args) throws FileNotFoundException,
            IOException{
        String thisLine2D;
        BufferedReader bufRdr2D
            = new BufferedReader(
                    new FileReader("data/problem_10_vessels_1.txt"));

        ArrayList<String[]> lines = new ArrayList<String[]>();
        while ((thisLine2D = bufRdr2D.readLine()) != null) {
            lines.add(thisLine2D.split(","));
        }

        String[][] array = new String[lines.size()][0];      
        lines.toArray(array);
        
        //INISIALISASI ARRAY
        String[][] Ships = new String[11][11];
        
        //SPLIT ARRAY
        for (int i = 0; i<Ships.length; i++) {
                Ships[i] = array[i+140][0].split("\\s");
        }    
        
        //MENGUBAH DARI ARRAY STRING KE ARRAY DOOUBLE UNTUK DI SHORT
        
        double a;
        double b;
        double [] arrival = new double[10]; 
        for (int i = 0; i < arrival.length; i++) {
            arrival[i]=Double.parseDouble(Ships[i+1][6]);
        }
        //MENGURUTKAN HASIL DARI PARSE DOUBLE
        Arrays.sort(arrival);
        
        //MENCETAK ARRAY
        for (int i = 0; i < arrival.length; i++) {
            System.out.println("sort arrival "+arrival[i]);
        }
        
        //INISIALISASI ARRAY UNTUK SHORT BERTH BERDASARKAN ARRIVAL
        double[] ship0 = new double[10];
        for (int i = 0; i < ship0.length; i++) {
            ship0[i] = Double.parseDouble(Ships[1][i+11]);
            System.out.println("sort ship "+ship0[i]);
        }
        
        SortingMultiCriteria [] sortingMultiCriteria = 
                new SortingMultiCriteria[0];
        
        SortingMultiCriteria [] abc = 
                new SortingMultiCriteria[10];;

        
        for (int i = 0; i < ship0.length; i++) {
            abc[i]= new SortingMultiCriteria(ship0[i], arrival[i]);
        }
        
        int i=0;
        for(SortingMultiCriteria temp: abc){
           System.out.println("fruits " + ++i + " : " + temp.getArrivalTime()+ 
                ", Quantity : " + temp.getHandlingTime());
        }
        
        AlgoritmaGenetika d = new AlgoritmaGenetika();
        System.out.println(d.compare(abc[0], abc[2]));
        
    }
    
    
    @Override
    public int compare(SortingMultiCriteria o1, SortingMultiCriteria o2) {
        int value1 = o1.arrivalTime.compareTo(o2.handlingTime);
        if (value1 == 0) {
            int value2 = o1.arrivalTime.compareTo(o2.arrivalTime);
            if (value2 == 0) {
                return o1.handlingTime.compareTo(o2.handlingTime);
            } else {
                return value2;
            }
        }
        return value1;
    }
}



