package pkg277Project;

import java.awt.Desktop;
import java.io.*;

public class fileRun extends GUI {
    
    public static void main(String[] args, String str) {

        Desktop desktop = Desktop.getDesktop();
        
        try {
            desktop.open(new File(str));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    public String str(){
        
        return null;
        
    }
    
}
