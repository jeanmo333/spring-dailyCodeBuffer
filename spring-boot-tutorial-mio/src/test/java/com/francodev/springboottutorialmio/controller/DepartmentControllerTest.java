package com.francodev.springboottutorialmio.controller;

import com.francodev.springboottutorialmio.entity.DepartmentEntity;
import com.francodev.springboottutorialmio.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private DepartmentEntity department;

    @BeforeEach
    void setUp() {
        department = DepartmentEntity.builder()
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }

//    @Test
//    void saveDepartment() throws Exception {
//        DepartmentEntity inputDepartment = DepartmentEntity.builder()
//                .departmentAddress("Ahmedabad")
//                .departmentCode("IT-06")
//                .departmentName("IT")
//                .build();
//
//        Mockito.when(departmentService.saveDepartment(inputDepartment))
//                .thenReturn(department);
//
//        mockMvc.perform((RequestBuilder) post("/departments")
//                        .contentType(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.valueOf("{\n" +
//                                "\t\"departmentName\":\"IT\",\n" +
//                                "\t\"departmentAddress\":\"Ahmedabad\",\n" +
//                                "\t\"departmentCode\":\"IT-06\"\n" +
//                                "}")))
//                .andExpect(status().isOk());
//
//    }


    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartement(1L))
                .thenReturn(department);

        mockMvc.perform((RequestBuilder) get("/departments/1")
                .contextPath(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.departmentName").
                        value(department.getDepartmentName()));
    }
}