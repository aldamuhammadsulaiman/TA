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
        
        String[][] Ships = new String[11][11];
          
        for (int i = 0; i<Ships.length; i++) {
                Ships[i] = array[i+140][0].split("\\s");

        }
        
        System.out.println(Ships[1][0]);      
    }
}



