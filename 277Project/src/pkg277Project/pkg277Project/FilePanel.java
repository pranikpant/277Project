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
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
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
    static String path;
    String runPath;
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
                if (SwingUtilities.isLeftMouseButton(evt) ) {
                    if (evt.getClickCount() == 2) {
                        int index = theList.locationToIndex(evt.getPoint());
                        if (index >= 0) {
                            Object o = theList.getModel().getElementAt(index);
            
                            System.out.println("Double-clicked on: " + FilePanel.getPath() + ("\\") + o.toString());
                    
                            runPath = FilePanel.getPath() + ("\\") + o.toString();
                            
                            final fileRun fr = new fileRun(runPath);
                            fr.run();
                        }
                    }
                }
                if (SwingUtilities.isRightMouseButton(evt) ){
                    
                    int index = theList.locationToIndex(evt.getPoint());
                    Object o = theList.getModel().getElementAt(index);
                    System.out.println("Right CLick on: " + o.toString());
                    JPopupMenu popup = new JPopupMenu();
                    // add menu items to popup
                    JMenuItem rename = new JMenuItem("Rename");
                    JMenuItem copy = new JMenuItem("Copy");
                    JMenuItem paste = new JMenuItem("Paste");
                    JMenuItem delete = new JMenuItem("Delete");

                    rename.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            renameMenuItem(evt);
                        }
                    });
                    copy.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            copyMenuItem(evt);
                        }
                    });
                    paste.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            pasteMenuItem(evt);
                        }
                    });
                    delete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            deleteMenuItem(evt);
                        }
                    });

                    popup.add(rename);
                    popup.add(copy);
                    popup.add(paste);
                    popup.addSeparator();
                    popup.add(delete);
                    popup.setSize(250, 175);
                    setVisible(true);
                    popup.show(FilePanel.this, 5, 3);
                }
            }
        });         
    }

    private void renameMenuItem (java.awt.event.ActionEvent evt) {
             
        String renamePath = FilePanel.getPath();
        System.out.println(renamePath);
        new renameFile(null,true,runPath,renamePath).show();                                   
        System.out.println("renaming");
        
        
    }
    private void copyMenuItem (java.awt.event.ActionEvent evt) {                                        
        System.out.println("copying");
        
        
    }
    private void pasteMenuItem (java.awt.event.ActionEvent evt) {                                        
        System.out.println("pasting");
        
        
    }
    private void deleteMenuItem (java.awt.event.ActionEvent evt) {                                        
        System.out.println("deleting");
        
        
    }
    public void setPath(String drivepath) {
        path = drivepath;
    }

    public static String getPath() {
        return path;
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




