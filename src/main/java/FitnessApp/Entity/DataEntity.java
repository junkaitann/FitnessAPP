package FitnessApp.Entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "DataEntity")
public class DataEntity {

    @Id
    private Integer Id;
    private String Exercise;
    private String Type;
    private String Category;
    private Integer Score;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getExercise() {
        return Exercise;
    }

    public void setExercise(String exercise) {
        Exercise = exercise;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Integer getScore() {
        return Score;
    }

    public void setScore(Integer score) {
        Score = score;
    }

}