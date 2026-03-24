package com.saude.consultorioapi;

public class ApiResponse {

    private int statusCode;
    private String statusMessage;
    private String body;

    public ApiResponse(int statusCode, String statusMessage, String body) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.body = body;
    }

    @Override
    public String toString(){
        return "Status: " + statusCode + " (" + statusMessage + ") " + "Body: " + body;
    }
}
