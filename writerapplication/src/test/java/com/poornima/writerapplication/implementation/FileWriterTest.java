package com.poornima.writerapplication.implementation;

import com.poornima.writerapplication.service.GenearlService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@WebMvcTest(FileWriter.class)
class FileWriterTest {
    @MockBean
    FileWriter fileWriter;

    @BeforeEach
    void setUp() {
        fileWriter = new FileWriter();
        Mockito.mock(GenearlService.class);
    }

    @Test
    void close() {
        boolean result = false;
        result = fileWriter.close();
        assertTrue(result);
    }

    @Test
    void readFromFile() {
        String fileName = "Test";
        String result = "";
        result = fileWriter.readFromFile(fileName);
        assertNotNull(result);
    }
}