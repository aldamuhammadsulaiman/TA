package taberth;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Heuristic {
    ArrayList<Ship> initsol;
    ArrayList<Ship> ilssol;
    ArrayList<Ship> gdsol;
    ArrayList<Ship> hilsol;
    ArrayList<Ship> ga_sol;
    long besttimer =0;
    long startimer=0;
    long endtimer=0;
    
    public Heuristic(ArrayList<Ship> initsol){
        this.initsol=initsol;
    }                         
    
    public void GA(){
        long starttimer = System.nanoTime();
        long endtimer =0;
        long besttimer=0; 
        Random rn = new Random();
        double rate = 0.001;
        double crossOveRate = 0.001;
        double mutationRate = 0.001;
        double elitism = 2;	
        int populationSize = 10;        
           
        /*ArrayList<Ship> popu0 = initsol;
        ArrayList<Ship> popu1 = initsol;
        ArrayList<Ship> popu2 = initsol;
        ArrayList<Ship> popu3 = initsol;
        ArrayList<Ship> popu4 = initsol;
        ArrayList<Ship> popu5 = initsol;
        ArrayList<Ship> popu6 = initsol;
        ArrayList<Ship> popu7 = initsol;
        ArrayList<Ship> popu8 = initsol;
        ArrayList<Ship> popu9 = initsol;
        ArrayList<Ship> popu10 = initsol;*/
        
        ArrayList<Ship> init = initsol;
        ArrayList<Ship> penalti = Util.cloneList(initsol);
            /*penalti.addAll(initsol);
            penalti.addAll(initsol);            
            penalti.addAll(initsol);
            penalti.addAll(initsol);
            penalti.addAll(initsol);
            penalti.addAll(initsol);
            penalti.addAll(initsol);
            penalti.addAll(initsol);
            penalti.addAll(initsol);
            penalti.addAll(initsol);*/
        int n =10;
        ArrayList<Ship> [] a= new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i]=new ArrayList<>(initsol);
        }
        
        int maxiteration = 10;
        double penalties=0;
        
        double[] penalty=new double[n];
        double initial = Util.cost(init);
        for (int i = 0; i < maxiteration; i++) {
                int numbCross=rn.nextInt(9); 
                switch(numbCross){
                                                                  
                    case(0):
                    do {
                      swapGA(a[0]);
                    } while (!Util.cekhc(a[0]));
                    break;
                    
                    case(1):
                    do {
                      swapGA(a[1]);
                    } while (!Util.cekhc(a[1]));
                    break;
                    
                    case(2):
                    do {
                      swapGA(a[2]);
                    } while (!Util.cekhc(a[2]));
                    break;
                    
                    case(3):
                    do {
                      swapGA(a[3]);
                    } while (!Util.cekhc(a[3]));
                    break;
                    
                    case(4):
                    do {
                      swapGA(a[4]);
                    } while (!Util.cekhc(a[4]));
                    break;
                    
                    case(5):
                    do {
                      swapGA(a[5]);
                    } while (!Util.cekhc(a[5]));
                    break;
                    
                    case(6):
                    do {
                      swapGA(a[6]);
                    } while (!Util.cekhc(a[6]));
                    break;
                    
                    case(7):
                    do {
                      swapGA(a[7]);
                    } while (!Util.cekhc(a[7]));
                    break;
                    
                    case(8):
                    do {
                      swapGA(a[8]);
                    } while (!Util.cekhc(a[8]));
                    break;
                    
                    case(9):
                    do {
                      swapGA(a[9]);
                    } while (!Util.cekhc(a[9]));
                    break;
                }
        }
        for (int i = 0; i < penalty.length; i++) {
            penalty[i]=Util.cost(a[i]);
        }
                      
        
        for (int i = 0; i < penalty.length; i++) {
            if(penalty[i]<initial){
                initial=penalty[i];
                init=Util.cloneList(a[i]);
            }
            
        }
        /*if(penalties < initial){
                initial = penalties;
                init = Util.cloneList(a[0]);
        }else{
                penalti = Util.cloneList(init);
        }*/
       
        /*for (int i = 0; i < maxiteration; i++) {
                int numbCross=rn.nextInt(1); 
                switch(numbCross){                     
                case(0):
                        do {
                          swapGA(penalti);
                        } while (!Util.cekhc(penalti));
                        break;
                }					

                penalties=Util.cost(penalti);                         
                if(penalties < initial){
                        initial = penalties;
                        init = Util.cloneList(penalti);
                }else{
                        penalti = Util.cloneList(init);
                }

        }*/
	
        this.ga_sol=Util.cloneList(init);
	System.out.println("cost heuristic adalah = "+initial);
	endtimer   = System.nanoTime();
	long totaltimer = endtimer - starttimer;
	this.startimer=starttimer;
	this.endtimer = endtimer;
	this.besttimer=besttimer;
        
        /*double penalty0 = Util.cost(popu0);
        double penalty1 = 0;        
        double penalty2 = 0; 
        double penalty3 = 0;
        double penalty4 = 0;
        double penalty5 = 0;
        double penalty6 = 0;
        double penalty7 = 0;
        double penalty8 = 0;
        double penalty9 = 0;
        double penalty10 = 0;
                
        for (int populationIndex = 0; populationIndex < populationSize; populationIndex++) {
                for (int i = 0; i < maxiteration; i++) {
                    int numbCross=rn.nextInt(9); 
                    
                    if (crossOveRate > Math.random() && populationIndex>=elitism){                 
                        switch(numbCross){
                        
                        //population 1                        
                        case(0):
                            do {
                                swapGA(popu1);
                            } while (!Util.cekhc(popu1));
                            break;                                

                        //population 2                           
                        case(1):
                            do {
                                swapGA(popu2);
                            } while (!Util.cekhc(popu2));
                            break;

                        //population 3                        
                        case(2):
                            do {
                                swapGA(popu3);
                            } while (!Util.cekhc(popu3));   
                            break;

                        //population 4                                        
                        case(3):
                            do {
                                swapGA(popu4);
                            } while (!Util.cekhc(popu4));   
                            break;

                        //population 5                                            
                        case(4):
                            do {
                                swapGA(popu5);
                            } while (!Util.cekhc(popu5));   
                            break;

                        //population 6                                                    
                        case(5):
                            do {
                                swapGA(popu6);
                            } while (!Util.cekhc(popu6));   
                            break;

                        //population 7                                            
                        case(6):
                            do {
                                swapGA(popu7);
                            } while (!Util.cekhc(popu7));   
                            break;

                        //population 8                                            
                        case(7):
                            do {
                                swapGA(popu8);
                            } while (!Util.cekhc(popu8));   
                            break;

                        //population 9                        
                        case(8):
                            do {
                                swapGA(popu9);
                            } while (!Util.cekhc(popu9));   
                            break;

                       }                        
                    }
                    
                    if (mutationRate > Math.random() && populationIndex>=elitism){
                        int numMutate=rn.nextInt(9);
                        switch(numMutate){
                            
                        case(0):
                            do {
                                shiftGA(popu1);
                            } while (!Util.cekhc(popu1));
                            break;

			case(1):
                            do {
                                shiftGA(popu2);
                            } while (!Util.cekhc(popu2));
                            break;

			case(2):
                            do {
                                shiftGA(popu3);
                            } while (!Util.cekhc(popu3));
                            break;

			case(3):
                            do {
                                shiftGA(popu4);
                            } while (!Util.cekhc(popu4));
                            break;

			case(4):
                            do {
                                shiftGA(popu5);
                            } while (!Util.cekhc(popu5));
                            break;

			case(5):
                            do {
                                shiftGA(popu6);
                            } while (!Util.cekhc(popu6));
                            break;

			case(6):
                            do {
                                shiftGA(popu7);
                            } while (!Util.cekhc(popu7));
                            break;

			case(7):
                            do {
                                shiftGA(popu8);
                            } while (!Util.cekhc(popu8));
                            break;	

			case(8):
                            do {
                                shiftGA(popu9);
                            } while (!Util.cekhc(popu9));
                            break;                           
                        }
                    }

                    penalty1=Util.cost(popu1);
                    penalty2=Util.cost(popu2);
                    penalty3=Util.cost(popu3);
                    penalty4=Util.cost(popu4);
                    penalty5=Util.cost(popu5);
                    penalty6=Util.cost(popu6);
                    penalty7=Util.cost(popu7);
                    penalty8=Util.cost(popu8);
                    penalty9=Util.cost(popu9);

                    //penalty 1 vs penalty 0
                    if(penalty1 < penalty0){
                        penalty0 = penalty1;
                        popu0 = Util.cloneList(popu1);
                    }else{
                        popu1 = Util.cloneList(popu0);
                    }

                    //penalty 2 vs penalty 0
                    if (penalty2 < penalty0){
                        penalty0 = penalty2;
                        popu0 = Util.cloneList(popu2);
                    }else{
                        popu2 = Util.cloneList(popu0);
                    }                          
                    //penalty 3 vs penalty 0    
                    if(penalty3 < penalty0){
                        penalty0 = penalty3;
                        popu0 = Util.cloneList(popu3);
                    }else{
                        popu3 = Util.cloneList(popu0);
                    }

                    //penalty 4 vs penalty 0
                    if(penalty4 < penalty0){
                        penalty0 = penalty4;
                        popu0 = Util.cloneList(popu4);
                    }else{
                        popu4 = Util.cloneList(popu0);
                    }

                    //penalty 5 vs penalty 0
                    if(penalty5 < penalty0){
                        penalty0 = penalty5;
                        popu0 = Util.cloneList(popu5);
                    }else{
                        popu5 = Util.cloneList(popu0);
                    }

                    //penalty 6 vs penalty 0
                    if(penalty6 < penalty0){
                        penalty0 = penalty6;
                        popu0 = Util.cloneList(popu6);
                    }else{
                        popu6 = Util.cloneList(popu0);
                    }

                    //penalty 7 vs penalty 0
                    if(penalty7 < penalty0){
                        penalty0 = penalty7;
                        popu0 = Util.cloneList(popu7);
                    }else{
                        popu7 = Util.cloneList(popu0);
                    }

                    //penalty 8 vs penalty 0
                    if(penalty8 < penalty0){
                        penalty0 = penalty8;
                        popu0 = Util.cloneList(popu8);
                    }else{
                        popu8 = Util.cloneList(popu0);
                    }

                    //penalty 9 vs penalty 0
                    if(penalty9 < penalty0){
                        penalty0 = penalty9;
                        popu0 = Util.cloneList(popu9);
                    }else{
                        popu9 = Util.cloneList(popu0);
                    }
                }
                
                //LOCAL SEARCH HILL CLIMBING
                ArrayList<Ship> locS = Util.cloneList(popu0);
                int costLocs=Util.cost(locS);

                for (int i = 0; i < maxiteration; i++) {
                    localSearch(locS);
                }
                penalty10=Util.cost(locS);

                if (penalty10 < penalty0) {
                    penalty0=penalty10;
                    popu0= Util.cloneList(locS);
                }else{
                    locS=Util.cloneList(popu0);
                }

                this.ga_sol=Util.cloneList(popu0);
                System.out.println("cost_ga_ke_:"+"_adalah = "+penalty0);
                System.out.println("cost local search "+ penalty10);
                endtimer   = System.nanoTime();
                long totaltimer = endtimer - starttimer;
                this.startimer=starttimer;
                this.endtimer = endtimer;
                this.besttimer=besttimer;
	}*/
    }
    
    public void shiftGA(ArrayList<Ship> ls){
        Random rn = new Random();
        int hi = 0;
        int angka = 0;
        int totalavailable=0;
        double rate = 0.001;
        
        double crossOveRate = 0.001;
        double elitism = 2;
//        Ship a = new Ship(ls.size());
        
                    Ship pick1 = ls.get(rn.nextInt(ls.size())); //pick shipp yang akan dishift
                    //pick random berth
                    //pick handling time di berth
                   //cek handling time yang gak nol, pick compatible berth only
                   do {
                       for (int i = 0; i < pick1.getProcessTimes().length; i++) {
                           if(pick1.getProcessTimes()[i]>0){
                               totalavailable++;
                           }
                       }
                       if (totalavailable>1) {
                           do {
                               angka = rn.nextInt(11);
                           } while (angka==pick1.getBerth());
                       }
                       if (totalavailable==1) {
                           angka = pick1.getBerth();
                       }
                       hi = pick1.getProcessTimes()[angka];
                   } while (hi==0);
                   pick1.setBerth(angka);

                   //compute ulang ti ri hi
                   countagain(ls);
    }
    
    public void countagain(ArrayList<Ship> listship){
        ArrayList<BerthTrans> listberth2 = new ArrayList<BerthTrans>();
        
        
        for (int i = 0; i < 11; i++) {
            BerthTrans berth2 = new BerthTrans(i);
            berth2.setReleasetime(0);
            berth2.setHandlingtime(0);
            listberth2.add(berth2);
        }
        
        //Sort ship by increasing arrival time
        listship.sort(Comparator.comparing(Ship::getArrival));
        
        //forloop
        for (int i = 0; i < listship.size(); i++) {
            //set handling time per ship
            Ship thisship = listship.get(i); //i
            for (int j = 0; j < listberth2.size(); j++) {
                listberth2.get(j).setHandlingtime(thisship.getProcessTimes()[j]);
            }
            for (int j = 0; j < listberth2.size(); j++) {
                if(thisship.getArrival()>=listberth2.get(j).getReleasetime())      //??????
                    listberth2.get(j).setReleasetime(0);
            }
            BerthTrans pilih = listberth2.get(thisship.getBerth());
            
            int ti = 0;
            int ri = 0;
            
            if(pilih.getReleasetime()>0){
                thisship.setCostWait(pilih.getReleasetime()-(int)thisship.getArrival());
                ti=pilih.getReleasetime();
            }
            if(pilih.getReleasetime()==0){
                ti=(int)thisship.getArrival();
            }  
            
            thisship.setTi(ti);

            ri = ti + pilih.getHandlingtime();
            
            thisship.setHi(pilih.getHandlingtime());
            thisship.setRi(ri);

            //UPDATE RELEASE TIME DI AKIR
            listberth2.get(pilih.getId()).setReleasetime(ri);
        }   
    }
    
    public void swapGA(ArrayList<Ship> listship){
        Random rn = new Random();
        int hi = 0;
        int angka1 = 0;
        int angka2 = 0;
        int berth1=0;
        int berth2=0;
        double crossOveRate = 0.001;
        double elitism = 2;
        Ship a = new Ship(listship.size());
        
                    do {
                        angka1 = rn.nextInt(listship.size()); //ngambil ship 1
                        angka2 = rn.nextInt(listship.size()); //ngambil ship 2
                        berth1 = listship.get(angka1).getProcessTimes()[listship.get(angka2).getBerth()];//hi ship 1 kalo ditaruh di tempatnya ship 2
                        berth2 = listship.get(angka2).getProcessTimes()[listship.get(angka1).getBerth()];//hi ship 2 kalo ditaruh di tempatnya ship 1
                    } while (berth1==0||berth2==0);
                        Ship pick1 = listship.get(angka2); //pick shipp yang akan diswap
                        Ship pick2 = listship.get(angka1); //pick shipp yang akan diswap

                    int berthtemp = 0;
                    berthtemp = pick1.getBerth();
                    pick1.setBerth(pick2.getBerth());
                    pick2.setBerth(berthtemp);
                    countagain(listship);     
    }
    
    public void localSearch (ArrayList<Ship> daftarkapal){
        Random rn = new Random();
        int hi = 0;
        int angka = 0;
        int totalavailable=0;
        double rate = 0.001;
       
        Ship pick1 = daftarkapal.get(rn.nextInt(daftarkapal.size())); 
        do {
            for (int i = 0; i < pick1.getProcessTimes().length; i++) {
                if(pick1.getProcessTimes()[i]>0){
                    totalavailable++;
                }
            }
            if (totalavailable>1) {
                do {
                    angka = rn.nextInt(11);
                } while (angka==pick1.getBerth());
            }
            if (totalavailable==1) {
                angka = pick1.getBerth();
            }
            hi = pick1.getProcessTimes()[angka];
        } while (hi==0);
        pick1.setBerth(angka);
        countagain(daftarkapal);
        
        
        int angka1 = 0;
        int angka2 = 0;
        int berth1=0;
        int berth2=0;
        do {
            angka1 = rn.nextInt(daftarkapal.size()); //ngambil ship 1
            angka2 = rn.nextInt(daftarkapal.size()); //ngambil ship 2
            berth1 = daftarkapal.get(angka1).getProcessTimes()[daftarkapal.get(angka2).getBerth()];//hi ship 1 kalo ditaruh di tempatnya ship 2
            berth2 = daftarkapal.get(angka2).getProcessTimes()[daftarkapal.get(angka1).getBerth()];//hi ship 2 kalo ditaruh di tempatnya ship 1
        } while (berth1==0||berth2==0);
        Ship pick3 = daftarkapal.get(angka2); //pick shipp yang akan diswap
        Ship pick4 = daftarkapal.get(angka1); //pick shipp yang akan diswap
        int berthtemp = 0;
        berthtemp = pick1.getBerth();
        pick3.setBerth(pick4.getBerth());
        pick4.setBerth(berthtemp);
        //compute ulang ti ri hi
        countagain(daftarkapal);
    }   
}

    
    

