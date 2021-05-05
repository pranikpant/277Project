package pkg277Project;
import java.io.*;
import java.util.ArrayList;

public class getDrives {
    
    public ArrayList<String> allDrives(){
        ArrayList<String> drives = new ArrayList<String>();
        File[] paths;
        // number of dropdown items (items 1-4 etc.) = paths.length
        paths = File.listRoots();
        for(int i = 0; i < paths.length; i++){
            drives.add(paths[i].getPath());
        }
        return drives;
    }   
}
