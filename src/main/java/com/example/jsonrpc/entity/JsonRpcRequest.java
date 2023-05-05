package com.example.jsonrpc.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JsonRpcRequest {
    private String jsonrpc;
    private String method;
    private JsonNode params;
    private String id;

    public JsonRpcRequest(String jsonrpc, String method, JsonNode params, String id) {
        this.jsonrpc = jsonrpc;
        this.method = method;
        this.params = params;
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public JsonNode getParams() {
        return params;
    }

    public void setParams(JsonNode params) {
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//public class JsonRpcRequest {
//    private String jsonrpc;
//    private String method;
//    private List<Object> params;
//    private Object id;
//
//    public JsonRpcRequest() {
//        // Default constructor for Jackson deserialization
//    }
//
//    public String getJsonrpc() {
//        return jsonrpc;
//    }
//
//    public void setJsonrpc(String jsonrpc) {
//        this.jsonrpc = jsonrpc;
//    }
//
//    public String getMethod() {
//        return method;
//    }
//
//    public void setMethod(String method) {
//        this.method = method;
//    }
//
//    public List<Object> getParams() {
//        return params;
//    }
//
//    public void setParams(List<Object> params) {
//        this.params = params;
//    }
//
//    public Object getId() {
//        return id;
//    }
//
//    public void setId(Object id) {
//    }
//    }

