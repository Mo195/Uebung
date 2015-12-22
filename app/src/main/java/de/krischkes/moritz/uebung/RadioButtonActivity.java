package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Topics: -Radiobuttons & related events
 */
public class RadioButtonActivity extends Activity{

    TextView resultView;
    Button resultButton, practiseSwitcher;
    String resultString;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_radiobuttonpractise);
        //set resultString to empty string in the beginning
        resultString="";
        //get Textview to display the results of the practise
        resultView= (TextView) findViewById(R.id.resultSecondPractise);
        //get Button to show results
        resultButton=(Button)findViewById(R.id.resultButtonSecondPractise);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText(resultString);
            }
        });

        //get Button to switch to the next Practise
        practiseSwitcher=(Button)findViewById(R.id.nextPractiseSecondPractise);
        practiseSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent practiseSwitcherIntent = new Intent(getBaseContext(), AutoCompleteActivity.class);
                startActivity(practiseSwitcherIntent);
            }
        });
    }

    public void radioButtonEventHandler(View v){
        resultString="";
        switch (v.getId()){
            case R.id.radioButton1SecondPractise:
                resultString="Radio Button 1 was selected!";
                break;

            case R.id.radioButton2SecondPractise:
                resultString="Radio Button 2 was selected!";
                break;

            case R.id.radioButton3SecondPractise:
                resultString="Radio Button 3 was selected!";
                break;

            case R.id.radioButton4SecondPractise:
                resultString="Radio Button 4 was selected!";
                break;

            case R.id.radioButton5SecondPractise:
                resultString="Radio Button 5 was selected!";
                break;
        }
    }

}
