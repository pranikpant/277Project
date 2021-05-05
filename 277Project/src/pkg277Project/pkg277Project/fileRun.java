package pkg277Project.pkg277Project;

import java.awt.Desktop;
import java.io.*;

public class fileRun extends GUI {
    
    public static void main(String[] args) {

        Desktop desktop = Desktop.getDesktop();
        
        try {
            desktop.open(new File("C:\\Users\\ianbw\\Downloads\\Lab14277.zip"));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}
