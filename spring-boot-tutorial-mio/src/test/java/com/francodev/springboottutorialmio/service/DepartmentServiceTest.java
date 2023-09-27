package com.francodev.springboottutorialmio.service;

import com.francodev.springboottutorialmio.entity.DepartmentEntity;
import com.francodev.springboottutorialmio.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        DepartmentEntity departmentEntity =
                DepartmentEntity.builder()
                        .departmentName("dep 87")
                        .departmentAddress("dep8 434")
                        .departmentCode("567")
                        .departmentId(1L)
                        .build();
        Mockito.when(departmentRepository.findByDepartmentName("dep 87"))
                .thenReturn(departmentEntity);
    }

    @Test
    @DisplayName("Get Data based on Valida Department Name")
    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "dep 87";
        DepartmentEntity found =
                departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}