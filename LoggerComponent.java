package com.example.pratice.services;

import org.springframework.stereotype.Component;

@Component
public class LoggerComponent {
    public void log(String message)
    {
        System.out.println("[LOG] " + message);
    }
}
