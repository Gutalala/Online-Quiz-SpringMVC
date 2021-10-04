package Entity;

import javax.persistence.*;

@Entity
@Table(name = "quiz_has_questions", schema = "onlinequiz", catalog = "")
@IdClass(QuizHasQuestionsHBPK.class)
public class QuizHasQuestionsHB {

    @ManyToOne()
    @JoinColumn(name = "Quiz_id")
    private QuizHB quizHB;

    public QuizHB getQuizHB() {
        return quizHB;
    }

    public void setQuizHB(QuizHB quizHB) {
        this.quizHB = quizHB;
    }

    @ManyToOne()
    @JoinColumn(name = "questions_id")
    private QuestionsHB quiz_questionsHB;

    public QuestionsHB getQuestionsHB() {
        return quiz_questionsHB;
    }

    public void setQuestionsHB(QuestionsHB questionsHB) {
        this.quiz_questionsHB = questionsHB;
    }

    @ManyToOne()
    @JoinColumn(name = "AnswerOptions_id")
    private AnsweroptionsHB answeroptionsHB;

    public AnsweroptionsHB getAnsweroptionsHB() {
        return answeroptionsHB;
    }

    public void setAnsweroptionsHB(AnsweroptionsHB answeroptionsHB) {
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

}
