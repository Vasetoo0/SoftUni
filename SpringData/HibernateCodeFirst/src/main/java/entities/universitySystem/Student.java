package entities.universitySystem;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "students")
public class Student extends Person {


    private Double avgGrade;
    private String attendance;
    private Set<Course> courses;

    public Student() {
    }

    @Column(name = "avg_grade",nullable = false)
    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Column(name = "attendace",nullable = false)
    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
