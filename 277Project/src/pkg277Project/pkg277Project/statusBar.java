package pkg277Project;

import java.io.*;

public class statusBar extends GUI {

    File drive;

    public statusBar(String driveName) {
        drive = new File(driveName);
    }

    public void Bar() {
        DriveSpace.setText( "Space in GB: " + drive.length() );
    }
}
