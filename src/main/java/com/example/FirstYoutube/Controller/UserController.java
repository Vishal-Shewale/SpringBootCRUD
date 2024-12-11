package com.example.FirstYoutube.Controller;

import com.example.FirstYoutube.Error.DepartmentNotFoundException;
import com.example.FirstYoutube.entity.Departments;
import com.example.FirstYoutube.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController     {
    // @RequestMapping(value="/",method = RequestMethod.GET)

 //   @RequestParam String departmentName,
  //  @RequestParam String departmentAddress,
   // @RequestParam String departmentCode
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    private String saveDepartments(@Valid @RequestBody Departments departments)
    {
//        Departments departments=new Departments();
//        departments.setDepartmentName(departmentName);
//        departments.setDepartmentAddress(departmentAddress);
//        departments.setDepartmentCode(departmentCode);
      return departmentService.saveDepartment(departments);
    }

    @GetMapping("/departments")
    private List<Departments> fetchDepartments()
    {
        return departmentService.getData();
    }

    @GetMapping("/departments/{id}")
    private Departments findByDeptId(@PathVariable ("id") Long departmentId) throws DepartmentNotFoundException {
            return departmentService.findByDeptId(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    private String deleteById(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteByDeptId(departmentId);
        return "Deleted Succesfully";
    }

    @PutMapping("/departments/{id}")
    private Departments updateDepartment(@PathVariable ("id") Long departmentId,
                                         @RequestBody Departments departments)
    {
        return departmentService.updateDepartment(departmentId,departments);
    }

    @GetMapping("/departments/name/{name}")
    public Departments fetchDepartmentByName(@PathVariable ("name") String departmentName)
    {
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @GetMapping("/departments/address/{address}")
    public Departments fetchDepartmentByAddress(@PathVariable ("address") String departmentAddress)
    {
        return departmentService.fetchDepartmentByAddress(departmentAddress);
    }

}
