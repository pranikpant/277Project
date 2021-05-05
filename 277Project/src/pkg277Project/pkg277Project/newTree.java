package pkg277Project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.io.*;

public class newTree {
    
    private DefaultMutableTreeNode root;
    private DefaultMutableTreeNode dir;
    private DefaultTreeModel treemodel;
    private DefaultTreeModel treemodel2;
    private JTree tree;
    private JTree tree2;
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
        /*
        this.panel.add(scrollPane);
        //frame.setLocationByPlatform(true);
        this.panel.setSize(1000, 1000);
        this.panel.setVisible(true);
        */

        createChildren cc = new createChildren(fileRoot, root);
        new Thread(cc).start();


    }

    public void create() {
        File fileRoot = new File(this.getPath());
        dir = new DefaultMutableTreeNode(new fileNode(fileRoot));
        treemodel2 = new DefaultTreeModel(dir);

        tree2 = new JTree(treemodel2);
        tree2.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree2);

        this.panel.add(scrollPane);
        //frame.setLocationByPlatform(true);
        this.panel.setSize(1000, 1000);
        this.panel.setVisible(true);

        createChildren ccd = new createChildren(fileRoot, dir);
        new Thread(ccd).start();
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

    class MyTreeSelectionListener implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            System.out.println(e.getPath());
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            System.out.println(node.toString());
        }

        
    }
}
