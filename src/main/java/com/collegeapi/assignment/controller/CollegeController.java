package com.collegeapi.assignment.controller;

import com.collegeapi.assignment.model.College;
import com.collegeapi.assignment.model.CourseFee;
import com.collegeapi.assignment.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/colleges")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;
    private final List<College> collegeList = new ArrayList<>();
    private final Map<String, CourseFee> courseFeeMap = new HashMap<>();

    // GET /colleges
    @GetMapping
    public List<College> getAllColleges() {
        return collegeList;
    }

    // GET /colleges/{course_name}
    @GetMapping("/{course_name}")
    public List<College> getCollegesByCourseName(@PathVariable("course_name") String courseName) {
        List<College> collegesWithCourse = new ArrayList<>();
        for (College college : collegeList) {
            if (college.getCourseName().equalsIgnoreCase(courseName)) {
                collegesWithCourse.add(college);
            }
        }
        return collegesWithCourse;
    }

    // POST /colleges
    @PostMapping
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        college.setId(UUID.randomUUID().toString());
        collegeList.add(college);
        return ResponseEntity.ok(college);
    }

    // GET /courses/{course_fee_id}/fee
    @GetMapping("/courses/{course_fee_id}/fee")
    public ResponseEntity<CourseFee> getCourseFee(@PathVariable("course_fee_id") String courseFeeId) {
        CourseFee courseFee = courseFeeMap.get(courseFeeId);
        if (courseFee != null) {
            return ResponseEntity.ok(courseFee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Utility method to associate course fee with college
    private void associateCourseFeeWithCollege(College college, String courseFeeId) {
        college.setCourseFeeId(courseFeeId);
    }

    // Utility method to find a college by ID
    private College findCollegeById(String collegeId) {
        for (College college : collegeList) {
            if (college.getId().equals(collegeId)) {
                return college;
            }
        }
        return null;
    }
}
