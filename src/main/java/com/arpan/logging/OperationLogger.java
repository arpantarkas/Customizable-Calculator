package com.arpan.logging;

import java.io.File;
import java.util.List;

import com.arpan.FileFormat;
import com.arpan.LoggingStrategy;
import com.arpan.Operation;
import com.arpan.logging.filecreator.LogFileCreator;
import com.arpan.logging.filecreator.LogFileCreatorFactory;
import com.arpan.logging.notification.MailNotificationSender;
import com.arpan.logging.notification.Notification;
import com.arpan.logging.notification.NotificationSender;

public class OperationLogger {
    LogFileCreator logFileCreator;
    NotificationSender notificationSender;

    public OperationLogger() {
    /*
        Empty Constructor
    */  
    }

    private LogFileCreator getLogfileCreator(FileFormat fileFormat) {
        if (logFileCreator == null) {
            logFileCreator = LogFileCreatorFactory.create(fileFormat);
        }
        return logFileCreator;
    }

    private NotificationSender getNotificationSender() {
        if (notificationSender == null) {
            notificationSender = new MailNotificationSender();
        }
        return notificationSender;
    }

    public void logOperations(List<Operation> operationList, LoggingStrategy loggingStrategy) {
        logFileCreator = getLogfileCreator(loggingStrategy.getFileFormat());
        File outputLogFile = logFileCreator.createLogFile(operationList);
        System.out.println("Done");

        Notification notification = new Notification();

        notification.setSubject("Calculator Operations Log File");
        notification.setMessage("Dear User, PFA of the log file.");
        notification.setToAddress(loggingStrategy.getEmailAddress());
        notification.setFromAddress("senderEmail@example.com");
        notification.setAttachment(outputLogFile);
        notification.setSignature("Thanks & Regards!");

        notificationSender = getNotificationSender();
        notificationSender.sendNotification(notification);
    }


}