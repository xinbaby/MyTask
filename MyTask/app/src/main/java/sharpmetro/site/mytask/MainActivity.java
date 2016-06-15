package sharpmetro.site.mytask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sharpmetro.site.mytask.views.QuizActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initUI();
    }

    private void initUI()
    {
        this.textView = (TextView) findViewById(R.id.mainActivity_textView);
        this.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// TODO: navigate to a new activity
                Intent intent = new Intent(MainActivity.this,QuizActivity.class);
                startActivity(intent);

            }
        });
    }
}
