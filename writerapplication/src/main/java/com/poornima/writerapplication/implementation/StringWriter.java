package com.poornima.writerapplication.implementation;

import com.poornima.writerapplication.service.GenearlService;
import com.poornima.writerapplication.service.IWriterService;
import com.poornima.writerapplication.valueobject.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StringWriter implements IWriterService {

    @Autowired
    GenearlService genearlService;

    @Override
    public String writer(String str, List<Operation> operationList) {
        if (!operationList.isEmpty()) {
            for (Operation op : operationList) {
                str = genearlService.generalOperation(str, op);
            }
        }
        return str;
    }

    public String readFromString(String str){

        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append(str);
        return contentBuilder.toString();
    }
}
