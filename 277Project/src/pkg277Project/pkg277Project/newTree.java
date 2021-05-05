package pkg277Project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import java.io.*;

public class newTree implements Runnable{
    
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treemodel;
    private JTree tree;

    
    public void run(){
        FileFrame frame = new FileFrame();
        //JFrame frame = new JFrame("C:\\");
        //final DirPanel frame = new DirPanel();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        File fileRoot = new File("C:\\");
        root = new DefaultMutableTreeNode(new fileNode(fileRoot));
        treemodel = new DefaultTreeModel(root);

        tree = new JTree(treemodel);
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);

        frame.add(scrollPane);
        //frame.setLocationByPlatform(true);
        frame.setSize(640, 480);
        frame.setVisible(true);

        createChildren cc = new createChildren(fileRoot, root);
        new Thread(cc).start();
    }

    public static void main (String[] args) {
       SwingUtilities.invokeLater(new newTree());
    }
}
