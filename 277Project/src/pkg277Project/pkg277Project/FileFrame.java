/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg277Project;

import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;



/**
 *
 * @author ianbw
 */
public class FileFrame extends JInternalFrame{
    JSplitPane splitpane;
    public FileFrame(){
        splitpane = new JSplitPane();
        this.setTitle("C:");
        this.setSize(200, 200);
        this.getContentPane().add(splitpane);
        this.setClosable(true);
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setVisible(true);
        
        
    }
            
}
