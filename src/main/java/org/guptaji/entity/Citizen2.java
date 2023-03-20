package org.guptaji.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Citizen2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String city;
    private String gender;

    // if we use simple below syntax then hibernate will simply create three tables in db citizen2, simcard,
    // citizen2_simcard and the third table will contain two fields citizen_id and simcard_id.
//    @OneToMany
//    private Simcard simcard;

    // but we only want to create two tables only citizen2, simcard so we need to add one annotation
    // @ManyToOne in Simcard and 'mappedBy' field in @OneToMany in citizen2.
    // And One citizen can have many simcards that's why we have taken List<Simcards>
    @OneToMany(mappedBy = "citizen2", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Simcard> simcard = new ArrayList<>();

    public Citizen2(int id, String name, String city, String gender, List<Simcard> simcard) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.simcard = simcard;
    }

    public Citizen2() {
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

    public List<Simcard> getSimcard() {
        return simcard;
    }

    public void setSimcard(List<Simcard> simcard) {
        this.simcard = simcard;
    }
}
