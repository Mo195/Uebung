package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends Activity {

    ListView listView;
    Button nextPractise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listvview);
        //get the Listview from the layout
        listView=(ListView)findViewById(R.id.countryListView);
        //create a ArrayAdapter to display stringarray on the ListView
        ArrayAdapter<CharSequence> countryArrayAdapter= ArrayAdapter.createFromResource(this,R.array.autocompleteCountry,android.R.layout.simple_list_item_1);
        listView.setAdapter(countryArrayAdapter);
        //get the item that the user selected an make a toast with content
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            //does nothing
            }
        });

        //get the Button and create Method to switch to the next practise
        nextPractise=(Button)findViewById(R.id.nextPractiseSixthPractise);
        nextPractise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: define the next practise as soon as there is a next one
                //Intent nextPractiseIntent= new Intent(getBaseContext(), )
            }
        });
    }
}
