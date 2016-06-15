package sharpmetro.site.mytask.core;

/**
 * Created by raojiaxin on 16/6/15.
 */
public class TrueOrFalse {

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    private int question;

    public boolean isTrueQuestion() {
        return trueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        this.trueQuestion = trueQuestion;
    }

    public boolean trueQuestion;

    public TrueOrFalse(int question,boolean trueQuestion)
    {
        this.question =question;
        this.trueQuestion = trueQuestion;
    }
}
