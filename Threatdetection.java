import java.util.Scanner;          
import java.io.IOException;   
    public class Threatdetection{
     public static void main(String[] args) throws IOException { 
        Scanner in = new Scanner(System.in); 
        int tries = 0;                       
        String fileNameUser;                 
        double epsilon = 90.00;              
        int maxTries = 3;                    
        
        System.out.println("Max Tries: " + maxTries); 
        
        FingerPrint original = new FingerPrint("Original.txt"); 


        while (tries < maxTries) { 
            System.out.print("Provide the fingerprint file name (include .txt): ");
            
            fileNameUser = in.nextLine(); 
            
            FingerPrint userFingerPrint = loadFingerprint(fileNameUser); 
            
            double acc = computeAccuracy(original, userFingerPrint);
            
            System.out.printf("Accuracy: %.2f", acc); 
            System.out.print(" %. ");                  
            
            if (acc >= epsilon) { 
                
                System.out.println("");
                System.out.println("Authentification successful. Access Granted");
                
                return; 
            }
            else {
                tries++; 
                System.out.println((maxTries - tries) + " tries left.");
            }
        }
        
        System.out.println("Max tries reached. Stopping program...");
    }
    
    public static double computeAccuracy(FingerPrint original, FingerPrint user) {
        
                                                     
        double matched = 0;                          
        int pixels = original.getNumberOfPixels();   
        String[][] OgData = original.getData();      
        String[][] UserData = user.getData();        
        
        for (int i = 0; i < original.getRows(); i++) {
            
            for (int j = 0; j < original.getCols(); j++) {
                
                if (OgData[i][j].equals(UserData[i][j])) { 
                    
                    matched++; 
                }
            }
        }
        
        return (matched / pixels) * 100; 
    }

    public static FingerPrint loadFingerprint(String filename) throws IOException {
        
        return new FingerPrint(filename); 
    }          
}