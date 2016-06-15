package sharpmetro.site.mytask.views;
import  sharpmetro.site.mytask.R;
import sharpmetro.site.mytask.core.TrueOrFalse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private TextView questionTextView;
    private Button nextButton;
    private TrueOrFalse[] questionArray = new TrueOrFalse[]
            {
              new TrueOrFalse(R.string.one,true),
                    new TrueOrFalse(R.string.two,false),
                    new TrueOrFalse(R.string.three,true),
                    new TrueOrFalse(R.string.four,false),
            };

    private int currentIndex= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initUI();
        setListener();
        initData();

    }

    private void initUI()
    {
        this.trueButton = (Button) findViewById(R.id.main_true_button);
        this.falseButton = (Button) findViewById(R.id.main_false_button);
        this.questionTextView = (TextView) findViewById(R.id.question_text_view);
        this.nextButton = (Button) findViewById(R.id.next_button);

    }
    private void setListener()
    {
        this.trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(QuizActivity.this,R.string.correct_text,Toast.LENGTH_SHORT).show();
                  checkAnswer(true);
            }
        });

        this.falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(QuizActivity.this,R.string.incorrect_text,Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        this.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % questionArray.length;
               updateQuestionText();
            }
        });
    }
    private void updateQuestionText()
    {
        int questionText = questionArray[currentIndex].getQuestion();
        questionTextView.setText(questionText);
    }
    private void initData()
    {
       updateQuestionText();
    }

    private void checkAnswer(boolean answer)
    {
        boolean answerResult = this.questionArray[this.currentIndex].isTrueQuestion();
        int resultID = 0;
        if (answer ==answerResult)
        {
            resultID = R.string.correct_text;
        }
        else
        {
            resultID = R.string.incorrect_text;
        }
       // this.questionTextView.setText(resultID);
        Toast.makeText(this,resultID,Toast.LENGTH_SHORT).show();
    }

}
