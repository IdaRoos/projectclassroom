package com.idaroos.projectclassroom.dao;

import com.idaroos.projectclassroom.entity.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Integer> {
}
