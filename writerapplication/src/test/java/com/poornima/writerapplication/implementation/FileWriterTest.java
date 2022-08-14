package com.poornima.writerapplication.implementation;

import com.poornima.writerapplication.service.GenearlService;
import com.poornima.writerapplication.valueobject.Operation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(FileWriter.class)
class FileWriterTest {
    @MockBean
    GenearlService genearlService;
    @Test
    void writer() {
//        FileWriter fileWriter = new FileWriter();
//        String write = "mock file writer";
//        List<Operation> listOp = new ArrayList<>();
//        Operation op = new Operation();
//        op.setName("toUpperCase");
//        listOp.add(op);
//        when(genearlService.generalOperation(write,op)).thenReturn("MOCK FILE WRITER");
//        String result = fileWriter.writer(write,listOp);
//        assertEquals(result, null);
    }

    @Test
    void readFromFile() {
        FileWriter fileWriter = new FileWriter();
        String fileName = "Test";
        String result = "";
        result = fileWriter.readFromFile(fileName);
        assertNotNull(result);
    }
}