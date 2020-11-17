package org.example.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private Date registrationData;
    @Column
    private Date creatureDate;
    @Column
    private String comment;
    @Column(name = "created")
    private Long idOfCreature;
    @Column(name = "deleted")
    private Long idOfRemoved;

    @ManyToOne(optional=false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private User users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationData() {
        return registrationData;
    }

    public void setRegistrationData(Date registrationData) {
        this.registrationData = registrationData;
    }

    public Date getCreatureDate() {
        return creatureDate;
    }

    public void setCreatureDate(Date creatureDate) {
        this.creatureDate = creatureDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getIdOfCreature() {
        return idOfCreature;
    }

    public void setIdOfCreature(Long idOfCreature) {
        this.idOfCreature = idOfCreature;
    }

    public Long getIdOfRemoved() {
        return idOfRemoved;
    }

    public void setIdOfRemoved(Long idOfRemoved) {
        this.idOfRemoved = idOfRemoved;
    }
}
