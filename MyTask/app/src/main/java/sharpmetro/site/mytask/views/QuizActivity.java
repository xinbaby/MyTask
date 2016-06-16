package sharpmetro.site.mytask.views;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import sharpmetro.site.mytask.R;
import sharpmetro.site.mytask.core.TrueOrFalse;


public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String BUNDLEKEY = "index";

    private Button trueButton;
    private Button falseButton;
    private TextView questionTextView;
    private Button nextButton;
    private TrueOrFalse[] questionArray = new TrueOrFalse[]
            {
                    new TrueOrFalse(R.string.one, true),
                    new TrueOrFalse(R.string.two, false),
                    new TrueOrFalse(R.string.three, true),
                    new TrueOrFalse(R.string.four, false),
            };

    private int currentIndex = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        initUI();
        setListener();
        initData();
        Log.d(TAG, "on creat called");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "on Pause called");
        super.onPause();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "on Start called");
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Quiz Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://sharpmetro.site.mytask.views/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "on stop called");
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Quiz Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://sharpmetro.site.mytask.views/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "on resume called");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "on restart called");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "on destory called");
        super.onDestroy();
    }

    @Override
    protected void

    private void initUI() {
        this.trueButton = (Button) findViewById(R.id.main_true_button);
        this.falseButton = (Button) findViewById(R.id.main_false_button);
        this.questionTextView = (TextView) findViewById(R.id.question_text_view);
        this.nextButton = (Button) findViewById(R.id.next_button);

    }

    private void setListener() {
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

    private void updateQuestionText() {
        int questionText = questionArray[currentIndex].getQuestion();
        questionTextView.setText(questionText);
    }

    private void initData() {
        updateQuestionText();
    }

    private void checkAnswer(boolean answer) {
        boolean answerResult = this.questionArray[this.currentIndex].isTrueQuestion();
        int resultID = 0;
        if (answer == answerResult) {
            resultID = R.string.correct_text;
        } else {
            resultID = R.string.incorrect_text;
        }
        // this.questionTextView.setText(resultID);
        Toast.makeText(this, resultID, Toast.LENGTH_SHORT).show();
    }

}
