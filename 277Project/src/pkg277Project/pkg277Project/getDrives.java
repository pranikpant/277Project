package pkg277Project;
import java.io.*;
import java.util.ArrayList;

public class getDrives {
    
    public ArrayList<File> allDrives(){
        ArrayList<File> drives = new ArrayList<File>();
        File[] paths;
        // number of dropdown items (items 1-4 etc.) = paths.length
        paths = File.listRoots();
        for(int i = 0; i < paths.length; i++){
            drives.add(paths[i]);
        }
        return drives;
    }   
}
