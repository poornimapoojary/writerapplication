package com.poornima.writerapplication.service;

import com.poornima.writerapplication.valueobject.Operation;
import org.springframework.stereotype.Service;

@Service
public interface GenearlService {
    public String generalOperation(String str,Operation op);
}
