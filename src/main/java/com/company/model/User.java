package com.company.model;

import javax.persistence.*;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private int id;
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column
    private String login;
    @Column
    private String passwd;
    @Column
    private  String name;
    @Column
    private String surname;
    @Column
    private String address;
    @Column
    private int phone;
    @Column
    private int contractCost;

    public User(int id, Role role, String login, String passwd, String name, String surname, String address, int phone, int contractCost) {
        this.id = id;
        this.role = role;
        this.login = login;
        this.passwd = passwd;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.contractCost = contractCost;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getContractCost() {
        return contractCost;
    }

    public void setContractCost(int contractCost) {
        this.contractCost = contractCost;
    }

    public enum Role {
        ADMIN,
        OPERAT,
        USER
    }

}
