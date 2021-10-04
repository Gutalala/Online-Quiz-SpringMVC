package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "questions", schema = "onlinequiz", catalog = "")
public class QuestionsHB {

    @OneToMany(mappedBy = "quiz_questionsHB")
    private List<QuizHasQuestionsHB> quizHasQuestionsHB = new ArrayList<QuizHasQuestionsHB>();

    public List<QuizHasQuestionsHB> getQuizHasQuestionsHB() {
        return quizHasQuestionsHB;
    }

    public void setQuizHasQuestionsHB(List<QuizHasQuestionsHB> quizHasQuestionsHB) {
        this.quizHasQuestionsHB = quizHasQuestionsHB;
    }


    @OneToMany(mappedBy = "answer_questionsHB", fetch = FetchType.EAGER)
    private List<AnsweroptionsHB> answeroptionsHB = new ArrayList<AnsweroptionsHB>();

    public List<AnsweroptionsHB> getAnsweroptionsHB() {
        return answeroptionsHB;
    }

    public void setAnsweroptionsHB(List<AnsweroptionsHB> answeroptionsHB) {
        this.answeroptionsHB = answeroptionsHB;
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
    @Column(name = "questionText", columnDefinition = "TEXT")
    private String questionText;

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
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
    @Column(name = "isActive", columnDefinition = "BIT", length = 1)
    private Byte isActive;

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionsHB that = (QuestionsHB) o;

        if (id != that.id) return false;
        if (questionText != null ? !questionText.equals(that.questionText) : that.questionText != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (questionText != null ? questionText.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }
}
