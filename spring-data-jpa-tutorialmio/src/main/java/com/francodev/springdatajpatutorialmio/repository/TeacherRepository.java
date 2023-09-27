package com.francodev.springdatajpatutorialmio.repository;

import com.francodev.springdatajpatutorialmio.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
