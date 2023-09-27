package com.francodev.springboottutorialmio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
   @NotBlank(message = "please add department name")
//    @Length(max = 5, min = 1, message = "")
    private String departmentName;

    @NotBlank(message = "please add department address")
    private String departmentAddress;
    private String departmentCode;

}
