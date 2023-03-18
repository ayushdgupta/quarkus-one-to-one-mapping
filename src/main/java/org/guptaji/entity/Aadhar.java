package org.guptaji.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long aadharNo;
    private String company;

    // one to one mapping -- here we are saving Citizen table's primary key into aadhar table to identify the
    // citizen to whome aadhar belongs.
    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    private Citizen citizen;

    public Aadhar(long id, long aadharNo, String company, Citizen citizen) {
        this.id = id;
        this.aadharNo = aadharNo;
        this.company = company;
        this.citizen = citizen;
    }

    public Aadhar() {
        // default constructor
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(long aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
