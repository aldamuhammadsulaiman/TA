package taberth;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Mainprog {
    
    public static void main(String[] args) throws IOException, CloneNotSupportedException  {
 
//        for (int i = 0; i < 10; i++) {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
            ArrayList<String[]> arrship = new ArrayList<>();
            ArrayList<Ship> listship = new ArrayList<>();

            File[] files = new File("src/main/java/instance/").listFiles();

            String filename = files[i].getName().substring(0, files[i].getName().length() - 4);
            String filepath = files[i].getPath();
            
            ReadFile read = new ReadFile(filepath, arrship, listship);
            InitSolution init = new InitSolution(listship);

            Heuristic heur = new Heuristic(init.initialsol);
            System.out.println("cost initial "+ filename + "  adalah " +Util.cost(heur.initsol));
            
//            heur.ilsgd();
//            Util.export(heur.ilssol, filename,j);
//            Util.exportstat(heur.initsol, heur.hilsol, heur.ilssol, filename,j,heur.startimer,heur.endtimer,heur.besttimer);
            
            heur.GA();
//            Util.export(heur.ga_sol, filename,j);
//            Util.exportstat(heur.initsol, heur.ga_sol, heur.ga_sol, filename,j,heur.startimer,heur.endtimer,heur.besttimer);
//            System.out.println(filename + " run ke "+j);
            
            System.out.println("");
            
              
            }
        }
    }
    public static void showFiles(File[] files) {
    for (File file : files) {
        if (file.isDirectory()) {
            System.out.println("Directory: " + file.getName());
            showFiles(file.listFiles()); // Calls same method again.
        } else {
            System.out.println("File: " + file.getName());
        }
    }
}
    
}
