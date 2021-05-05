package pkg277Project;

import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;

/**
 * @author ianbw
 */

public class FileFrame extends JInternalFrame{
    JSplitPane splitpane;
    String name;
    public FileFrame(String driveName){
        final newTree nt= new newTree();
        nt.setPath(driveName);
        nt.run();
        this.splitpane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, nt.getTree(), new FilePanel());
        this.setTitle(driveName);
        this.setSize(400, 400);
        this.getContentPane().add(splitpane);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setVisible(true);  
    }
            
}
