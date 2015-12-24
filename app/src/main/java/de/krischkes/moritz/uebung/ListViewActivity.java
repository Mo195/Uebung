package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
/** subjects:
 *  give overview over all available Activities
 *  -own listview layout implemented
 *  -own clicked item layout added
 *  -created selector file in drawable and color to change Background (Drawable State List) and TextColor (Color State List)
 *  -saved color values in xml file (/values) to define App wide colors (Caution: must differ between drawable (background) and color (textcolor)
 */

public class ListViewActivity extends Activity {

    ListView listView;
    Button nextPractise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        //get the Listview from the layout
        listView=(ListView)findViewById(R.id.countryListView);
        //create a ArrayAdapter to display stringarray on the ListView
        String[] availableCountries = getResources().getStringArray(R.array.autocompleteCountry);
        ArrayAdapter<String> countryArrayAdapter= new ArrayAdapter<>(this,R.layout.moritz_list_layout_1,R.id.listItem,availableCountries);
        listView.setAdapter(countryArrayAdapter);
        //get the item that the user selected an make a toast with content
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //need to add selected attribute manually to reach selected state
                view.setSelected(true);
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
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
