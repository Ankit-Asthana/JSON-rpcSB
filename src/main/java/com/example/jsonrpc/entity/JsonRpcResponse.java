package com.example.jsonrpc.entity;

import com.example.jsonrpc.entity.JsonRpcError;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class JsonRpcResponse {
    private String jsonrpc = "2.0";
    private JsonNode result;
    private JsonRpcError error;
    private String id;

    public JsonRpcResponse() {

    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public void setResult(JsonNode result) {
        this.result = result;
    }

    public void setError(JsonRpcError error) {
        this.error = error;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public JsonNode getResult() {
        return result;
    }

    public JsonRpcError getError() {
        return error;
    }

    public String getId() {
        return id;
    }

    public JsonRpcResponse(String jsonrpc, JsonNode result, JsonRpcError error, String id) {
        this.jsonrpc = jsonrpc;
        this.result = result;
        this.error = error;
        this.id = id;
    }


    // getters and setters
}
