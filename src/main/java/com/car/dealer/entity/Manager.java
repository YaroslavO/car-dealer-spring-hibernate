package com.car.dealer.entity;

import org.hibernate.annotations.Formula;

import javax.persistence.*;

/**
 * Created by Yaroslav on 31.05.2015.
 */

@Entity
public class Manager implements Comparable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary_for_one_sale")
    private Double salaryForOneSale;

    public Manager() {
    }

    public Manager(String firstName, String lastName, Double salaryForOneSale) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salaryForOneSale = salaryForOneSale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalaryForOneSale() {
        return salaryForOneSale;
    }

    public void setSalaryForOneSale(Double salaryForOneSale) {
        this.salaryForOneSale = salaryForOneSale;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }

    @Override
    public int compareTo(Object o) {
        Manager otherManager = ((Manager) o);
        int result = 0;

        result += (salaryForOneSale == otherManager.getSalaryForOneSale()) ? 0 : 1;
        result += (firstName.compareTo(otherManager.getFirstName()) == 0) ? 0 : 1;
        result += (lastName.compareTo(otherManager.getLastName()) == 0) ? 0 : 1;

        return result;
    }
}
