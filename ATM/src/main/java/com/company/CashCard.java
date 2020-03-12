package com.company;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "CashCard")
@XmlType(propOrder = {"id", "password", "balance"})
@XmlAccessorType(XmlAccessType.FIELD)

public class CashCard {

    @XmlElement
    private String id;
    @XmlElement
    private String password;
    @XmlElement
    private int balance;

    public CashCard ( final String id, final String password, final int balance ) {
        this.id = id;
        this.password = password;
        this.balance = balance;
    }

    public CashCard () {
    }

    public String getId () {
        return id;
    }

    public void setId ( final String id ) {
        this.id = id;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( final String password ) {
        this.password = password;
    }

    public int getBalance () {
        return balance;
    }

    public void setBalance ( final int balance ) {
        this.balance = balance;
    }


    public void addMoney(int money){
        this.balance += money;

    }
    public void takeMoney(int money){
        this.balance -=money;
    }

    @Override
    public String toString () {
        return "CashCard{" +
                "id='" + id + '\'' +
                ", password=" + password +
                ", balance=" + balance +
                '}';
    }
}
