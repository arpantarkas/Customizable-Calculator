package com.arpan.logging.filecreator;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static File createFile (String fileLocation) {


        try {
            File file = new File(fileLocation);
            if (file.createNewFile()) {
                System.out.println("File Created successfully");
                return file;
            }
            else {
                System.out.println("File Not created");
            }
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
}