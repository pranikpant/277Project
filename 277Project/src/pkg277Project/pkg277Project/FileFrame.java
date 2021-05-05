package pkg277Project;

import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;

/**
 * @author ianbw
 */

public class FileFrame extends JInternalFrame{
    JSplitPane splitpane;
    String name;
    public FileFrame(){
        splitpane = new JSplitPane();
        this.setTitle("C:");
        this.setSize(400, 400);
        this.getContentPane().add(splitpane);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setVisible(true);
        
        
    }
            
}
