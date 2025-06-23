package com.example.pratice.services;

import com.example.pratice.controller.HelloController;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SquareService {

    public int squareNum(int num)
    {
        return num * num;
    }
}
