package com.arpan;

public class LoggingStrategy {
    String emailAddress;
    FileFormat fileFormat;

    public LoggingStrategy(String email, FileFormat fileFormat) {
        this.emailAddress = email;
        this.fileFormat = fileFormat;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public FileFormat getFileFormat() {
        return this.fileFormat;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setFileFormat(FileFormat fileFormat) {
        this.fileFormat = fileFormat;
    }
}