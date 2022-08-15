package com.poornima.writerapplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poornima.writerapplication.implementation.FileWriter;
import com.poornima.writerapplication.implementation.GeneralServiceImpl;
import com.poornima.writerapplication.service.GenearlService;
import com.poornima.writerapplication.service.IWriterService;
import com.poornima.writerapplication.valueobject.Operation;
import com.poornima.writerapplication.valueobject.Request;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FileWriterController.class)
class FileWriterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    FileWriter fileWriter;

    @Qualifier("fileWriter")
    @MockBean
    IWriterService iWriterService;

    @MockBean
    GenearlService genearlService;


    @Test
    void writeToFile() throws Exception {
        String write= "mock file writer";
        List<Operation> listOp = new ArrayList<>();
        Operation op = new Operation();
        op.setName("toUpperCase");
        listOp.add(op);
        Request req = new Request();
        req.setWriteString(write);
        req.setOperations(listOp);
        String inputJson = mapToJson(req);
        when(genearlService.generalOperation(write,op)).thenReturn("MOCK FILE WRITER");
        when(iWriterService.writer(write, listOp)).thenReturn("filePath");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/FileWriter/Writer")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson))
                .andExpect(status().isOk());
    }

    @Test
    void readFromFile() throws Exception {
        String fileName = "Test.txt";
        when(fileWriter.readFromFile(fileName)).thenReturn("MOCK FILE WRITER");
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/FileWriter/reader/Test.txt")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                        .andExpect(status().isOk());
    }

    @Test
     void close() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/FileWriter/close")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}