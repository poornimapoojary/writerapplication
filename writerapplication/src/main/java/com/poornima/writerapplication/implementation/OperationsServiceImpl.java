package com.poornima.writerapplication.implementation;

import com.poornima.writerapplication.service.OperationsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

@Component
public class OperationsServiceImpl implements OperationsService {
    @Override
    public String toLowerCase(String str) {
        if(str!=null){
            return str.toLowerCase();
        }
        return null;
    }

    @Override
    public String toUpperCase(String str) {
        if(str!=null){
            return str.toUpperCase();
        }
        return null;
    }

    @Override
    public String stupidRemover(String str) {
        if(str!=null){
            return str.replace("stupid","s*****");
        }
        return null;
    }

    @Override
    public String duplicateRemover(String str) {
        if(str!=null){
            String result;
            List<String> list = new ArrayList<>(Arrays.asList(str.split("\\s")));
            TreeSet<String> seen = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
            list.removeIf(s -> !seen.add(s));
            result = String.join(" ", list);
            return result;
        }
        return null;
    }
}
