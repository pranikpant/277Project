package pkg277Project.pkg277Project;
import java.io.*;

public class getDrives {
    
    public static void main(String[] args) {

        File[] paths;
        // number of dropdown items (items 1-4 etc.) = paths.length
        paths = File.listRoots();
        for(File path : paths) {
            System.out.println(path);
        }
    }
}
