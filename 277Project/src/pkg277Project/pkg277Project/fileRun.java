package pkg277Project;

import java.awt.Desktop;
import java.io.*;

public class fileRun extends GUI {
    
    String file;

    public fileRun(String file){
        this.file = file;
    }

    public void run() {

        Desktop desktop = Desktop.getDesktop();
        
        try {
            desktop.open(new File(file));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
    public String str(){
        
        return null;
        
    }
    
}
