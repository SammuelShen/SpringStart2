package net.test.entities;

import javax.persistence.*;

@Entity
@Table(name = "Recipient")
public class Recipient extends ManageEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id",nullable = false,columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name="UserId",nullable = false,columnDefinition = "BIGINT(20)")
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
