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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(StringWriter.class)
class StringWriterTest {
    @MockBean
    GenearlService genearlService;
    @Test
    void writer() {
//        StringWriter stringWriter = new StringWriter();
//        String write= "mock String writer";
//        List<Operation> listOp = new ArrayList<>();
//        Operation op = new Operation();
//        op.setName("toUpperCase");
//        listOp.add(op);
//        String result = "";
//        when(genearlService.generalOperation(write,op)).thenReturn("MOCK FILE WRITER");
//        genearlService = new GeneralServiceImpl();
//        result = stringWriter.writer(write,listOp);
//        assertEquals(result,"MOCK FILE WRITER");
    }

    @Test
    void readFromString() {
        String write= "mock String writer";
        String result = "";
        StringWriter stringWriter = new StringWriter();
        result = stringWriter.readFromString(write);
        assertEquals(result,write);
    }
}