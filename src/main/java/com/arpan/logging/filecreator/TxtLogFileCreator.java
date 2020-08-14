package com.arpan.logging.filecreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.arpan.Operation;
import com.arpan.helper.GetCurrentDateTime;

public class TxtLogFileCreator implements LogFileCreator {
    @Override
    public File createLogFile(List<Operation> operationList) {

        String workingDir = System.getProperty("user.dir");
        String currentDateTime = GetCurrentDateTime.getCurrentDateTime("dd-MM-yyyy_HH:mm:ss");
        String filePath = workingDir + "/" + currentDateTime + ".txt";
        File txtFile = CreateFile.createFile(filePath);

        try (FileWriter logFileWriter = new FileWriter(txtFile))  {
            for (Operation operationLog : operationList) {
                logFileWriter.write(operationLog.toString());
                logFileWriter.write("\n");
            }

        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        return txtFile;
    }
}