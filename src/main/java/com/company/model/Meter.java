package com.company.model;

import javax.persistence.*;

@Entity(name = "meter")
public class Meter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int value;
    @Column
    private int user_id;

    public Meter(int user_id) {
        this.user_id = user_id;
        this.value = 0;
    }

    public Meter(int id, int value, int user_id) {
        this.id = id;
        this.value = value;
        this.user_id = user_id;
    }

    public Meter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user) {
        this.user_id = user;
    }
}
