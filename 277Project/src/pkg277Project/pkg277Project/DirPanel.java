package pkg277Project;

import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class DirPanel extends JPanel{
    private DefaultMutableTreeNode dir;
    private DefaultTreeModel treemodel;
    private JScrollPane scrollPane = new JScrollPane();
    private JTree dirTree = new JTree();
    private FilePanel filePanel;
    FileManagerFrame myFrame;
    File rootFile;
    String path;

    public DirPanel(String path) {
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
        //dirTree.addTreeSelectionListener(new MyTreeSelectionListener());
        add(scrollPane);
        scrollPane.setViewportView(dirTree);
        
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

    class MyTreeSelectionListener implements TreeSelectionListener {

        @Override
        public void valueChanged(TreeSelectionEvent e) {
            System.out.println(e.getPath());
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) dirTree.getLastSelectedPathComponent();
            System.out.println(node.toString());
            //String dirPath = "";
            //TreePath[] paths = e.getPath();
            //for (int i = 0; i < paths.length; i++){

            //}
            fileNode fNode = (fileNode)node.getUserObject();
            File file = fNode.getFile();
            if (!node.toString().equals(null)) {
                //System.out.println(file.toString());
                filePanel.fillList(new File(file.toString()));
            }
        }

        
    }
}
