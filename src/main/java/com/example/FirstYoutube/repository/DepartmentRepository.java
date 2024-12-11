package com.example.FirstYoutube.repository;

import com.example.FirstYoutube.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments,Long> {
    public Departments findByDepartmentName(String departmentName);
    public Departments findByDepartmentAddress(String departmentAddress);
   

}
