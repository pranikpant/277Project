/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg277Project;

import java.io.*;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import java.net.URI;
import java.util.ArrayList;


/**
 *
 * @author ianbw
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mydesktop = new javax.swing.JDesktopPane();
        jComboBox2 = new javax.swing.JComboBox<>();
        Details = new javax.swing.JButton();
        Simple = new javax.swing.JButton();
        DriveSpace = new java.awt.Label();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Rename = new javax.swing.JMenuItem();
        Copy = new javax.swing.JMenuItem();
        Delete = new javax.swing.JMenuItem();
        Run = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Tree = new javax.swing.JMenu();
        Expand = new javax.swing.JMenuItem();
        Collapse = new javax.swing.JMenuItem();
        Window = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Cascade = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        Help_item = new javax.swing.JMenuItem();
        About = new javax.swing.JMenuItem();
        JMenuBar gap = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        final getDrives gd= new getDrives();
        ArrayList<String> ad = gd.allDrives();
        for (int i = 0; i < ad.size(); i++) {
            jComboBox2.addItem(ad.get(i));
        }
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalDrive = (String) jComboBox2.getSelectedItem();

                //jCombobox2ActionPerformed(evt);
                System.out.println(finalDrive);
                //return driveSelection;
            }
        });
        
        //System.out.println(finalDrive);
        

        Details.setText("Details");
        Details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailsActionPerformed(evt);
            }
        });

        Simple.setText("Simple");
        
        

        mydesktop.setLayer(jComboBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mydesktop.setLayer(Details, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mydesktop.setLayer(Simple, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mydesktopLayout = new javax.swing.GroupLayout(mydesktop);
        mydesktop.setLayout(mydesktopLayout);
        mydesktopLayout.setHorizontalGroup(
            mydesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mydesktopLayout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Details)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Simple)
                .addContainerGap(135, Short.MAX_VALUE))
                .addComponent(gap, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        mydesktopLayout.setVerticalGroup(
            mydesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mydesktopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mydesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Details)
                .addComponent(Simple))
                .addComponent(gap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(411, Short.MAX_VALUE))
        );
        // using C: drive for example
        //String driveName = "C:\\";
        File drive = new File(finalDrive);
        DriveSpace.setText("Current Drive: " + finalDrive + "    Free Space: " + drive.getFreeSpace()/1000000000 + " GB" + "    Used Space: " + (drive.getTotalSpace()-drive.getFreeSpace())/1000000000 + " GB" 
        + "    Total Space: " + drive.getTotalSpace()/1000000000 + " GB");

        File.setText("File");

        Rename.setText("Rename");
        Rename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenameActionPerformed(evt);
            }
        });
        File.add(Rename);

        Copy.setText("Copy");
        Copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyActionPerformed(evt);
            }
        });
        File.add(Copy);

        Delete.setText("Delete");
        File.add(Delete);

        Run.setText("Run");
        Run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunActionPerformed(evt);
            }
        });
        File.add(Run);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        jMenuBar1.add(File);

        Tree.setText("Tree");

        Expand.setText("Expand");
        Tree.add(Expand);

        Collapse.setText("Collapse");
        Collapse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CollapseActionPerformed(evt);
            }
        });
        Tree.add(Collapse);

        jMenuBar1.add(Tree);

        Window.setText("Window");

        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        Window.add(New);

        Cascade.setText("Cascade");
        Window.add(Cascade);

        jMenuBar1.add(Window);

        Help.setText("Help");
        

        Help_item.setText("Help");
        Help_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Help_itemActionPerformed(evt);
            }
        });
        Help.add(Help_item);

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        Help.add(About);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mydesktop)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DriveSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mydesktop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DriveSpace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DetailsActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        
    }
    
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        dispose();
    }
    
    private void CopyActionPerformed(java.awt.event.ActionEvent evt){
        new copyingDialog(null,true).show(); 
    }
    
    private void RenameActionPerformed(java.awt.event.ActionEvent evt){
        new renameDialog(null,true).show(); 
    }

    private void RunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunActionPerformed
        // TODO add your handling code here:
        new runDialog(null,true).show();  
    }//GEN-LAST:event_RunActionPerformed

    private void Help_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        // TODO add your handling code here:
                try {
                    java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                    URI oURL = new URI("https://www.youtube.com/watch?v=tqUAE0o46lw");
                    desktop.browse(oURL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }//GEN-LAST:event_HelpActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        // TODO add your handling code here:
        new AboutDialog(null,true).show(); 
    }//GEN-LAST:event_AboutActionPerformed

    private void CollapseActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    } 
    private void jCombobox2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        finalDrive = (String) jComboBox2.getSelectedItem();
        //return driveSelection;
        
    }                                         

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        final FileFrame IF=new FileFrame();
        mydesktop.add(IF);
        final newTree nt=new newTree();
        nt.run();  
    }                                         

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenuItem Cascade;
    private javax.swing.JMenuItem Collapse;
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Delete;
    private javax.swing.JButton Details;
    private java.awt.Label DriveSpace;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Expand;
    private javax.swing.JMenu File;
    private javax.swing.JMenu Help;
    private javax.swing.JMenuItem Help_item;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Rename;
    private javax.swing.JMenuItem Run;
    private javax.swing.JButton Simple;
    private javax.swing.JMenu Tree;
    private javax.swing.JMenu Window;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane mydesktop;
    public String finalDrive = "C:\\";
    // End of variables declaration//GEN-END:variables
}
