package DAO.quiz;

import Utility.ConnectionUtil;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Quiz {
    public int currentQuestion = 0;
    public String category;
    public static Integer numberOfQuestions = 10;
    public Map<Integer, Integer> selections = new LinkedHashMap<Integer, Integer>();
    public LinkedList<Question> questionList = new LinkedList<>();

    public Quiz(String category) throws SAXException, ParserConfigurationException, IOException, URISyntaxException {
       this.category = category;
    }

    public void loadQuestion(){
        String questionQuery = "select distinct id, questionText from questions where category = ? order by RAND() LIMIT 10";
        int count = 0;
        try (Connection conn = ConnectionUtil.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(questionQuery)){
            preparedStatement.setString(1, this.category);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Question q = new Question();
                q.setQuestionText(rs.getString("questionText"));

                // This part is ugly, can be improved. This handles setAnswers for each question.
                String[] answerOptions = new String[4];

                String answerQuery = "select * from answeroptions where answeroptions.quiz_question_id = ?";
                try (Connection conn2 = ConnectionUtil.getConnection(); PreparedStatement preparedStatement2 = conn2.prepareStatement(answerQuery)) {
                    preparedStatement2.setInt(1, rs.getInt("id"));
                    ResultSet answerRs = preparedStatement2.executeQuery();
                    for (int j = 0; j < 4; j++){
                        answerRs.next();
                        answerOptions[j] = answerRs.getString("answerText");
                        if (answerRs.getInt("isCorrect") == 1){
                            q.setCorrectOptionIndex(j);
                        }
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                q.setAnswerOptions(answerOptions);
                q.setQuestionNumber(count + 1);

                questionList.add(count, q);
                count++;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public LinkedList<Question> getQuestionList() {
        return this.questionList;
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public Map<Integer, Integer> getSelections() {
        return this.selections;
    }

    public int calculateResult(Quiz quiz) {
        int totalCorrect = 0;
        Map<Integer, Integer> userSelectionsMap = quiz.getSelections();
        List<Integer> userSelectionsList = new ArrayList<Integer>(10);
        for (Map.Entry<Integer, Integer> entry : userSelectionsMap.entrySet()) {
            userSelectionsList.add(entry.getValue());
        }
        List<Question> questionList = quiz.questionList;
        List<Integer> correctAnswersList = new ArrayList<Integer>(10);
        for (Question question : questionList) {
            correctAnswersList.add(question.getCorrectOptionIndex());
        }


        for (int i = 0; i < selections.size(); i++) {
            if ((userSelectionsList.get(i) - 1) == correctAnswersList.get(i)) {
                totalCorrect++;
            }
        }
        return totalCorrect;
    }
}
