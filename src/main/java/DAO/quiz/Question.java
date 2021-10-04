package DAO.quiz;

import java.util.List;

public class Question {
    private int questionNumber;
    private String questionText;

    int correctOptionIndex;
    String[] answerOptions;

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getOption(int i){
        return answerOptions[i];
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }

    public String[] getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(String[] answerOptions) {
        this.answerOptions = answerOptions;
    }


}
