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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
/**
 *
 * @author user
 */
public class AlgoritmaGenetika implements Comparator<Langkah1>{
    public static void main(String[] args) throws IOException {
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

    }
    
    public void go() throws FileNotFoundException, IOException{
        String thisLine2D;
        BufferedReader bufRdr2D
            = new BufferedReader(
                    new FileReader("data/problem_100_vessels_1.txt"));

        ArrayList<String[]> lines = new ArrayList<String[]>();
        int file_length=0;
        int start_point=141;
        while ((thisLine2D = bufRdr2D.readLine()) != null) {
            lines.add(thisLine2D.split(","));
            file_length++;
        }
//        System.out.println(file_length);
        String[][] array = new String[lines.size()][0];      
        lines.toArray(array);
        
        //INISIALISASI ARRAY
        int [][] Ships = new int[file_length-start_point][12];
        
        //SPLIT ARRAY & CONVERT TO INT (index pertama = arrival time)
        for (int i = 0; i<Ships.length; i++) {
                String [] temp = array[i+start_point][0].split("\\s");
                for (int j=0;j<Ships[0].length;j++) {
                    if (j==0) {
                        Ships[i][j]=(int)Double.parseDouble(temp[j+5]); }
                    else
                        Ships[i][j]=Integer.parseInt(temp[j+9]); 
                }
        }    
        
        
//        for (int [] s:Ships) {
//            Arrays.stream(s).forEach(n -> System.out.print(n+" "));
//            System.out.print("\n");
//        }
        //MENGUBAH DARI ARRAY STRING KE ARRAY DOOUBLE UNTUK DI SORT
        
        //HASIL SHORT BY ARRIVAL TIME
//        System.out.println("jeda");
        
        List<Berth> berth_data = new ArrayList<>();
        for (int i=0;i<Ships[0].length;i++)
            berth_data.add(new Berth(i));
                    
        List<Ship> ships_data = new ArrayList<>();
        for (int i=0;i<Ships.length;i++) 
            ships_data.add(new Ship(i, Ships[i][0]));
        
        List<ShipBerth> shipberth_data = new ArrayList<>();
        int len = ships_data.size();
        for (int i=0;i<len;i++) {
            for (int j=1;j<Ships[0].length;j++) {
                shipberth_data.add(new ShipBerth(ships_data.get(i), berth_data.get(j-1), Ships[i][j]));
            }
        }
        
        //filter berth yang incompatible
        shipberth_data = shipberth_data.stream()
                .filter(n -> n.getHandlingTime()!=0)
                .collect(Collectors.toList());
        //masukin data berth ke kapal
        for (ShipBerth sb : shipberth_data) 
            sb.getShip().addPossibleBerth(sb);
        
        //sort berth-berth dikapal berdasarkan waiting time
        for (Ship ship : ships_data) {
            ship.sortPossibleBerth();
        }
//        for (Ship ship : ships_data) {
//            ship.getPossibleBerth().forEach(n -> System.out.print(n.getBerth().getNumber()+" "));
//            System.out.print("\n");
//        }
        //TEST
//        ships_data.forEach(n -> System.out.print(n.getNumber()+" "));
//        System.out.print("\n");
//        berth_data.forEach(n -> System.out.print(n.getNumber()+" "));
//        System.out.print("\n");
//        shipberth_data.forEach(n -> System.out.println(n.getShip().getNumber()+" "+n.getBerth().getNumber()+" "+n.getHandlingTime()));
//        System.out.print("\n");
        
        //buat peta ship berdasarkan arrival time
        Map <Integer, List<Ship>> ship_arrival = new HashMap<>();
        int last_arrival=0;
            // cari kedatangan terakhir
        for (Ship ship:ships_data)
            last_arrival = (last_arrival<ship.getArrivalTime())?ship.getArrivalTime():last_arrival;
        
        for (int i=0; i<=last_arrival;i++) {
            List<Ship> shipss = new ArrayList<>();
            for (Ship ship:ships_data) {
                if (ship.getArrivalTime()==i) 
                    shipss.add(ship);
            }
//            shipss.forEach(n -> System.out.print(n.getNumber()+" "));
//            System.out.print("\n");
            if (shipss.size()>0) {
                Collections.sort(shipss, (s1,s2) -> s1.getPossibleBerth().size()-s2.getPossibleBerth().size());
                ship_arrival.put(i, shipss);
            }
        }
        
//        ship_arrival.entrySet().forEach(v -> {
//            System.out.print(v.getKey()+" ");
//            v.getValue().forEach(n -> System.out.print(n.getNumber()+" "));
//            System.out.print("\n");
//        });
        
        //generate initial solution
        Set<Ship> currently_berthing_ship = new HashSet<>();
        Set<Ship> newly_berthing_ship = new HashSet<>();
        Set<Ship> waiting_ship = new HashSet<>();
        Set<Ship> departed_ship = new HashSet<>();
        Map <Integer, List<Ship>> solution = new LinkedHashMap<>();
        for (int i=0;i<=last_arrival;i++) {
            int current_date = i;
            if (i>0) {
                currently_berthing_ship.forEach(s -> {
                    if (s.getFinalBerth().getHandlingTime()+s.getArrivalTime()+ s.getWaitingTIme() == current_date) {
                        s.getFinalBerth().getBerth().setStatus(Berth.Status.EMPTY);
                        departed_ship.add(s);
                    }
                    else {
                        if (!solution.containsKey(current_date)) {
                            List<Ship> sbe = new ArrayList<>();
                            sbe.add(s);
                            solution.put(current_date, sbe);
                        }
                        else {
                            solution.get(current_date).add(s); 
                        }
                    }
                });
                currently_berthing_ship.removeAll(departed_ship);
                departed_ship.clear();
                
                if (waiting_ship.size()>0) {
                    if (!ship_arrival.containsKey(current_date)) {
                        ship_arrival.put(current_date, new ArrayList<Ship>(waiting_ship));
                    }
                    else {
                        ship_arrival.get(current_date).addAll(waiting_ship);
                        Collections.sort(ship_arrival.get(current_date), new WaitingTimeComparator()
                                .thenComparing(new PossibleBerthComparator()));
                    }
                    waiting_ship.clear();
                }
                
            }
            
            
            ship_arrival.entrySet().stream()
                    .filter(n -> n.getKey()==current_date)
                    .forEach(v -> {
                        v.getValue().forEach(k -> {
                            List<ShipBerth> lb = k.getPossibleBerth();
                            int possible_berth_amount = lb.size();
                            for (int j=0;j<possible_berth_amount;j++) {
                                Berth be = lb.get(j).getBerth();
                                if (be.getStatus() == Berth.Status.EMPTY) {
                                    k.setFinalBerth(lb.get(j));
                                    be.setStatus(Berth.Status.OCCUPIED);

                                    if (!solution.containsKey(current_date)) {
                                        List<Ship> sbe = new ArrayList<>();
                                        sbe.add(k);
                                        solution.put(current_date, sbe);
                                    }
                                    else {
                                        solution.get(current_date).add(k); 
                                    }
                                    newly_berthing_ship.add(k);
                                    break;
                                }
                                else if (j==possible_berth_amount-1) {
                                    k.increaseWaitingTime();
                                    waiting_ship.add(k);
                                    
                                }
                            }
                        });
                    });
            currently_berthing_ship.addAll(newly_berthing_ship);
            newly_berthing_ship.clear();
        }
        
        solution.entrySet().forEach(v -> {
            System.out.print(v.getKey()+": ");
            v.getValue().forEach(ship -> {
                System.out.print("("+ship.getNumber()+" "+ship.getFinalBerth().getBerth().getNumber()+" "+ship.getWaitingTIme()+") ");
            });
            System.out.print("\n");
        });
        
//            String value = v.getKey()+": ";
            
//            System.out.print(value+"\n");
//            });
        
        
//        Arrays.sort(Ships, (int [] s1, int [] s2) -> s1[0]-s2[0]);
//        for (int [] s:Ships) {
//            Arrays.stream(s).forEach(n -> System.out.print(n+" "));
//            System.out.print("\n");
//        }
//        
//        Langkah1 [][] ship_port = new Langkah1[file_length-start_point][11];
//        for (int i=0;i<Ships.length;i++) {
//            for (int j=1;j<Ships[0].length;j++) {
//                ship_port[i][j-1] = new Langkah1(Ships[i][0],Ships[i][j], j-1, i);
//            }
//        }
//       
//        for (int i=0;i<ship_port.length;i++) {
//            Arrays.sort(ship_port[i], (port1, port2) -> compare(port1, port2));
//        }
//        for (int i=0;i<ship_port.length;i++) {
//            Arrays.stream(ship_port[i]).forEach(n -> System.out.print(n.getPort()+" "));
//            System.out.print("\n");
//        }
//        System.out.print("jeda lagi \n");
//        List <List<Langkah1>> ship_priority = new ArrayList<>();
//        
//        for (int i=0;i<ship_port.length;i++) {  
//            List<Langkah1> prio_temp = new ArrayList<>();
//            for (int j=0;j<ship_port[0].length;j++) {
//                if (ship_port[i][j].getHandlingTime()!=0) {
//                    prio_temp.add(ship_port[i][j]); 
//                }
//            }
//            ship_priority.add(prio_temp);
//        }
//        
//
//        for (int i=0;i<ship_priority.size();i++) {
//            System.out.print(i+": ");
//            ship_priority.get(i).forEach(n -> System.out.print(n.getPort()+" "));
//            System.out.print("\n");
//        }
//
//        System.out.print("\n");
////        Langkah1 [] initial_sol = new Langkah1[Ships.length];
////        for (int i=0;i<initial_sol.length;i++) {
////            loop:for (int j=0;j<ship_priority.get(i).size();j++) {
////                initial_sol[i]=ship_priority.get(i).get(j); 
////                if (i>0) {
////                    for (int k=0;k<i;k++) {
////                        if (initial_sol[k].getPort()==initial_sol[i].getPort()) {
////                            if (initial_sol[k].getArrivalTime()+initial_sol[k].getHandlingTime()>initial_sol[i].getArrivalTime()) 
////                                break;
////                        }
////                        if (k==i-1) { 
////                            break loop;
////                        }
////                    }
////                }
////                else
////                    break;
////            }
////        }
////        Arrays.stream(initial_sol).forEach(n -> System.out.print(n.getPort()+" "));
////        System.out.print("\n"+initial_sol.length);
////        System.out.print("\n"+checkFeasibility(initial_sol, 295));
//        int last_arrival = 0;
//        for (Langkah1 [] ship:ship_port) {
//            last_arrival = (last_arrival < ship[0].getArrivalTime())?ship[0].getArrivalTime():last_arrival;
//        }
//
//        
//        
//        
//
//        System.out.print("\n");
        System.out.println("Feasible?: "+checkFeasibility(ships_data, last_arrival));
    }   
    
    private boolean checkFeasibility(List<Ship> ship_data, int length) {
        boolean val;
        int [] berth_occupancy = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        for (int i=0;i<=length;i++) {
            System.out.println(i);
            for (Ship ship:ship_data)  {
                int real_arrival_time = ship.getArrivalTime()+ship.getWaitingTIme();
                if (real_arrival_time == i) {
                    berth_occupancy[ship.getFinalBerth().getBerth().getNumber()]++;
                }
                if (real_arrival_time + ship.getFinalBerth().getHandlingTime() == i) {
                    berth_occupancy[ship.getFinalBerth().getBerth().getNumber()]--;
                }
            }
//            Arrays.stream(berth_occupancy).forEach(System.out::print);
            int len = berth_occupancy.length;
            for (int bool:berth_occupancy) {
                if (bool>1) {
                    return false;
                }
            }
        }
        return true;
    }
}

class WaitingTimeComparator implements Comparator<Ship> {

    @Override
    public int compare(Ship o1, Ship o2) {
       return o2.getWaitingTIme()-o1.getWaitingTIme();
    }
    
}
class PossibleBerthComparator implements Comparator<Ship> {

    @Override
    public int compare(Ship o1, Ship o2) {
       return o1.getPossibleBerth().size()-o2.getPossibleBerth().size();
    }
    
}





