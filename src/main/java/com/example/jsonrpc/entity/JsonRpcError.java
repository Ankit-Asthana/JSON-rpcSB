package com.example.jsonrpc.entity;

import lombok.Data;

@Data
public class JsonRpcError {
    private JsonRpcErrorCode code;
    private String message;

    public JsonRpcErrorCode getCode() {
        return code;
    }

    public void setCode(JsonRpcErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonRpcError(JsonRpcErrorCode code) {
        this.code = code;
        this.message = message;
    }

    //    public JsonRpcError(JsonRpcErrorCode internalError, String message) {
//    }

//    public JsonRpcError(JsonRpcErrorCode methodNotFound) {
//    }

    // constructor, getters and setters
}
