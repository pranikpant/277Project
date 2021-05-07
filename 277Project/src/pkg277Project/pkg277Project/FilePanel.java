/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg277Project;


import java.awt.Dimension;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 *
 * @author Dr. Hoffman
 */

public class FilePanel extends JPanel {
    
    JList list = new JList();
    DefaultListModel model = new DefaultListModel<>();
    private JScrollPane scrollPane = new JScrollPane();
    private popupMenu popup = new popupMenu(); 
    //DefaultListModel model = new DefaultListModel();
    
    public FilePanel(){
        //list.setPreferredSize(new Dimension(500,500));
        
        this.setDropTarget(new MyDropTarget());
        list.setDragEnabled(true);
        list.setModel(model);
        GroupLayout layout = new GroupLayout (this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        add(list);
        add(scrollPane);
        scrollPane.setViewportView(list);
        list.addListSelectionListener(new MyListSelectionListener());
        list.addMouseListener(new MouseInputAdapter(){ 
            public void mouseClicked(MouseEvent evt) {
                JList<String> theList = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = theList.locationToIndex(evt.getPoint());
                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);
                        System.out.println("Double-clicked on: " + o.toString());
                        //Object fNode = ((DefaultMutableTreeNode) o).getUserObject();
                        //System.out.println(fNode.toString());
                        //File file = fNode.getFile();
                        //final fileRun fr=new fileRun(file);
                        //fr.run();
                    }
                }
                if (SwingUtilities.isRightMouseButton(evt) ){
                    System.out.println("Right CLick");
                    //list.add(popup);
                    //list.setSelectedIndex(getRow(e.getPoint()));
                }
            }
        });         
    }
    
    
    public void fillList(File dir) {
        File[] files;
        files = dir.listFiles();
        model.clear();
        list.removeAll();
        for(int i=0; i<files.length; i++) {
            if(!files[i].isHidden()) {
                model.addElement(files[i].getName());
            }
        }
        list.setModel(model);
    }
    /*************************************************************************
     * class MyDropTarget handles the dropping of files onto its owner
     * (whatever JList it is assigned to). As written, it can process two
     * types: strings and files (String, File). The String type is necessary
     * to process internal source drops from another FilePanel object. The
     * File type is necessary to process drops from external sources such 
     * as Windows Explorer or IOS.
     * 
     * Note: no code is provided that actually copies files to the target
     * directory. Also, you may need to adjust this code if your list model
     * is not the default model. JList assumes a toString operation is
     * defined for whatever class is used.
     */
    class MyDropTarget extends DropTarget {
    /**************************************************************************
     * 
     * @param evt the event that caused this drop operation to be invoked
     */    
        public void drop(DropTargetDropEvent evt){
            try {
                //types of events accepted
                evt.acceptDrop(DnDConstants.ACTION_COPY);
                //storage to hold the drop data for processing
                List result = new ArrayList();
                //what is being dropped? First, Strings are processed
                if(evt.getTransferable().isDataFlavorSupported(DataFlavor.stringFlavor)){     
                    String temp = (String)evt.getTransferable().getTransferData(DataFlavor.stringFlavor);
                    //String events are concatenated if more than one list item 
                    //selected in the source. The strings are separated by
                    //newline characters. Use split to break the string into
                    //individual file names and store in String[]
                    String[] next = temp.split("\\n");
                    //add the strings to the listmodel
                    for(int i=0; i<next.length;i++)
                        model.addElement(next[i]); 
                }
                else{ //then if not String, Files are assumed
                    result =(List)evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    //process the input
                    for(Object o : result){
                        System.out.println(o.toString());
                        model.addElement(o.toString());
                    }
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        
    }
    class MyListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {

            String node = (String) list.getSelectedValue();

            System.out.println(node);

        }
    }
}




