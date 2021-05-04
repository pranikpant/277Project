package pkg277Project;
import java.io.*;

public class getDrives {
    
    public static void main(String[] args) {

        File[] paths;
        paths = File.listRoots();
        for(File path : paths) {
            System.out.println(path);
        }
    }
}
