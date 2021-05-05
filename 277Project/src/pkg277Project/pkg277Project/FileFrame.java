package pkg277Project;

import javax.swing.JSplitPane;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;

/**
 * @author ianbw
 */

public class FileFrame extends JInternalFrame{
    JSplitPane splitpane;
    //DefaultListModel model = new DefaultListModel<>();
    //JList list = new JList();
    //String path;
    
    public FileFrame(String driveName) {
        DirPanel dirP = new DirPanel(driveName);
        FilePanel fileP = new FilePanel();
        //dirP.setFilePanel(fileP);
        splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, dirP, fileP);

        this.setTitle(driveName);
        this.setSize(400, 400);
        this.getContentPane().add(splitpane);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setVisible(true); 
    }

    /*
    //String name;
    public FileFrame(String driveName){
        final newTree nt= new newTree();
        nt.setPath(driveName);
        nt.run();
        //nt.create();
        this.splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, nt.getTree(), new FilePanel());
        this.setTitle(driveName);
        this.setSize(400, 400);
        this.getContentPane().add(splitpane);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setVisible(true);  
        
    }
    public void fillList(File dir) {
        File[] files;

        files = dir.listFiles();
        model.clear();
        list.removeAll();
        for(int i = 0; i < files.length; i++) {
            if(!files[i].isHidden()){
                model.addElement(files[i].getAbsolutePath());
            }
        }
        list.setModel(model);
        
    }
    */
            
}
