package com.example.FirstYoutube.service;

import com.example.FirstYoutube.Error.DepartmentNotFoundException;
import com.example.FirstYoutube.entity.Departments;
import com.example.FirstYoutube.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public String saveDepartment(Departments departments) {
        departmentRepository.save(departments);
        return "Data added succesfully";
    }

    @Override
    public List<Departments> getData() {
        return departmentRepository.findAll();
    }

    @Override
    public Departments findByDeptId(Long departmentId) throws DepartmentNotFoundException {
       Optional<Departments> departments= departmentRepository.findById(departmentId);

       if(!departments.isPresent())
       {
           throw new DepartmentNotFoundException("Department is not available");
       }
       return departments.get();
    }

    @Override
    public void deleteByDeptId(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Departments updateDepartment(Long departmentId, Departments departments) {
        Departments depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(departments.getDepartmentName()) &&
                !"".equalsIgnoreCase(departments.getDepartmentName()))
        {
            depDB.setDepartmentName(departments.getDepartmentName());
        }

        if(Objects.nonNull(departments.getDepartmentCode()) &&
                !"".equalsIgnoreCase(departments.getDepartmentCode()))
        {
            depDB.setDepartmentCode(departments.getDepartmentCode());
        }

        if(Objects.nonNull(departments.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(departments.getDepartmentAddress()))
        {
            depDB.setDepartmentAddress(departments.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Departments fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public Departments fetchDepartmentByAddress(String departmentAddress) {
        return departmentRepository.findByDepartmentAddress(departmentAddress);
    }
}
