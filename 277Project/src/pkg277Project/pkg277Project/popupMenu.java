package pkg277Project;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class popupMenu extends JPopupMenu {

    
    public void JPopupMenuTest() {
        JPopupMenu popup = new JPopupMenu();
        // add menu items to popup
        popup.add(new JMenuItem("Cut"));
        popup.add(new JMenuItem("Copy"));
        popup.add(new JMenuItem("Paste"));
        popup.addSeparator();
        popup.add(new JMenuItem("SelectAll"));
        setSize(375, 250);
        setVisible(true);
     }
}
