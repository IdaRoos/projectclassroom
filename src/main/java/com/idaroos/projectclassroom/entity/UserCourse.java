package com.idaroos.projectclassroom.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_course")
public class UserCourse {

    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private Account account;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;


    public UserCourse(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "UserCourse{" +
                "id=" + id +
                '}';
    }
}
