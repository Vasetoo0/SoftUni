package entities.hospital;

import entities.BaseEntity;
import jdk.jfr.Enabled;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

//@Entity
//@Table(name = "visitations")
public class Visitation extends BaseEntity {

    private LocalDate date;
    private Set<Comment> comments;
    private Patient patient;

    public Visitation() {
    }

    @Column(name = "date",nullable = false)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @OneToMany(mappedBy = "visitation",targetEntity = Comment.class,cascade = CascadeType.ALL)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
