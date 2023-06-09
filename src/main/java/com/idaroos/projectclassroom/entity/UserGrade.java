package com.idaroos.projectclassroom.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_grade")
public class UserGrade {

// define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "grade")
    private String grade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private Account accountList;

    // define constructors

    public UserGrade() {

    }

    public UserGrade(String grade) {
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

    public Account getAccountList() {
        return accountList;
    }

    public void setAccountList(Account accountList) {
        this.accountList = accountList;
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
