package entities.hospital;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {

    private String name;
    private Set<Comment> comments;
    private Patient patient;

    public Diagnose() {
    }

    @Column(name = "name",length = 50,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "diagnose",targetEntity = Comment.class,cascade = CascadeType.ALL)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToOne(mappedBy = "diagnose",targetEntity = Patient.class)
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
