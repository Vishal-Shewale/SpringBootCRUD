package com.example.FirstYoutube.service;

import com.example.FirstYoutube.Error.DepartmentNotFoundException;
import com.example.FirstYoutube.entity.Departments;

import java.util.List;

public interface DepartmentService {
     public String saveDepartment(Departments departments);

     public List<Departments> getData();

    public Departments findByDeptId(Long departmentId) throws DepartmentNotFoundException;

    public void deleteByDeptId(Long departmentId);

    public Departments updateDepartment(Long departmentId, Departments departments);

    public Departments fetchDepartmentByName(String departmentName);

    public  Departments fetchDepartmentByAddress(String departmentAddress);
}
