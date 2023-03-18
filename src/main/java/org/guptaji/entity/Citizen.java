package org.guptaji.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String city;
    private String gender;

    // Here we used mappedBy = "citizen" because if we will not use this then in database in citizen table
    // another field with aadhar_id will be added which will contain aadhar_id for the corresponding person
    // but same kind of information we already stored in our aadhar table so there is no need to crate another
    // field in citizen table while we can achieve this functionality using JAVA Hibernate ORM 'mappedBy'
    // with this JAVA can internally fetch aadhar info for the corresponding person without storing an extra
    // field into the table.

    // Here default value of FetchType is LAZY i.e. whenever citizen data will be fetched it'll not gives you
    // aadhar data bydefault but if the fetch type is set to EAGER then aadhar info will also come in response
    // along with the citizen data.

    // to avoid the infinite loop we will use @JsonManagedReference and @JsonBackReference
    // Here we want to save aadhar data along with the citizen data for that we are using CascadeType.ALL
    @JsonManagedReference
    @OneToOne(mappedBy = "citizen", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Aadhar aadhar;

    public Citizen(long id, String name, String city, String gender, Aadhar aadhar) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.aadhar = aadhar;
    }

    public Citizen() {
        // default constructor
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Aadhar getAadhar() {
        return aadhar;
    }

    public void setAadhar(Aadhar aadhar) {
        this.aadhar = aadhar;
    }
}
