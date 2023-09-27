package com.francodev.springboottutorialmio.service;

import com.francodev.springboottutorialmio.entity.DepartmentEntity;
import com.francodev.springboottutorialmio.exception.GlobalBadRequestException;
import com.francodev.springboottutorialmio.exception.GlobalExceptionHandler;
import com.francodev.springboottutorialmio.exception.GlobalNotFoundException;
import com.francodev.springboottutorialmio.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) throws GlobalBadRequestException {
      String departmentName = departmentEntity.getDepartmentName();
        Optional<DepartmentEntity> department = Optional.ofNullable(departmentRepository.findByDepartmentNameIgnoreCase(departmentName));

        if (department.isPresent()) {
            throw new GlobalBadRequestException("department already existe");
        }

        return departmentRepository.save(departmentEntity);
    }

    @Override
    public List<DepartmentEntity> getAllDepartement() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity getDepartement(Long departmentId) throws GlobalNotFoundException {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);

        if (departmentEntity.isEmpty()) {
            throw new GlobalNotFoundException("department not found");
        }

        return departmentEntity.get();
    }


    @Override
    public void deleteDepartement(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public DepartmentEntity updateDepartement(Long departmentId, DepartmentEntity departmentEntity) {
        DepartmentEntity departmentdb = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(departmentEntity.getDepartmentName()) &&
                !"".equalsIgnoreCase(departmentEntity.getDepartmentName())) {
            departmentdb.setDepartmentName(departmentEntity.getDepartmentName());
        };



        if (Objects.nonNull(departmentEntity.getDepartmentCode()) &&
                !"".equalsIgnoreCase(departmentEntity.getDepartmentCode())) {
            departmentdb.setDepartmentCode(departmentEntity.getDepartmentCode());
        }

        if (Objects.nonNull(departmentEntity.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(departmentEntity.getDepartmentAddress())) {
            departmentdb.setDepartmentAddress(departmentEntity.getDepartmentAddress());
        }
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentEntity getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}
