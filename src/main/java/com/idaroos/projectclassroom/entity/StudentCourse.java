package com.idaroos.projectclassroom.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_course")
public class StudentCourse {

// define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "grade")
    private String grade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private Account account;

    // define constructors

    public StudentCourse() {

    }

    public StudentCourse(String grade) {
        this.grade = grade;
    }

    // define getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    // define stringMethod
    @Override
    public String toString() {
        return "UserGrade{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                '}';
    }
}
