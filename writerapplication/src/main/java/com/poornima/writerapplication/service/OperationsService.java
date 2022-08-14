package com.poornima.writerapplication.service;

import org.springframework.stereotype.Service;

@Service
public interface OperationsService {

    public String toLowerCase(String str);
    public  String toUpperCase(String str);
    public String stupidRemover(String str);
    public  String duplicateRemover(String str);

}
