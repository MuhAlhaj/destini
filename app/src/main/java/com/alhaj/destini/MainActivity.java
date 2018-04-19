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
    private int mIndex = 0;

    private Story[] storyArray = {
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)
            mIndex = savedInstanceState.getInt("KeyIndex");
        else
            mIndex = 0;
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        txt_textArea = findViewById(R.id.storyTextView);
        btn_above = findViewById(R.id.buttonTop);
        btn_bottom = findViewById(R.id.buttonBottom);

        FillData(mIndex);
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        btn_above.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndex == 0 || mIndex == 1) {
                    mIndex = 2;
                    FillData(mIndex);
                } else if (mIndex == 2) {
                    EndStory(R.string.T6_End);
                }


            }
        });
        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        btn_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndex == 0) {
                    mIndex = 1;
                    FillData(mIndex);
                } else if (mIndex == 1) {
                    EndStory(R.string.T4_End);
                } else if (mIndex == 2) {
                    EndStory(R.string.T5_End);
                }

            }
        });

    }

    private void FillData(int index) {
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
        btn_above.setVisibility(View.INVISIBLE);
        btn_bottom.setText("");
        btn_bottom.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("KeyIndex", mIndex);
    }
}
