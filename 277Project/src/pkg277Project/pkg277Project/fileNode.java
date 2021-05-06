package pkg277Project;

import java.io.*;

public class fileNode {
    File file;
    String fileName;

    public fileNode(File file) {
        this.file = file;
    }

    public fileNode(String name, File f) {
        fileName = name;
        file = f;
    }

    public boolean isDirectory(){
        return file.isDirectory();
    }
    
    public File getFile() {
        return file;
    }
    @Override
    public String toString(){
        String name = file.getName();
        if (name.equals("")) {
            return file.getAbsolutePath();
        } else {
            return name;
        }

    }

}
