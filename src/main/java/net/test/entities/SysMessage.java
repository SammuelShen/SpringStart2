package net.test.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="SysMessage")
public class SysMessage extends ManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",nullable = false,columnDefinition = "BIGINT(20)")
    private long id;

    @Column(name ="SenderId",nullable = false,columnDefinition = "BIGINT(20)")
    private long senderId;

    @OneToMany(fetch = FetchType.EAGER)
    //@JoinColumn(name = "Recipient")
//    @JoinTable(name="Recipient",
//            joinColumns = { @JoinColumn(name ="Id",referencedColumnName ="Id" )},
//            inverseJoinColumns = {@JoinColumn(name="Recipient_Id",referencedColumnName = "Id")})
    private List<Recipient> recipients;

    @Column(name="Content",nullable = false,columnDefinition = "VARCHAR(100)")
    private String content;

    @Enumerated(value=EnumType.STRING)
    @Column(name="status",nullable = false,columnDefinition = "VARCHAR(10) DEFAULT 'Unread'")
    private MessageStatus status;

    public SysMessage() {
        this.recipients = new ArrayList<Recipient>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public List<Recipient> getRecipients() {
        return recipients;
    }

     public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
