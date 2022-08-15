package com.poornima.writerapplication.implementation;

import com.poornima.writerapplication.service.GenearlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(StringWriter.class)
class StringWriterTest {

    @MockBean
    StringWriter stringWriter;

    @BeforeEach
    void setUp() {
        stringWriter = new StringWriter();
        Mockito.mock(GenearlService.class);
    }

    @Test
    void close() {
        boolean result = false;
        result = stringWriter.close();
        assertTrue(result);
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