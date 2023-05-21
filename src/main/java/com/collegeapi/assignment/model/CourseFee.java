package com.collegeapi.assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CourseFee {
    @Id
    private String id;
    private double courseFee;

    public CourseFee() {
    }

    public CourseFee(String id, double courseFee) {
        this.id = id;
        this.courseFee = courseFee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }
}
