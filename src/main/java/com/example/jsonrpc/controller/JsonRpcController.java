package com.example.jsonrpc.controller;

import com.example.jsonrpc.entity.JsonRpcError;
import com.example.jsonrpc.entity.JsonRpcErrorCode;
import com.example.jsonrpc.entity.JsonRpcRequest;
import com.example.jsonrpc.entity.JsonRpcResponse;
import com.example.jsonrpc.service.CalculatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.IntNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.googlecode.jsonrpc4j.JsonRpcServer;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/rpc")
//public class JsonRpcController {
//    private final MyService myService;
//    private final ObjectMapper objectMapper;
//
//    public JsonRpcController(MyService myService, ObjectMapper objectMapper) {
//        this.myService = myService;
//        this.objectMapper = objectMapper;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> handleRequest(@RequestBody String requestBody) throws Exception {
//        JsonNode requestJson = objectMapper.readTree(requestBody);
//
//        JsonRpcServer jsonRpcServer = new JsonRpcServer(objectMapper, myService, MyService.class);
//        String responseJson = jsonRpcServer.handle(requestJson);
//
//        return ResponseEntity.ok(responseJson);
//    }
//}
//
@RestController
@RequestMapping("/rpc")
public class JsonRpcController {

    private final CalculatorService calculatorService;

    public JsonRpcController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping
    public JsonNode handleRequest(@RequestBody String requestBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonRpcRequest jsonRpcRequest = objectMapper.readValue(requestBody, JsonRpcRequest.class);
        JsonRpcResponse jsonRpcResponse = new JsonRpcResponse();
        jsonRpcResponse.setId(jsonRpcRequest.getId());

        try {
            String methodName = jsonRpcRequest.getMethod();
            JsonNode paramsNode = jsonRpcRequest.getParams();
            int a = paramsNode.get(0).asInt();
            int b = paramsNode.get(1).asInt();

            if ("add".equals(methodName)) {
                int result = calculatorService.add(a, b);
                jsonRpcResponse.setResult(new IntNode(result));
            } else if ("subtract".equals(methodName)) {
                int result = calculatorService.subtract(a, b);
                jsonRpcResponse.setResult(new IntNode(result));
            } else {
                jsonRpcResponse.setError(new JsonRpcError(JsonRpcErrorCode.METHOD_NOT_FOUND));
            }
        } catch (Exception e) {
            jsonRpcResponse.setError(new JsonRpcError(JsonRpcErrorCode.INTERNAL_ERROR));
        }

        return objectMapper.valueToTree(jsonRpcResponse);
    }
}
