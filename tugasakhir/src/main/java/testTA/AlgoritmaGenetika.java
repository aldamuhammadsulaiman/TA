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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author user
 */
public class AlgoritmaGenetika implements Comparator<Langkah1>{
    public static void main(String[] args) throws IOException {
//        ArrayList<Langkah1> langkah1 = new ArrayList<Langkah1>();
       new AlgoritmaGenetika().go();
    }
    
    @Override
    public int compare(Langkah1 o1, Langkah1 o2) {
        if (o1.getHandlingTime()>o2.getHandlingTime()) {
            return 1;
        }
        else if (o1.getHandlingTime()==o2.getHandlingTime()) {
            return 0;
        }
        else
            return -1;
//        return o1.getHandlingTime()-o2.getHandlingTime();
    }
    
    public void go() throws FileNotFoundException, IOException{
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
        int [][] Ships = new int[10][12];
        
        //SPLIT ARRAY & CONVERT TO INT (index pertama = arrival time)
        for (int i = 0; i<Ships.length; i++) {
                String [] temp = array[i+141][0].split("\\s");
                for (int j=0;j<Ships[0].length;j++) {
//                    System.out.print(temp.length);
                    if (j==0) {
                        Ships[i][j]=(int)Double.parseDouble(temp[j+5]); }
                    else
                        Ships[i][j]=Integer.parseInt(temp[j+9]); 
                }
        }    
        
        for (int [] s:Ships) {
            Arrays.stream(s).forEach(n -> System.out.print(n+" "));
            System.out.print("\n");
        }
        //MENGUBAH DARI ARRAY STRING KE ARRAY DOOUBLE UNTUK DI SHORT
        
        //HASIL SHORT BY ARRIVAL TIME
        System.out.println("jeda");
        Arrays.sort(Ships, (int [] s1, int [] s2) -> s1[0]-s2[0]);
        for (int [] s:Ships) {
            Arrays.stream(s).forEach(n -> System.out.print(n+" "));
            System.out.print("\n");
        }
        
        //SORT BY COST (ARRIVAL  TIME DIBUANG)
//        int [][] cost_val = new int [10][11];
//        for (int i=0;i<Ships.length;i++) {
//            for (int j=1;j<Ships[0].length;j++) {
//                cost_val[i][j-1]=Ships[i][j];
//            }
//        }
        Langkah1 [][] ship_port = new Langkah1[10][11];
        for (int i=0;i<Ships.length;i++) {
            for (int j=1;j<Ships[0].length;j++) {
                ship_port[i][j-1] = new Langkah1(Ships[i][0],Ships[i][j], j-1);
            }
        }
        
//        Arrays.stream(ship_port[0]).forEach(n -> System.out.println(n.getPort()));
        for (int i=0;i<ship_port.length;i++) {
            Arrays.sort(ship_port[i], (port1, port2) -> compare(port1, port2));
        }
        for (int i=0;i<ship_port.length;i++) {
            Arrays.stream(ship_port[i]).forEach(n -> System.out.print(n.getPort()+" "));
            System.out.print("\n");
        }
        System.out.print("jeda lagi \n");
        List <List<Langkah1>> ship_priority = new ArrayList<>();
        
        for (int i=0;i<ship_port.length;i++) {  
            List<Langkah1> prio_temp = new ArrayList<>();
            for (int j=0;j<ship_port[0].length;j++) {
                if (ship_port[i][j].getHandlingTime()!=0) {
                    prio_temp.add(ship_port[i][j]); 
                }
            }
            ship_priority.add(prio_temp);
        }
        
//        System.out.print(ship_priority.get(0).get(1).getPort());
        for (int i=0;i<ship_priority.size();i++) {
            ship_priority.get(i).forEach(n -> System.out.print(n.getPort()+" "));
            System.out.print("\n");
        }
//        System.out.print(ship_priority.get(9).get(0).getArrivalTime());
        System.out.print("\n");
        Langkah1 [] initial_sol = new Langkah1[Ships.length];
        for (int i=0;i<initial_sol.length;i++) {
            loop:for (int j=0;j<ship_priority.get(i).size();j++) {
                initial_sol[i]=ship_priority.get(i).get(j); 
                if (i>0) {
                    for (int k=0;k<i;k++) {
                        if (initial_sol[k].getPort()==initial_sol[i].getPort()) {
                            if (initial_sol[k].getArrivalTime()+initial_sol[k].getHandlingTime()>initial_sol[i].getArrivalTime()) 
                                break;
                        }
                        if (k==i-1) { 
                            break loop;
                        }
                    }
                }
                else
                    break;
            }
        }
        Arrays.stream(initial_sol).forEach(n -> System.out.print(n.getPort()+" "));
        
//        double a;
//        double b;
//        double [] arrival = new double[10]; 
////        for (int i = 0; i < arrival.length; i++) {
////            arrival[i]=Double.parseDouble(Ships[i][6]);
////        }
//        //MENGURUTKAN HASIL DARI PARSE DOUBLE
//        Arrays.sort(arrival);
//        
//        //MENCETAK ARRAY
//        for (int i = 0; i < arrival.length; i++) {
//            System.out.println("sort arrival "+arrival[i]);
//        }
        
        //INISIALISASI ARRAY UNTUK SHORT BERTH BERDASARKAN ARRIVAL
//        Double[][] ship0 = new Double[10][11];
//        l1:for (int i = 0; i < Ships.length; i++) {
//            for (int j = 0; j<Ships[0].length;i++) {
//                if (i==0) { continue; }
//                try {
//                    ship0[i-1][j] = Double.parseDouble(Ships[i][j+11]);
//                }
//                catch (Exception e) { }
////                System.out.println("sort ship "+ship0[i]);
//            }
//        }
//        for (Double [] s:ship0) {
//            Arrays.stream(s).forEach(n -> System.out.print(n.toString()));
//            System.out.print("\n");
//        }
//        Arrays.stream(ship0).forEach(n -> System.out.print(n));
//        System.out.print("\n");
////        Arrays.sort(ship0, (s1, s2) -> Double.compare(s1, s2));
//        Arrays.stream(ship0).forEach(n -> System.out.print(n));
//        
        
//        Langkah1 [][] abc = 
//                new Langkah1[10][Ships.length];;

        
//        for (int i = 0; i < ship0.length; i++) {
//            abc[i]= new Langkah1(ship0[i], arrival[i]);
//        }
//        
//        int i=0;
//        for(Langkah1 temp: abc){
//           System.out.println("fruits " + ++i + " : " + temp.getArrivalTime()+ 
//                ", Quantity : " + temp.getHandlingTime());
//        }
//        
//        Collections.sort(langkah1, Langkah1Comparator);
        AlgoritmaGenetika d = new AlgoritmaGenetika();
//        System.out.println(d.compare(abc[0], abc[2]));
    }   
    
    
//    @Override
//    public int compare(Langkah1 o1, Langkah1 o2) {
////        int value1 = o1.arrivalTime.compareTo(o2.handlingTime);
////        if (value1 == 0) {
////            int value2 = o1.arrivalTime.compareTo(o2.arrivalTime);
////            if (value2 == 0) {
////                return o1.handlingTime.compareTo(o2.handlingTime);
////            } else {
////                return value2;
////            }
////        }
//        return Double.compare(o1.arrivalTime,o2.handlingTime);
//    }
}





