package com.arpan.logging.filecreator;

import java.io.File;
import java.util.List;

import com.arpan.Operation;

public interface LogFileCreator {
    File createLogFile (List<Operation> operationList);
}