package com.poornima.writerapplication.controller;

import com.poornima.writerapplication.constants.Constants;
import com.poornima.writerapplication.implementation.FileWriter;
import com.poornima.writerapplication.service.IWriterService;
import com.poornima.writerapplication.valueobject.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/FileWriter")
public class FileWriterController {
    private static final Logger logger = LoggerFactory.getLogger(FileWriterController.class);
    @Qualifier("fileWriter")
    @Autowired
    IWriterService iWriterService;

    @Autowired
    FileWriter fileWriter;

    @PostMapping("/Writer")
    public String writeToFile(@RequestBody Request request) throws IOException {
        logger.info("Writing to File");
        String filePath;
        filePath = iWriterService.writer(request.getWriteString(),request.getOperations());
        return filePath;
    }

    @GetMapping("/reader/{fileName}")
    public String readFromFile(@PathVariable(value = "fileName") String fileName)  {
        logger.info("Reading from file");
        return fileWriter.readFromFile(fileName);
    }

    @GetMapping("/close")
    public String close() {
        logger.info("Close File writer");
        iWriterService.close();
        return Constants.FILE_WRITER_CLOSED;
    }
}
