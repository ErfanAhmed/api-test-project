package com.example.apiUsage.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    @CreationTimestamp
    private Date created;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_detail_id")
    private List<ExchangeRateDetail> exchangeRateDetails;

    public UserDetail() {
        exchangeRateDetails = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<ExchangeRateDetail> getExchangeRateDetails() {
        return exchangeRateDetails;
    }

    public void setExchangeRateDetails(List<ExchangeRateDetail> exchangeRateDetails) {
        this.exchangeRateDetails = exchangeRateDetails;
    }
}
