package org.guptaji.entity;

import javax.persistence.*;

@Entity
public class Simcard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String no;
    private String provider;
    private String isActive;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "citizen2one_id")
    private Citizen2 citizen2;

    public Simcard(int id, String no, String provider, String isActive, Citizen2 citizen2) {
        this.id = id;
        this.no = no;
        this.provider = provider;
        this.isActive = isActive;
        this.citizen2 = citizen2;
    }

    public Simcard() {
        // default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Citizen2 getCitizen2() {
        return citizen2;
    }

    public void setCitizen2(Citizen2 citizen2) {
        this.citizen2 = citizen2;
    }
}
