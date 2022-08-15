package com.poornima.writerapplication.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poornima.writerapplication.implementation.FileWriter;
import com.poornima.writerapplication.implementation.StringWriter;
import com.poornima.writerapplication.service.GenearlService;
import com.poornima.writerapplication.service.IWriterService;
import com.poornima.writerapplication.valueobject.Operation;
import com.poornima.writerapplication.valueobject.Request;
import com.poornima.writerapplication.valueobject.Response;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StringWriterController.class)
class StringWriterControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StringWriter stringWriter;

    @Qualifier("stringWriter")
    @MockBean
    IWriterService iWriterService;

    @MockBean
    GenearlService genearlService;
    @MockBean
    Response response;
    @Test
    void writeToString() throws Exception {
        String write= "mock string writer";
        List<Operation> listOp = new ArrayList<>();
        Operation op = new Operation();
        op.setName("toUpperCase");
        listOp.add(op);
        Request req = new Request();
        req.setWriteString(write);
        req.setOperations(listOp);
        String inputJson = mapToJson(req);
        when(genearlService.generalOperation(write,op)).thenReturn("MOCK STRING WRITER");
        when(iWriterService.writer(write, listOp)).thenReturn("MOCK STRING WRITER");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/StringWriter/Writer")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson))
                        .andExpect(status().isOk());
    }

    @Test
    void readFromFile() throws Exception {
        Response response = new Response();
        response.setStringWriter("test response string");
        String inputJson = mapToJson(response);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/StringWriter/reader")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson))
                .andExpect(status().isOk());
    }

    @Test
    void close() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/StringWriter/close")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}