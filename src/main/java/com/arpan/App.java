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
import com.arpan.operators.Adder;
import com.arpan.operators.ExpressionParser;

public class App {
    public static void main(String [] args) {
        // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
        // Date date = new Date();
        // System.out.println(formatter.format(date));
        // File file = CreateFile.createFile("dd-MM-yyyy_HH:mm:ss");
        

        // TxtLogFileCreator txtLogFileCreator= new TxtLogFileCreator();
        // txtLogFileCreator.createLogFile(opList);

        // CsvLogFileCreator csvLogFileCreator = new CsvLogFileCreator();
        // csvLogFileCreator.createLogFile(opList);

        // LoggingStrategy loggingStrategy = new LoggingStrategy("arpantarkas@example.com", FileFormat.TXT);
        // OperationLogger oLogger = new OperationLogger();
        // oLogger.logOperations(opList, loggingStrategy);
        
        // ExpressionParser eParser = new ExpressionParser();
        // eParser.evaluateExpression("1+2*5");
        Adder myAdder = numList -> numList.size();
        LoggingStrategy loggingStrategy = new LoggingStrategy("arpan@ex.com", FileFormat.TXT);
        Calculator calculator = new Calculator.Builder().addAdder(myAdder).setLoggingStrategy(loggingStrategy).build();
        List<Integer> numList = Arrays.asList(1, 2, -1, 4);

        // Integer sum = calculator.add(numList);
        // System.out.println("Final Result - "+ sum.toString());
        Integer ans = calculator.calculateExpression("1*10+2*8/2+88/4-9");
        List<Operation> opLis = calculator.getOperationList();
        for (Operation op: opLis)
            System.out.println(op.toString());
        System.out.println(ans);
        // calculator.sendResults();

    }
}