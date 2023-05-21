package com.collegeapi.assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class College {
    @Id
    private String id;
    private String collegeName;
    private String courseName;
    private String durationOfCourse;
    private String accommodationAC_NONAC;
    private double accommodationFee;
    private String courseFeeId;

    public College() {
    }

    public College(String id, String collegeName, String courseName, String durationOfCourse, String accommodation, double accommodationFee, String courseFeeId) {
        this.id = id;
        this.collegeName = collegeName;
        this.courseName = courseName;
        this.durationOfCourse = durationOfCourse;
        this.accommodationAC_NONAC = accommodation;
        this.accommodationFee = accommodationFee;
        this.courseFeeId = courseFeeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDurationOfCourse() {
        return durationOfCourse;
    }

    public void setDurationOfCourse(String durationOfCourse) {
        this.durationOfCourse = durationOfCourse;
    }

    public String getAccommodation() {
        return accommodationAC_NONAC;
    }

    public void setAccommodation(String accommodation) {
        this.accommodationAC_NONAC = accommodation;
    }

    public double getAccommodationFee() {
        return accommodationFee;
    }

    public void setAccommodationFee(double accommodationFee) {
        this.accommodationFee = accommodationFee;
    }

    public String getCourseFeeId() {
        return courseFeeId;
    }

    public void setCourseFeeId(String courseFeeId) {
        this.courseFeeId = courseFeeId;
    }

    public void setCourseFee(CourseFee courseFee) {
    }
}
