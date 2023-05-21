package com.collegeapi.assignment.repository;
import com.collegeapi.assignment.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, String> {
    // Add custom query methods if needed
}
