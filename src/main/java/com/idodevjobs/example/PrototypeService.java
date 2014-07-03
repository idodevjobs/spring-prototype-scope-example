package com.idodevjobs.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeService {
    public String getMessage(String message) {
        return "Hello " + message;
    }
}