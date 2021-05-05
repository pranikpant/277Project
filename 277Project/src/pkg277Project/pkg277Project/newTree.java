package pkg277Project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.io.*;

public class newTree {
    
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treemodel;
    private JTree tree;
    private JPanel panel = new JPanel();
    private JPanel rightPanel = new JPanel();
    private String path = "C:\\";

    
    public void run(){ 
        //FileFrame frame = new FileFrame();
        //JFrame frame = new JFrame("C:\\");
        //final DirPanel frame = new DirPanel();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        File fileRoot = new File(path);
        root = new DefaultMutableTreeNode(new fileNode(fileRoot));
        treemodel = new DefaultTreeModel(root);

        tree = new JTree(treemodel);
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);

        this.panel.add(scrollPane);
        //frame.setLocationByPlatform(true);
        this.panel.setSize(1000, 1000);
        this.panel.setVisible(true);

        createChildren cc = new createChildren(fileRoot, root);
        new Thread(cc).start();
    }
    public JPanel getTree(){
        return this.panel;
    }
    public String getPath(){
        return this.path;
    }
    public void setPath(String newPath){
        this.path = newPath;
    }
    public JPanel directoryRead(){
        
        return this.rightPanel;
    }

    //public static void main (String[] args) {
    //   SwingUtilities.invokeLater(new newTree());
    //}
}
