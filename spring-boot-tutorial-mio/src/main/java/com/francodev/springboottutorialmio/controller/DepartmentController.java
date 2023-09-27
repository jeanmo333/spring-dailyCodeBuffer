package com.francodev.springboottutorialmio.controller;

import com.francodev.springboottutorialmio.entity.DepartmentEntity;
import com.francodev.springboottutorialmio.exception.GlobalBadRequestException;
import com.francodev.springboottutorialmio.exception.GlobalNotFoundException;
import com.francodev.springboottutorialmio.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public DepartmentEntity saveDepartment(@Valid @RequestBody DepartmentEntity departmentEntity) throws GlobalBadRequestException {
        LOGGER.info("Inside saveDepartment of DepartmentController");
     return departmentService.saveDepartment(departmentEntity);
    }

    @GetMapping("departments")
    public List<DepartmentEntity> getAllDepartement(){
        return  departmentService.getAllDepartement();
    }

    @GetMapping("departments/{id}")
    public DepartmentEntity getDepartementById(@PathVariable("id") Long departmentId) throws GlobalNotFoundException {
        return  departmentService.getDepartement(departmentId);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartement(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartement(departmentId);
        return "department deleted successfuly";
    }

    @PutMapping("departments/{id}")
    public DepartmentEntity updateDepartement(
                                          @PathVariable("id") Long departmentId,
                                          @RequestBody DepartmentEntity departmentEntity){
      return   departmentService.updateDepartement(departmentId,departmentEntity);
    }


    @GetMapping("/departments/name/{name}")
    public DepartmentEntity fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }


}
