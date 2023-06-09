package com.idaroos.projectclassroom.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="course_name")
    private String courseName;

    @OneToMany(mappedBy = "course",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    private List<UserCourse> userCourseList;

    @OneToMany(mappedBy = "course",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<UserGrade> userGradeList;


    // define constructors

    public Course() {

    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    // Define getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<UserCourse> getUserCourseList() {
        return userCourseList;
    }

    public void setUserCourseList(List<UserCourse> userCourseList) {
        this.userCourseList = userCourseList;
    }

    public List<UserGrade> getUserGradeList() {
        return userGradeList;
    }

    public void setUserGradeList(List<UserGrade> userGradeList) {
        this.userGradeList = userGradeList;
    }

    // Define StringMethod


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
