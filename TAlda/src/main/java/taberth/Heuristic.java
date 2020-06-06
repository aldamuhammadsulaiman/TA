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
        int costLS = 0;
        int costBest = 0;
        
        Random rn = new Random();
        int hi = 0;
        int angka = 0;
        int totalavailable=0;
        double rate = 0.001;
        
        double crossOveRate = 0.001;
        double mutationRate = 0.001;
        double elitism = 2;
	
        int populationSize = 10;
        
           
        ArrayList<Ship> popu0 = Util.cloneList(initsol);

        ArrayList<Ship> popu1 = Util.cloneList(initsol);
        ArrayList<Ship> popu2 = Util.cloneList(initsol);
        ArrayList<Ship> popu3 = Util.cloneList(initsol);
        ArrayList<Ship> popu4 = Util.cloneList(initsol);
        ArrayList<Ship> popu5 = Util.cloneList(initsol);
        ArrayList<Ship> popu6 = Util.cloneList(initsol);
        ArrayList<Ship> popu7 = Util.cloneList(initsol);
        ArrayList<Ship> popu8 = Util.cloneList(initsol);
        ArrayList<Ship> popu9 = Util.cloneList(initsol);
        ArrayList<Ship> popu10 = Util.cloneList(initsol);

//        Random rn = new Random();

        int maxiteration = 300;

        double penalty0 = Util.cost(popu0);
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
                
                 //hill climbing 1 cari local optima 1
                for (int i = 0; i < maxiteration; i++) {
                    int numbCross=rn.nextInt(9); //reinforcement learning ntar masi pake sr
                    
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
	}
        
        
        
    }
    public void ilsgd(){
        long starttimer = System.nanoTime();
        long endtimer =0;
        long besttimer=0;
        
        ArrayList<Ship> sbest = Util.cloneList(initsol);
        ArrayList<Ship> stemp = Util.cloneList(initsol);
        
        Random rn = new Random();
                
        int maxiteration = 100;
        
        double penalty1 = Util.cost(sbest);
        double penalty2 = 0;
        
        int cost1 = 0;
        int cost2 = 0;
        
        int costils = 0;
        int costgd = 0;
        int costbest = 0;
        
        int bbest = 0;
        
        
        double level = Util.cost(sbest);
        double decayrate = 1;
        
        //hill climbing 1 cari local optima 1
        for (int i = 0; i < maxiteration; i++) {
            int numb=rn.nextInt(1); //reinforcement learning ntar masi pake sr
            switch(numb){
                case(0):
                    do {
                        shift(stemp);
                    } while (!Util.cekhc(stemp));
                    break;
                case(1):
                    do {
                        swap(stemp);
                    } while (!Util.cekhc(stemp));
                    break;
                case(2):
                    do {
                try {
                    ruincreate(stemp);
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Heuristic.class.getName()).log(Level.SEVERE, null, ex);
                }
                    } while (!Util.cekhc(stemp));
                    break;
            }
            
            penalty2=Util.cost(stemp);
            if(penalty2 < penalty1){
                penalty1 = penalty2;
                sbest = Util.cloneList(stemp);
            }else{
                stemp = Util.cloneList(sbest);
            }
        }
        this.hilsol=Util.cloneList(sbest);
        
        System.out.println("");
        
        //local search pake great deluge pake local optima baru dan di ils
        ArrayList<Ship> perturb = Util.cloneList(sbest);
        ArrayList<Ship> bestperturb = Util.cloneList(sbest);
        costils = Util.cost(perturb);
        costbest = Util.cost(bestperturb);
        for (int i = 0; i < maxiteration; i++) {
            
        //perturb
            do {
                try {
                    ruincreate2(perturb);
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Heuristic.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (!Util.cekhc(perturb));
            
            ArrayList<Ship> sbestgd = Util.cloneList(perturb); //sbestnya gd
            ArrayList<Ship> stempgd = Util.cloneList(perturb); //stempnya gd
            ArrayList<Ship> bestest = Util.cloneList(perturb);
            bbest = Util.cost(bestest);
            cost1 = Util.cost(sbestgd);
            //great deluge
            for (int j = 0; j < maxiteration; j++) {
                int numb=rn.nextInt(1); //reinforcement learning ntar masi pake sr
                switch(numb){
                    case(0):
                        do {
                            shift(stempgd);
                        } while (!Util.cekhc(stempgd));
                        break;
                    case(1):
                        do {
                            swap(stempgd);
                        } while (!Util.cekhc(stempgd));
                        break;
                    case(2):
                        do {
                    try {
                        ruincreate(stempgd);
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(Heuristic.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        } while (!Util.cekhc(stempgd));
                        break;
                }
                
                //calculate cost
                cost2 = Util.cost(stempgd); //yang baru dishake

                //init level = cost terbaik
                //BEST OF THE BEBST
                
                //kalo improve, update best local solution and level
                if (cost2<cost1) {
                    cost1=cost2;
                    sbestgd = Util.cloneList(stempgd);
                    level = cost2;
                }else if (cost2<=level) {
                    cost1=cost2;
                    sbestgd = Util.cloneList(stempgd);
                }else
                    stempgd = Util.cloneList(sbestgd);
                if (cost2<bbest) {
                    bbest=cost2;
                    bestest = Util.cloneList(stempgd);
                }
                //kalo ga improve, apakah kurang dari sama dengan level, kalo iya update bbest local
                level=level-decayrate;
            }
            costgd = Util.cost(bestest);
            //bandingkan hasil gd dan perturb awal
            if (costgd<costils) {
                costils=costgd;
                perturb = Util.cloneList(bestest);
            }
            if (costils<costbest) {
                costbest=costils;
                bestperturb=Util.cloneList(perturb);
                besttimer   = System.nanoTime();
            }
        }
        this.ilssol=Util.cloneList(bestperturb);
        System.out.println("cost hc "+penalty1);
        System.out.println("cost ilsgd "+costils);
        endtimer   = System.nanoTime();
        long totaltimer = endtimer - starttimer;
        this.startimer=starttimer;
        this.endtimer = endtimer;
        this.besttimer=besttimer;
        //acceptance criteria ils bandinginnya 
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
        /*for (int populationIndex = 0; populationIndex < ls.size(); populationIndex++) {
                if (crossOveRate > Math.random() && populationIndex>=elitism){*/
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
                /*}            
       }*/

    }
    
    public void shift(ArrayList<Ship> ls){
        Random rn = new Random();
        int hi = 0;
        int angka = 0;
        int totalavailable=0;
        double rate = 0.001;
       
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
        for (int populationIndex = 0; populationIndex < listship.size(); populationIndex++) {
                if (crossOveRate > Math.random() && populationIndex>=elitism){
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
        }
                
    }
    
    public void swap(ArrayList<Ship> listship){
        Random rn = new Random();
        int hi = 0;
        int angka1 = 0;
        int angka2 = 0;
        
         //pick random berth
         //pick handling time di berth
        //cek handling time yang gak nol, pick compatible berth only
        int berth1=0;
        int berth2=0;
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
        //compute ulang ti ri hi
        countagain(listship);
    }       
    
    public void ruincreate2(ArrayList<Ship> listship)throws CloneNotSupportedException{
        ArrayList<Berth> allberth = new ArrayList<Berth>();
        for (int i = 0; i < 11; i++) {
            Berth berth = new Berth(i);
            allberth.add(berth);
        }
        
        for (int i = 0; i < listship.size(); i++) {
            switch(listship.get(i).getBerth()){
                case(0):
                    allberth.get(0).getDaftarship().add(listship.get(i));
                    break;
                case(1):
                    allberth.get(1).getDaftarship().add(listship.get(i));
                    break;
                case(2):
                    allberth.get(2).getDaftarship().add(listship.get(i));
                    break;
                case(3):
                    allberth.get(3).getDaftarship().add(listship.get(i));
                    break;
                case(4):
                    allberth.get(4).getDaftarship().add(listship.get(i));
                    break;
                case(5):
                    allberth.get(5).getDaftarship().add(listship.get(i));
                    break;
                case(6):
                    allberth.get(6).getDaftarship().add(listship.get(i));
                    break;
                case(7):
                    allberth.get(7).getDaftarship().add(listship.get(i));
                    break;
                case(8):
                    allberth.get(8).getDaftarship().add(listship.get(i));
                    break;
                case(9):
                    allberth.get(9).getDaftarship().add(listship.get(i));
                    break;
                case(10):
                    allberth.get(10).getDaftarship().add(listship.get(i));
                    break;
            }
        }
        ArrayList<Ship> candidate = new ArrayList<>();
        //ruin
        Random rn = new Random();
        int ruinfactor = 10;
        do {
            int r = rn.nextInt(ruinfactor)+1; //random number jumlah vessel di berth
            for (int i = 0; i < r; i++) {
                //random pick berth
                int berth=0;
                int bounds = 0;
                do {
                    berth = rn.nextInt(11);
                    bounds = allberth.get(berth).getDaftarship().size();
                } while (bounds==0);
                    int shiprandom=0;
                    shiprandom = rn.nextInt(bounds); //random shhip nya
                    Ship pickedship = allberth.get(berth).getDaftarship().get(shiprandom);
                    if(!candidate.contains(pickedship)){
                        candidate.add(pickedship);
                    }
            }
            ruinfactor = ruinfactor - r;
        } while (ruinfactor>0);

        for (int i = 0; i < candidate.size(); i++) {
            allberth.get(candidate.get(i).getBerth()).getDaftarship().remove(candidate.get(i));
        }       
        ArrayList<Ship> outputan = new ArrayList<Ship>();
        candidate.sort(Comparator.comparing(Ship::getArrival));
        for (int i = 0; i < candidate.size(); i++) {
            //bikin listnya feasiblle per sip disini
            ArrayList<Ship> feasible = new ArrayList<Ship>();
            for (int j = 0; j < 11; j++) {
                ArrayList<Ship> isi = new ArrayList<Ship>();
                if (candidate.get(i).getProcessTimes()[j]>0) {
                    //berth yang compat aja
                    //list buat ngecek feasibblenya
                    for (int l = 0; l < allberth.get(j).getDaftarship().size(); l++) {
                        if (allberth.get(j).getDaftarship().size()>0) {
                            isi.add(allberth.get(j).getDaftarship().get(l));
                    }
                    }
                    Ship baru = (Ship)candidate.get(i).clone(); 
                    
                    baru.setBerth(j);
                    isi.add(baru);
                    countagain(isi);
                    if (Util.cekhc(isi)==true) {
                        baru.setHi(baru.getProcessTimes()[j]);
                        feasible.add(baru);
                    }
                }
            }
            feasible.sort(Comparator.comparing(Ship::getHi));
            if (feasible.size()<2) {
                outputan.add(feasible.get(0));
                allberth.get(feasible.get(0).getBerth()).getDaftarship().add(feasible.get(0));
            }else{
                outputan.add(feasible.get(1));
                allberth.get(feasible.get(1).getBerth()).getDaftarship().add(feasible.get(1));
            }
        }
        ArrayList<Ship> fix = new ArrayList<Ship>();
        for (int i = 0; i < allberth.size(); i++) {
            fix.addAll(allberth.get(i).getDaftarship());
        }
        fix.sort(Comparator.comparing(Ship::getArrival));
        countagain(fix);
        Util.cekhc(fix);
        listship.clear();
        listship.addAll(fix);
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
    
    public void ruincreate(ArrayList<Ship> listship) throws CloneNotSupportedException{
        HashMap<Integer, ArrayList<Ship>> map = new HashMap<>(); 
        ArrayList<Ship> new0 = new ArrayList<>();
        ArrayList<Ship> new1 = new ArrayList<>();
        ArrayList<Ship> new2 = new ArrayList<>();
        ArrayList<Ship> new3 = new ArrayList<>();
        ArrayList<Ship> new4 = new ArrayList<>();
        ArrayList<Ship> new5 = new ArrayList<>();
        ArrayList<Ship> new6 = new ArrayList<>();
        ArrayList<Ship> new7 = new ArrayList<>();
        ArrayList<Ship> new8 = new ArrayList<>();
        ArrayList<Ship> new9 = new ArrayList<>();
        ArrayList<Ship> new10 = new ArrayList<>();
        
        for (int i = 0; i < listship.size(); i++) {
            switch(listship.get(i).getBerth()){
                case(0):
                    new0.add(listship.get(i));
                    map.put(0, new0);
                    break;
                case(1):
                    new1.add(listship.get(i));
                    map.put(1, new1);
                    break;
                case(2):
                    new2.add(listship.get(i));
                    map.put(2, new2);break;
                case(3):
                    new3.add(listship.get(i));
                    map.put(3, new3);break;
                case(4):
                    new4.add(listship.get(i));
                    map.put(4, new4);break;
                case(5):
                    new5.add(listship.get(i));
                    map.put(5, new5);break;
                case(6):
                    new6.add(listship.get(i));
                    map.put(6, new6);break;
                case(7):
                    new7.add(listship.get(i));
                    map.put(7, new7);break;
                case(8):
                    new8.add(listship.get(i));
                    map.put(8, new8);break;
                case(9):
                    new9.add(listship.get(i));
                    map.put(9, new9);break;
                case(10):
                    new10.add(listship.get(i));
                    map.put(10, new10);break;
            }
        }
        ArrayList<Ship> candidate = new ArrayList<>();
        //ruin
        Random rn = new Random();
        int ruinfactor = 5;
        do {
            //random pick berth
            int berth = rn.nextInt(11);
//            int berth= 0;
            int r = rn.nextInt(ruinfactor)+1; //random number jumlah vessel di berth
            //r is limited to maximum nnumber in berth
            //pick r ship randomly di berth berth
            for (int i = 0; i < r; i++) {
                int shiprandom = rn.nextInt(map.get(berth).size()); //random shhip nya
                Ship pickedship = map.get(berth).get(shiprandom);
                if(!candidate.contains(pickedship)){
                    candidate.add(pickedship);
                }
                System.out.println("removed ="+pickedship.getShipId());
            }
            System.out.println("RUIN FACTOR NOW = "+ruinfactor+" r now "+r);
            ruinfactor = ruinfactor - r;
        } while (ruinfactor>0);
        for (int i = 0; i < candidate.size(); i++) {
            map.get(candidate.get(i).getBerth()).remove(candidate.get(i));
        }
        System.out.println("removed ship ");
        for (int i = 0; i < candidate.size(); i++) {
            System.out.println(i+". ship "+listship.get(candidate.get(i).getShipId()).getShipId()+" berth "+listship.get(candidate.get(i).getShipId()).getBerth());
        }
        
        System.out.println("size "+candidate.size());
        ArrayList<Ship> outputan = new ArrayList<Ship>();
        candidate.sort(Comparator.comparing(Ship::getArrival));
        for (int i = 0; i < candidate.size(); i++) {
            System.out.println("CANDIDATE "+i);
            //bikin listnya feasiblle per sip disini
            ArrayList<Ship> feasible = new ArrayList<Ship>();
            for (int j = 0; j < 11; j++) {
                ArrayList<Ship> isi = new ArrayList<Ship>();
                if (candidate.get(i).getProcessTimes()[j]>0) {
                    //berth yang compat aja
                    System.out.println("j="+ j);
                    //list buat ngecek feasibblenya
                    for (int l = 0; l < map.get(j).size(); l++) {
                        if (map.get(j).size()>0) {
                            isi.add(map.get(j).get(l));
                    }
                    }
                    Ship baru = (Ship)candidate.get(i).clone(); 
                    
                    baru.setBerth(j);
                    isi.add(baru);
                    countagain(isi);
                    if (Util.cekhc(isi)==true) {
                        baru.setHi(baru.getProcessTimes()[j]);
                        feasible.add(baru);
                    }
                    for (int k = 0; k < feasible.size(); k++) {
                        System.out.println("isi feasible "+feasible.get(k).getShipId());
                    }
                    
                }
            }
            for (int k = 0; k < feasible.size(); k++) {
                System.out.println("isi feasible last "+feasible.get(k).getShipId());
            }
//            sort list vessel by assignment cost
            feasible.sort(Comparator.comparing(Ship::getHi));
            System.out.println("feasible ship ");
            for (int z = 0; z < feasible.size(); z++) {
                System.out.println(z+". ship "+feasible.get(z).getShipId()+" beretnya "+feasible.get(z).getBerth()+" hi "+feasible.get(z).getHi());
            }
//            insert vessel ke yang slightly worst
            if (feasible.size()<2) {
                outputan.add(feasible.get(0));
                map.get(feasible.get(0).getBerth()).add(feasible.get(0));
            }else{
                outputan.add(feasible.get(1));
                map.get(feasible.get(1).getBerth()).add(feasible.get(1));
            }
        }
        System.out.println(" ");
        for (int k = 0; k < outputan.size(); k++) {
            System.out.println("isi outputan last "+outputan.get(k).getShipId());
        }
        
        
        
        System.out.println("");
        
        ArrayList<Ship> fix = new ArrayList<Ship>();
        for (int i = 0; i < map.size(); i++) {
            fix.addAll(map.get(i));
        }
        fix.sort(Comparator.comparing(Ship::getArrival));
        countagain(fix);
        for (int i = 0; i < fix.size(); i++) {
            System.out.println("Ship "+fix.get(i).getShipId()+" berth "+fix.get(i).getBerth()+" arrival "+fix.get(i).getArrival()+ " depart "+fix.get(i).getRi());
        }
        Util.cekhc(fix);
        System.out.println(fix.size());
        
        listship.clear();
        listship.addAll(fix);
    }

}

    
    

