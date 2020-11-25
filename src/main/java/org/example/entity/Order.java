package org.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private Long id;
    @Column
    private String ordername;
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date registrationData;
    @Column
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creatureDate;
    @Column
    private String orderComment;
    /*@Column(name = "created by")
    private Long idOfCreature;*/
    /*@Column(name = "deleted by")
    private Long idOfRemoved;*/

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
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

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }
/*
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
    }*/

}
