package entities.hospital;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "medicaments")
public class Medicament extends BaseEntity {

    private String name;

    public Medicament() {
    }

    @Column(name = "name",length = 50,nullable = false,unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
