package com.collegeapi.assignment.service;

import com.collegeapi.assignment.model.College;
import com.collegeapi.assignment.model.CourseFee;
import com.collegeapi.assignment.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;
    private List<College> collegeList = new ArrayList<>();
    private Map<String, CourseFee> courseFeeMap = new HashMap<>();

    public List<College> getAllColleges() {
        return collegeList;
    }

    public List<College> getCollegesByCourseName(String courseName) {
        List<College> collegesWithCourse = new ArrayList<>();
        for (College college : collegeList) {
            if (college.getCourseName().equalsIgnoreCase(courseName)) {
                collegesWithCourse.add(college);
            }
        }
        return collegesWithCourse;
    }

    public College createCollege(College college) {
        college.setId(UUID.randomUUID().toString());
        collegeList.add(college);
        return college;
    }

    public CourseFee getCourseFee(String courseFeeId) {
        return courseFeeMap.get(courseFeeId);
    }

    public void associateCourseFeeWithCollege(String collegeId, String courseFeeId) {
        College college = findCollegeById(collegeId);
        if (college != null) {
            college.setCourseFee(courseFeeMap.get(courseFeeId));
        }
    }

    private College findCollegeById(String collegeId) {
        for (College college : collegeList) {
            if (college.getId().equals(collegeId)) {
                return college;
            }
        }
        return null;
    }
}
