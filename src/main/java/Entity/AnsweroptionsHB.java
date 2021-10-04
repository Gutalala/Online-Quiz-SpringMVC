package Entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "answeroptions", schema = "onlinequiz", catalog = "")
@IdClass(AnsweroptionsHBPK.class)
public class AnsweroptionsHB {

    @OneToMany(mappedBy = "answeroptionsHB")
    private List<QuizHasQuestionsHB> quizHasQuestionsHB = new ArrayList<QuizHasQuestionsHB>();

    public List<QuizHasQuestionsHB> getQuizHasQuestionsHB() {
        return quizHasQuestionsHB;
    }

    public void setQuizHasQuestionsHB(List<QuizHasQuestionsHB> quizHasQuestionsHB) {
        this.quizHasQuestionsHB = quizHasQuestionsHB;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_question_id")
    private QuestionsHB answer_questionsHB;

    public QuestionsHB getQuestionsHB() {
        return answer_questionsHB;
    }

    public void setQuestionsHB(QuestionsHB questionsHB) {
        this.answer_questionsHB = questionsHB;
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
    @Column(name = "isCorrect", columnDefinition = "BIT", length = 1)
    private Byte isCorrect;

    public Byte getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Byte isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Basic
    @Column(name = "answerText", columnDefinition = "TEXT")
    private String answerText;

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnsweroptionsHB that = (AnsweroptionsHB) o;

        if (id != that.id) return false;
        if (isCorrect != null ? !isCorrect.equals(that.isCorrect) : that.isCorrect != null) return false;
        if (answerText != null ? !answerText.equals(that.answerText) : that.answerText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isCorrect != null ? isCorrect.hashCode() : 0);
        result = 31 * result + (answerText != null ? answerText.hashCode() : 0);
        return result;
    }
}
