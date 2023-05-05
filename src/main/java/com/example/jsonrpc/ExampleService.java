//package com.example.jsonrpc;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.asm.TypeReference;
//
//import java.util.List;
//
//public class ExampleService {
//    public int add(JsonNode paramsNode) {
//        ObjectMapper mapper = new ObjectMapper();
//        List<Integer> params = mapper.convertValue(paramsNode, new TypeReference<List<Integer>>() {});
//
//        int sum = 0;
//        for (Integer param : params) {
//            sum += param;
//        }
//        return sum;
//    }
//}
//
