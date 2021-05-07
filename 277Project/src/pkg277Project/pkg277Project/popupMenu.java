package pkg277Project;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class popupMenu extends JPopupMenu {

    
    public void JPopupMenuTest() {
        JPopupMenu popup = new JPopupMenu();
        // add menu items to popup
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem delete = new JMenuItem("Delete");
        /*
        popup.add(new JMenuItem("Cut"));
        popup.add(new JMenuItem("Copy"));
        popup.add(new JMenuItem("Paste"));
        popup.addSeparator();
        popup.add(new JMenuItem("SelectAll"));
        */ 
        popup.add(cut);
        popup.add(copy);
        popup.add(paste);
        popup.addSeparator();
        popup.add(delete);
        setSize(375, 250);
        setVisible(true);
     }
}
