package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

/**
 * topics:
 * -create Autocomplete TV
 * -get a String Array from Strings.xml
 * -handling ArrayAdaptor
 */
public class AutoCompleteActivity extends Activity {

    Button switcherPractiseButton, nextPractiseButton;
    AutoCompleteTextView autocompleteText;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);
        //get the Button and start a new activity onclick
        switcherPractiseButton =(Button)findViewById(R.id.switcherActivityButton);
        switcherPractiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switcherPractiseIntent = new Intent(getBaseContext(), SwitcherActivity.class);
                startActivity(switcherPractiseIntent);
            }
        });
        nextPractiseButton=(Button)findViewById(R.id.nextPractiseThirdPractise);
        nextPractiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextPractiseIntent = new Intent(getBaseContext(),SpinnerActivity.class);
                startActivity(nextPractiseIntent);
            }
        });
        //handle the autocompleteTV
        autocompleteText=(AutoCompleteTextView)findViewById(R.id.autoCompleteET);
                String[] countrys = getResources().getStringArray(R.array.autocompleteCountry);
                ArrayAdapter<String> stringCountryArrayAdapter= new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_dropdown_item_1line, countrys);
                autocompleteText.setAdapter(stringCountryArrayAdapter);
    }



}
