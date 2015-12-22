package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 *Topic:
 * -Spinner
 * -select Item in Dropdown
 */
public class SpinnerActivity extends Activity {

    Spinner countrySpinner;
    Button nextPractiseButton;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        //get view
        countrySpinner=(Spinner)findViewById(R.id.countrySpinner);
        //create a ArrayAdapter directly from existing String Ressource without precasting
        ArrayAdapter<CharSequence> countryArrayAdapter = ArrayAdapter.createFromResource(getBaseContext(),R.array.autocompleteCountry, android.R.layout.simple_spinner_item);//layout for selected item
        countryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//layout for all dropdown items
        //set created Adapter on spinner element
        countrySpinner.setAdapter(countryArrayAdapter);
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //create a Toast with the selected item and show!!!
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //does nothing
            }
        });
        nextPractiseButton=(Button)findViewById(R.id.nextPractiseFifthPractise);
        nextPractiseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextPractiseIntent = new Intent(getBaseContext(), ListViewActivity.class);
                startActivity(nextPractiseIntent);
            }
        });
    }
}
