package com.poornima.writerapplication.controller;

import com.poornima.writerapplication.constants.Constants;
import com.poornima.writerapplication.implementation.StringWriter;
import com.poornima.writerapplication.service.IWriterService;
import com.poornima.writerapplication.valueobject.Request;
import com.poornima.writerapplication.valueobject.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/StringWriter")
public class StringWriterController {
    private static final Logger logger = LoggerFactory.getLogger(StringWriterController.class);
    @Qualifier("stringWriter")
    @Autowired
    IWriterService iWriterService;

    @Autowired
    StringWriter stringWriter;

    @Autowired
    Response response;

    @PostMapping("/Writer")
    public Response writeToString(@RequestBody Request request) throws IOException {
        logger.info("Writing to String");
        String result;
        response = new Response();
        result = iWriterService.writer(request.getWriteString(),request.getOperations());
        response.setStringWriter(result);
        return response;
    }
    @GetMapping("/reader")
    public String readFromFile(@RequestBody Response response)  {
        logger.info("Reading from file");
        return stringWriter.readFromString(response.getStringWriter());
    }
    @GetMapping("/close")
    public String close() {
        logger.info("Close String writer");
        iWriterService.close();
        return Constants.STRING_WRITER_CLOSED;
    }
}
