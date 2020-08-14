package com.arpan;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.arpan.helper.GetCurrentDateTime;
import com.arpan.logging.OperationLogger;
import com.arpan.logging.filecreator.CreateFile;
import com.arpan.logging.filecreator.CsvLogFileCreator;
import com.arpan.logging.filecreator.TxtLogFileCreator;

public class App {
    public static void main(String [] args) {
        System.out.println(System.getProperty("user.dir"));
        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        // Date date = new Date();
        // System.out.println(formatter.format(date));
        System.out.println(GetCurrentDateTime.getCurrentDateTime("dd-MM-yyyy_HH:mm:ss"));
        // File file = CreateFile.createFile("dd-MM-yyyy_HH:mm:ss");
        List <Operation> opList = Arrays.asList(
            new Operation(1, 2, "sum"),
            new Operation(1, 2, "sum"),
            new Operation(1, 2, "sum")
        );

        // TxtLogFileCreator txtLogFileCreator= new TxtLogFileCreator();
        // txtLogFileCreator.createLogFile(opList);

        // CsvLogFileCreator csvLogFileCreator = new CsvLogFileCreator();
        // csvLogFileCreator.createLogFile(opList);

        LoggingStrategy loggingStrategy = new LoggingStrategy("arpantarkas@example.com", FileFormat.TXT);
        OperationLogger oLogger = new OperationLogger();
        oLogger.logOperations(opList, loggingStrategy);
        


    }
}