package pkg277Project;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class DirPanel extends JPanel{
    private static final DefaultMutableTreeNode File = null;
    private DefaultMutableTreeNode dir;
    private DefaultTreeModel treemodel;
    private JScrollPane scrollPane = new JScrollPane();
    private JTree dirTree = new JTree();
    private FilePanel filePanel;
    File rootFile;
    String path;
    private renameDialog rd;

    public DirPanel(String path, FileFrame fileframe) {
        final FileFrame ff = fileframe;
        setPath(path); 
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
        buildTree(path);
        add(dirTree);
        dirTree.setVisible(true);
        add(scrollPane);
        scrollPane.setViewportView(dirTree);
        dirTree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)dirTree.getLastSelectedPathComponent();
                System.out.println(node.toString());
    
                //}
                fileNode fNode = (fileNode)node.getUserObject();
                File file = fNode.getFile();
                if (!node.toString().equals(null)) {
                    System.out.println(file.toString());
                    String filepath = file.toString();
                    setPath(filepath);
                    ff.setTitle(filepath);
                    filePanel.setPath(filepath);
                    filePanel.fillList(new File(filepath), true);
                }
            }
        });

        
    }

    public boolean exists(){
        return dirTree.isVisible();
    }

    public void buildTree(String path){
        System.out.println(path);
        File fileRoot = new File(path);
        dir = new DefaultMutableTreeNode(new fileNode(fileRoot));
        treemodel = new DefaultTreeModel(dir);

        dirTree = new JTree(treemodel);
        dirTree.setShowsRootHandles(true);

        createChildren cc = new createChildren(fileRoot, dir);
        new Thread(cc).start();
    }
    public String getPath(){
        return this.path;
    }
    public void setPath(String newPath){
        this.path = newPath;
    }

    public void setFilePanel(FilePanel fp) {
        filePanel = fp;
    }
    public void setRootFile(String root) {
        rootFile = new File(root);
    }
    public String getRootFile() {
        return rootFile.getPath();
    }
    public JTree getDirTree() {
        return dirTree;
    }
    /*
    class MyTreeSelectionListener implements TreeSelectionListener {


        @Override
        public void valueChanged(TreeSelectionEvent e) {
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)dirTree.getLastSelectedPathComponent();
            System.out.println(node.toString());

            //}
            fileNode fNode = (fileNode)node.getUserObject();
            File file = fNode.getFile();
            if (!node.toString().equals(null)) {
                System.out.println(file.toString());
                ff.setTitle(file.toString());
                //FileFrame.setName(file.toString());
                filePanel.fillList(new File(file.toString()));
                //rd.getPath(file.toString());
            }
        }
        
    }
    */
    public static void setTreeExpandedState(JTree tree, boolean expanded) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getModel().getRoot();
        setNodeExpandedState(tree, node, expanded);
    }
  
    public static void setNodeExpandedState(JTree tree, TreeNode treeNode2, boolean expanded) {
        ArrayList<TreeNode> list = (ArrayList<TreeNode>) Collections.list(treeNode2.children());
        for (TreeNode treeNode : list) {
            setNodeExpandedState(tree, treeNode, expanded);
        }
        if (!expanded && ((DefaultMutableTreeNode) treeNode2).isRoot()) {
            return;
        }
        TreePath path = new TreePath(treeNode2.getParent());
        if (expanded) {
            tree.expandPath(path);
        } else {
            tree.collapsePath(path);
        }
    }
    
}
