package pkg277Project;

import java.io.File;

import javax.swing.tree.DefaultMutableTreeNode;

public class createChildren implements Runnable {
    private DefaultMutableTreeNode root;
    private File file;

    public createChildren(File file, DefaultMutableTreeNode root) {
        this.root = root;
        this.file = file;
    }
    @Override
    public void run() {
        createChildrenNodes(file, root);
    }


    private void createChildrenNodes(File file, DefaultMutableTreeNode node) {
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new fileNode(files[i]));
            node.add(childNode); 
            if (files[i].isDirectory()){
                createChildrenNodes(files[i], childNode);
            }
        }
    }
    //@Override
    public void create(){
        createAllNodes(file, root);
    }

    private void createAllNodes(File file, DefaultMutableTreeNode node){
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new fileNode(files[i]));
            node.add(childNode); 
        }
    }
}
