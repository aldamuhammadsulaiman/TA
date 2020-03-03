/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testTA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 *
 * @author user
 */
public class AlgoritmaGenetika {
    public static void main(String[] args) throws FileNotFoundException,
            IOException{
//        String[] fileName = {"week-problem_100_vessels_0.txt", 
//            "week-problem_100_vessels_1.txt", "week-problem_100_vessels_2.txt", 
//            "week-problem_100_vessels_3.txt", "week-problem_100_vessels_4.txt", 
//            "week-problem_100_vessels_5.txt", "week-problem_100_vessels_6.txt",
//            "week-problem_100_vessels_7.txt", "week-problem_100_vessels_8.txt", 
//            "week-problem_100_vessels_9.txt",
//            "week-problem_60_vessels_1.txt", "week-problem_60_vessels_2.txt",
//            "week-problem_70_vessels_0.txt", "week-problem_70_vessels_1.txt",
//            "week-problem_70_vessels_2.txt", "week-problem_70_vessels_9.txt",
//            "week-problem_80_vessels_0.txt", "week-problem_80_vessels_1.txt",
//            "week-problem_80_vessels_2.txt", "week-problem_80_vessels_3.txt",
//            "week-problem_80_vessels_4.txt", "week-problem_80_vessels_5.txt",
//            "week-problem_80_vessels_6.txt", "week-problem_80_vessels_7.txt",
//            "week-problem_80_vessels_8.txt", "week-problem_80_vessels_9.txt",
//            "week-problem_90_vessels_0.txt", "week-problem_90_vessels_1.txt",
//            "week-problem_90_vessels_2.txt", "week-problem_90_vessels_3.txt",
//            "week-problem_90_vessels_4.txt", "week-problem_90_vessels_5.txt",
//            "week-problem_90_vessels_6.txt", "week-problem_90_vessels_7.txt",
//            "week-problem_90_vessels_8.txt", "week-problem_90_vessels_9.txt"};
//        int instance = 33;
//        String sourceFile = fileName[instance-1];
//        Berth pelabuhan = new Berth(sourceFile);
//        Type = get.Typeclass;
         
         
         
//         Berth berth = new Berth();
         
        

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
        
        //Declare String
        
        
        
        String[][] Berth1 = new String[8][5];
        String[][] Berth1MaxDraft = new String[8][4];
        String[][] Berth2 = new String[2][5];
        String[][] Berth3 = new String[3][5];
        String[][] Berth4 = new String[3][5];
        String[][] Berth5 = new String[2][5];
        String[][] Berth6 = new String[2][5];
        String[][] Berth7 = new String[2][5];
        String[][] Berth8 = new String[2][5];
        String[][] Berth9 = new String[8][5];
        String[][] Berth10 = new String[3][5];
        
        String[][] DistanceOB = new String[11][11];
        String[][] DistanceAB = new String[11][11];
        
        String[][] SpesialRules = new String[22][8];
        
        String[][] Ships = new String[11][11];
        
        //Ambil Array sesuai kebutuhan
//        for (int i = 0; i<Berth1.length; i++) {
//                Berth1[i] = array[i+11][0].split("\\s");        
//                System.out.println("Berth 1 kolom Type berisi "+Berth1[i][0]);
//                
////                for (int j = 0; j < Berth1.length; j++) {
////                    System.out.println("Berth 1 kolom Max Draft berisi " + Berth1[i][j]);
////                }
//                System.out.println("Berth 1 kolom Max Draft berisi " + Berth1[i][1]);
//                System.out.println("Berth 1 kolom Max Length berisi " + Berth1[i][2]);
//                System.out.println("Berth 1 kolom Max Width berisi " + Berth1[i][3]);
//                System.out.println("Berth 1 kolom Max DWT berisi " + Berth1[i][4]);
//                
////                Berth1MaxDraft[i]= Berth1[i];
//                
////                for (int j = 0; j < Berth1MaxDraft.length; j++) {
////                Berth1MaxDraft[j] = array[j+11][0];
////            }
//        }
//        
        
        
        
        
//        for (int i = 0; i < Berth1MaxDraft.length; i++) {
//            Berth1MaxDraft[i] = array[i+11][0].split("\\s");
//            System.out.println("Berth 1 kolom Max Draft berisi" + Berth1MaxDraft[i][1]);
//        }
//        

//        for (int i = 0; i<Berth1.length; i++) {
//                Berth1[i] = array[i+11][0].split("\\s");
//                System.out.println("Berth 2 berisi"+Berth2[i][3]);
//        }
        
//        for (int i = 0; i<Berth2.length; i++) {
//                Berth2[i] = array[i+21][0].split("\\s");
//                System.out.println("Berth 2 berisi"+Berth2[i][3]);
//        }
//        for (int i = 0; i<Berth3.length; i++) {
//                Berth3[i] = array[i+25][0].split("\\s");
//        }
//        for (int i = 0; i<Berth4.length; i++) {
//                Berth4[i] = array[i+30][0].split("\\s");
//        }
//        for (int i = 0; i<Berth5.length; i++) {
//                Berth5[i] = array[i+35][0].split("\\s");
//        }
//        for (int i = 0; i<Berth6.length; i++) {
//                Berth6[i] = array[i+39][0].split("\\s");
//        }
//        for (int i = 0; i<Berth7.length; i++) {
//                Berth7[i] = array[i+43][0].split("\\s");
//        }
//        for (int i = 0; i<Berth8.length; i++) {
//                Berth8[i] = array[i+47][0].split("\\s");
//        }
//        for (int i = 0; i<Berth9.length; i++) {
//                Berth9[i] = array[i+51][0].split("\\s");
//        }
//        for (int i = 0; i<Berth10.length; i++) {
//                Berth10[i] = array[i+62][0].split("\\s");
//        }
//        
//        for (int i = 0; i<DistanceOB.length; i++) {
//                DistanceOB[i] = array[i+67][0].split("\\s");
//        }
//        for (int i = 0; i<DistanceAB.length; i++) {
//                DistanceAB[i] = array[i+80][0].split("\\s");
//        }
//        
//        for (int i = 0; i<SpesialRules.length; i++) {
//                SpesialRules[i] = array[i+96][0].split("\\s");
//        }
//        
        for (int i = 0; i<Ships.length; i++) {
                Ships[i] = array[i+140][0].split("\\s");
//                System.out.println("Berth 1 kolom Type berisi "+Ships[i][0]);
//                System.out.println("Berth 1 kolom Max Draft berisi " + Ships[i][1]);
//                System.out.println("Berth 1 kolom Max Length berisi " + Ships[i][2]);
//                System.out.println("Berth 1 kolom Max Width berisi " + Ships[i][3]);
//                System.out.println("Berth 1 kolom Max DWT berisi " + Ships[i][4]);
        }
//        
        System.out.println(Ships[1][0]);
        
//        String[][]pelabuhan = new String[100][100];
//        
//        for(int i = 0; i < Berth1.length; i++){
//            pelabuhan [i] = Berth1[i];
//            System.out.println(pelabuhan[i][3]);
//        }
        
       
        
        /*
        //Test Print
        for (int i = 0; i < Berth1.length; i++) {
            System.out.println("Berth 1 berisi "+Berth1[i][1].toString());            
        }
        for (int i = 0; i < Berth2.length; i++) {
            System.out.println("Berth 2 berisi " +Berth2[i][1].toString());
        }
        for (int i = 0; i < Berth3.length; i++) {
            System.out.println("Berth 3 berisi " +Berth3[i][1].toString());
        }
        for (int i = 0; i < Berth4.length; i++) {
            System.out.println("Berth 4 berisi " +Berth4[i][1].toString());
        }
        for (int i = 0; i < Berth5.length; i++) {
            System.out.println("Berth 5 berisi " +Berth5[i][1].toString());
        }
        for (int i = 0; i < Berth6.length; i++) {
            System.out.println("Berth 6 berisi " +Berth6[i][1].toString());
        }
        for (int i = 0; i < Berth7.length; i++) {
            System.out.println("Berth 7 berisi " +Berth7[i][1].toString());
        }
        for (int i = 0; i < Berth8.length; i++) {
            System.out.println("Berth 8 berisi " +Berth8[i][1].toString());
        }
        for (int i = 0; i < Berth9.length; i++) {
            System.out.println("Berth 9 berisi " +Berth9[i][1].toString());
        }
        for (int i = 0; i < Berth10.length; i++) {
            System.out.println("Berth 10 berisi " +Berth10[i][1].toString());
        }
        
        for (int i = 0; i < DistanceOB.length; i++) {
            System.out.println("Distance between opposite berth berisi " +DistanceOB[i][1].toString());
        }
        for (int i = 0; i < DistanceAB.length; i++) {
            System.out.println("Distance between adjacent berth berisi " +DistanceAB[i][1].toString());
        }
        
        for (int i = 0; i < SpesialRules.length; i++) {
            System.out.println("Spesial Rules berisi " +SpesialRules[i][1].toString());
        }
        
        for (int i = 0; i < Ships.length; i++) {
            System.out.println("Ships berisi " +Ships[i][1].toString());
        }
        */
    }
    
    void b(String Type, Float MaxDraft, Float Max_Length, 
            Float Max_Width, Float Max_DWT){
        
    }
}



