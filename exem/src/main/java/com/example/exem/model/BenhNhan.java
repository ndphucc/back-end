package com.example.exem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BenhNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "benhNhan")
    @JsonIgnore
    private Set<BenhAn> benhAn;

    public BenhNhan() {
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

    public Set<BenhAn> getBenhAn() {
        return benhAn;
    }

    public void setBenhAn(Set<BenhAn> benhAn) {
        this.benhAn = benhAn;
    }
}
