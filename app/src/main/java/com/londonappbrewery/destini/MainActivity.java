package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;

    StoryAndAnswer[] mStoryAndAnswerBank = new StoryAndAnswer[]
            {
                    new StoryAndAnswer(R.string.T1_Ans1, R.string.T3_Story, false),
                    new StoryAndAnswer(R.string.T1_Ans2, R.string.T2_Story, false),
                    new StoryAndAnswer(R.string.T2_Ans1, R.string.T3_Story, false),
                    new StoryAndAnswer(R.string.T2_Ans2, R.string.T4_End, true),
                    new StoryAndAnswer(R.string.T3_Ans1, R.string.T6_End, true),
                    new StoryAndAnswer(R.string.T3_Ans2, R.string.T5_End, true)
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion(mButtonTop.getText().toString());
            }
        });
        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateQuestion(mButtonBottom.getText().toString());
            }
        });

    }

    private void updateQuestion(String answerChosen)
    {
        for(int mIndex = 0; mIndex < mStoryAndAnswerBank.length; mIndex++)
        {
            if(answerChosen == getString(mStoryAndAnswerBank[mIndex].getAnswer()))
            {
                mStoryTextView.setText(mStoryAndAnswerBank[mIndex].getStory());

                if(mStoryAndAnswerBank[mIndex].isEnding() == true)
                {
                    mButtonBottom.setVisibility(View.INVISIBLE);
                    mButtonTop.setVisibility(View.INVISIBLE);
                }
                else if(mStoryAndAnswerBank[mIndex].getStory() == R.string.T3_Story)
                {
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                }
                else
                {
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                }

            }
        }
    }
}
