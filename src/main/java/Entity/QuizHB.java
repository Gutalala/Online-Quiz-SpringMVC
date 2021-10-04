package Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "quiz", schema = "onlinequiz", catalog = "")
public class QuizHB {

    @OneToMany(mappedBy = "quizHB")
    private List<QuizHasQuestionsHB> quizHasQuestionsHB = new ArrayList<QuizHasQuestionsHB>();

    public List<QuizHasQuestionsHB> getQuizHasQuestionsHB() {
        return quizHasQuestionsHB;
    }

    public void setQuizHasQuestionsHB(List<QuizHasQuestionsHB> quizHasQuestionsHB) {
        this.quizHasQuestionsHB = quizHasQuestionsHB;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Users_id")
    private UsersHB usersHB;

    public UsersHB getUsersHB() {
        return usersHB;
    }

    public void setUsersHB(UsersHB usersHB) {
        this.usersHB = usersHB;
    }


    @Id
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quiz_name")
    private String quizName;

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    @Basic
    @Column(name = "category")
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "start_time")
    private Timestamp startTime;

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    private Timestamp endTime;

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "score")
    private Integer score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuizHB quizHB = (QuizHB) o;

        if (id != quizHB.id) return false;
        if (quizName != null ? !quizName.equals(quizHB.quizName) : quizHB.quizName != null) return false;
        if (category != null ? !category.equals(quizHB.category) : quizHB.category != null) return false;
        if (startTime != null ? !startTime.equals(quizHB.startTime) : quizHB.startTime != null) return false;
        if (endTime != null ? !endTime.equals(quizHB.endTime) : quizHB.endTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (quizName != null ? quizName.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }
}
