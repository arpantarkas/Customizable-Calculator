package com.arpan.logging.filecreator;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.arpan.Operation;
import com.arpan.helper.GetCurrentDateTime;
import com.opencsv.CSVWriter;

public class CsvLogFileCreator implements LogFileCreator{
    
    @Override
    public File createLogFile(List<Operation> operationList) {
        
        String workingDir = System.getProperty("user.dir");
        String currentDateTime = GetCurrentDateTime.getCurrentDateTime("dd-MM-yyyy_HH:mm:ss");
        String filePath = workingDir + "/" + currentDateTime + ".csv";
        File csvFile = CreateFile.createFile(filePath);

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(csvFile))) {
            String [] columnTitle = {"Left operand", "Right Operand", "Operation"};
            csvWriter.writeNext(columnTitle);

            for (Operation operationLog: operationList) {
                String leftOperand = Integer.toString(operationLog.getLeftOperand());
                String rightOperand = Integer.toString(operationLog.getRightOperand());
                String operationType = operationLog.getOperationType();

                String [] operationEntry = {leftOperand, rightOperand, operationType};
                csvWriter.writeNext(operationEntry);
            }

            
        } catch (Exception e) {
            //TODO: handle exception
        }

        return csvFile;
    }
}