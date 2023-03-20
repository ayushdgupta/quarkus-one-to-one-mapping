package org.guptaji.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private String IFSCCode;
    private String branch;

    // if we use below annotation as it is then we will get 4 tables in db person, bank, bank_person and person_bank
    // two extra tables will be created to persist many to many relation bcz both person and bank entity used
    // @ManyToMany annotation to handled many to many relation so in one table we need to command that plz don't
    // create an extra table other entity already taking care of that and that can be done by adding 'mappedBy' in
    // many to many annotation. let stop our bank entity this time.
//    @ManyToMany
//    private List<Person> personList = new ArrayList<>();

    @ManyToMany(mappedBy = "bankList")
    private List<Person> personList = new ArrayList<>();

    public Bank(int id, String name, String IFSCCode, String branch, List<Person> personList) {
        this.id = id;
        this.name = name;
        this.IFSCCode = IFSCCode;
        this.branch = branch;
        this.personList = personList;
    }

    public Bank() {
        // default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
