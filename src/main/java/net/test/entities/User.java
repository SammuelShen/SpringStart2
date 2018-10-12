package net.test.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="user")
public class User {
    @Id
   @Column(name = "Id",nullable = false,columnDefinition = "BIGINT(20)")
    private long id;
//    @Version
//    private int version;
    @Column(name="LogonName",nullable = false,columnDefinition = "VARCHAR(20)")
    private String logonName;
    @Column(name = "SecurityIdentity",nullable = false,columnDefinition = "VARCHAR(100)")
    private String securityIdentity;

    @Column(name = "CreatedDateTime",nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdDateTime;

    @Column(name="LastModifiedDateTime",nullable = false,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime lastModifiedDateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogonName() {
        return logonName;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    public String getSecurityIdentity() {
        return securityIdentity;
    }

    public void setSecurityIdentity(String securityIdentity) {
        this.securityIdentity = securityIdentity;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }
}
