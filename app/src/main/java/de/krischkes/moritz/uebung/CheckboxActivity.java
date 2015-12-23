package de.krischkes.moritz.uebung;

/*topics:
        -Save App variables in private SharedPreferences - put & get
        -Checkboxes
        -Intents & start Activity
        -Buttons & onClick Methods - both ways: A. anonymous internal class B. onClick Attribut in XML file
*/

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CheckboxActivity extends Activity {

    TextView resultView;
    Button resultButton, practiseSwitcher;
    ArrayAdapter<String> arrayAdapterAutoComplete;
    SharedPreferences sharedPreferences;
    String resultString;

    ArrayList<String> resultArray= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        //instanciate the result array
        resultArray=new ArrayList<>();

        //get the text view to show the results
        resultView=(TextView)findViewById(R.id.result);

        //how to handle autocomplete Edittexts
        arrayAdapterAutoComplete = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.autocompleteCountry));

        //find button on view to display results
        resultButton= (Button)findViewById(R.id.testButton);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultString ="";
                for(String partResult : resultArray){
                    resultString=resultString+partResult;
                }
                resultView.setText(resultString);
            }
        });

        //find Button to switch to next practise
        practiseSwitcher= (Button)findViewById(R.id.nextPractise);
        practiseSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use an explicit Intent to switch to the new practise
                Intent nextPractiseIntent= new Intent(getBaseContext(), RadioButtonActivity.class);
                startActivity(nextPractiseIntent);
            }
        });
    }

    protected void onStart(){
        super.onStart();
        //get SharedPreferences and get value to known key
        sharedPreferences=getPreferences(MODE_PRIVATE);
        resultString=sharedPreferences.getString("latestResults", ""/*default value in case nothing is found for this key*/);
        //display the returned value
        resultView.setText(resultString);
    }

    //this is how to handle a checkbox
    public void CheckboxEventHandler (View v){
        String wasChecked="was checked\n";
        String wasUnchecked="was unchecked\n";
        switch(v.getId()){
            case R.id.checkbox1:
                Log.d("CheckboxActivity", "Checkbox 1 is clicked");
                if(((CheckBox)v).isChecked()){
                    resultArray.add("Checkbox 1 "+wasChecked);
                }else{
                    resultArray.add("Checkbox 1 "+wasUnchecked);
                }break;

            case R.id.checkbox2:
                Log.d("CheckboxActivity", "Checkbox 2 is clicked");
                if(((CheckBox)v).isChecked()){
                    resultArray.add("Checkbox 2 "+wasChecked);
                }else{
                    resultArray.add("Checkbox 2 "+wasUnchecked);
                }break;

            case R.id.checkbox3:
                Log.d("CheckboxActivity", "Checkbox 3 is clicked");
                if(((CheckBox)v).isChecked()){
                    resultArray.add("Checkbox 3 "+wasChecked);
                }else{
                    resultArray.add("Checkbox 3 "+wasUnchecked);
                }break;

            case R.id.checkbox4:
                Log.d("CheckboxActivity", "Checkbox 4 is clicked");
                if(((CheckBox)v).isChecked()){
                    resultArray.add("Checkbox 4 "+wasChecked);
                }else{
                    resultArray.add("Checkbox 4 "+wasUnchecked);
                }break;

            case R.id.checkbox5:
                Log.d("CheckboxActivity", "Checkbox 5 is clicked");
                if(((CheckBox)v).isChecked()){
                    resultArray.add("Checkbox 5 "+wasChecked);
                }else{
                    resultArray.add("Checkbox 5 "+wasUnchecked);
                }break;
        }
    }

    protected void onStop(){
        super.onStop();
        //make the SharedPreferences editable, add a key value pair and commit
        Editor editor = sharedPreferences.edit();
        editor.putString("latestResults", resultString);
        editor.commit();
    }
}
