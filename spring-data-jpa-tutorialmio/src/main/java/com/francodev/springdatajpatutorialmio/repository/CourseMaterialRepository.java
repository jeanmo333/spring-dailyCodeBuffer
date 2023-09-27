package com.francodev.springdatajpatutorialmio.repository;

import com.francodev.springdatajpatutorialmio.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}