package Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class QuizHasQuestionsHBPK implements Serializable {
    private int id;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuizHasQuestionsHBPK that = (QuizHasQuestionsHBPK) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }
}
