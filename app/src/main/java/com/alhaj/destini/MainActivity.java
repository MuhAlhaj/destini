package com.alhaj.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView txt_textArea;
    Button btn_above;
    Button btn_bottom;
    // private int mIndex = 0; it sould be start with 1
    private int mStoryIndex = 1;
    private Story[] storyArray = {
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //if (savedInstanceState != null)
        if (savedInstanceState != null)
            mStoryIndex = savedInstanceState.getInt("KeyIndex");
        else
            mStoryIndex = 1;
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        txt_textArea = findViewById(R.id.storyTextView);
        btn_above = findViewById(R.id.buttonTop);
        btn_bottom = findViewById(R.id.buttonBottom);

        FillData(mStoryIndex);
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        btn_above.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    mStoryIndex = 3;
                    FillData(mStoryIndex);
                } else if (mStoryIndex == 3) {
                    EndStory(R.string.T6_End);
                }


            }
        });
        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        btn_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    mStoryIndex = 2;
                    FillData(mStoryIndex);
                } else if (mStoryIndex == 2) {
                    EndStory(R.string.T4_End);
                } else if (mStoryIndex == 3)
                {
                    EndStory(R.string.T5_End);
                }

            }
        });

    }

    private void FillData(int index) {
        index = index -1;
        if (btn_above.getVisibility() != View.VISIBLE) {
            btn_above.setVisibility(View.VISIBLE);
            //makeit unvisible
            //setVisibility(View.INVISIBLE);
        }
        if (btn_bottom.getVisibility() != View.VISIBLE) {
            btn_bottom.setVisibility(View.VISIBLE);
            //makeit unvisible
            //setVisibility(View.INVISIBLE);
        }
        Story curr = mygetStory(index);
        txt_textArea.setText(curr.getStory());
        btn_above.setText(curr.getAboveStringButtion());
        btn_bottom.setText(curr.getBelowStringButtion());

    }

    private Story mygetStory(int index) {
        //Show btn


        return storyArray[index];

    }

    private void EndStory(int endStoryString) {
        txt_textArea.setText(endStoryString);
        btn_above.setText("");
        btn_above.setVisibility(/*View.INVISIBLE*/View.GONE);
        btn_bottom.setText("");
        btn_bottom.setVisibility(/*View.INVISIBLE*/View.GONE);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mStoryIndex = mStoryIndex+1;
        outState.putInt("KeyIndex", mStoryIndex);
    }
}
