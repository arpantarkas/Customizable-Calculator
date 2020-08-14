package com.arpan.logging.filecreator;

import com.arpan.FileFormat;

public class LogFileCreatorFactory {
    
    public static LogFileCreator create(FileFormat fileFormat) {
        switch (fileFormat) {
            case TXT:
                return new TxtLogFileCreator();
            case CSV:
                return new CsvLogFileCreator();
            default:
                throw new RuntimeException("File format not supported");
        }
    }
}