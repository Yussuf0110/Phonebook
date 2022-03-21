package africa.semicolon.phoneBook.data.models;

import java.time.LocalDateTime;

public class Status {
    private final LocalDateTime timeCreated = LocalDateTime.now();
    private String status;

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
