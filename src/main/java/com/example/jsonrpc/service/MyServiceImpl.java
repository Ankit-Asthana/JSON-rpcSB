package com.example.jsonrpc.service;

import com.example.jsonrpc.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
//@JsonRpcService("")
public class MyServiceImpl implements CalculatorService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}

