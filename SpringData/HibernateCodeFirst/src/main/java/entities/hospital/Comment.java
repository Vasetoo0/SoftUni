package entities.hospital;

import entities.BaseEntity;

import javax.persistence.*;

//@Entity
//@Table(name = "comments")
public class Comment extends BaseEntity {

    private String comment;
    private Visitation visitation;
    private Diagnose diagnose;

    public Comment() {
    }

    @Column(name = "comment",nullable = false,length = 2000)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn(name = "visitation_id",referencedColumnName = "id")
    public Visitation getVisitation() {
        return visitation;
    }

    public void setVisitation(Visitation visitation) {
        this.visitation = visitation;
    }

    @ManyToOne
    @JoinColumn(name = "diagnose_id",referencedColumnName = "id")
    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }
}
