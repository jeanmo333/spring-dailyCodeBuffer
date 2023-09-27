package com.francodev.springboottutorialmio.service;

import com.francodev.springboottutorialmio.entity.DepartmentEntity;
import com.francodev.springboottutorialmio.exception.GlobalBadRequestException;
import com.francodev.springboottutorialmio.exception.GlobalNotFoundException;

import java.util.List;

public interface DepartmentService {
  public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) throws GlobalBadRequestException;

 public List<DepartmentEntity> getAllDepartement();

  public DepartmentEntity getDepartement(Long departmentId) throws GlobalNotFoundException;

  public void deleteDepartement(Long departmentId);

  public   DepartmentEntity updateDepartement(Long departmentId, DepartmentEntity departmentEntity);

   public DepartmentEntity getDepartmentByName(String departmentName);
}
