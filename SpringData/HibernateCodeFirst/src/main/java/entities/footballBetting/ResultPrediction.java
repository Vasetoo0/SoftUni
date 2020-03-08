package entities.footballBetting;

import entities.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity {

    private Prediction prediction;
}
