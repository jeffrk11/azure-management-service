package com.socialsoul.base.model;

public class ErrorMessage {
    private String timestamp;
    private String error;

    
    public ErrorMessage(String timestamp, String error) {
        this.timestamp = timestamp;
        this.error = error;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
}
