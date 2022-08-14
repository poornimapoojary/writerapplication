package com.poornima.writerapplication.implementation;

import com.poornima.writerapplication.service.GenearlService;
import com.poornima.writerapplication.service.OperationsService;
import com.poornima.writerapplication.valueobject.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralServiceImpl implements GenearlService {
    @Autowired
    OperationsService operationsService;

    @Override
    public String generalOperation(String str, Operation op) {
        switch (op.getName()) {
            case "toLowerCase":
                str = operationsService.toLowerCase(str);
                break;
            case "toUpperCase":
                str = operationsService.toUpperCase(str);
                break;
            case "stupidRemover":
                str = operationsService.stupidRemover(str);
                break;
            case "duplicateRemover":
                str = operationsService.duplicateRemover(str);
                break;
            default:
                throw new IllegalArgumentException("Invalid Operation: " + op.getName());
        }
        return str;
    }
}
