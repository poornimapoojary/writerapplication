package com.poornima.writerapplication.service;

import com.poornima.writerapplication.valueobject.Operation;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface IWriterService {
    public String writer(String str, List<Operation> operationList) throws IOException;

    public boolean close();

}
