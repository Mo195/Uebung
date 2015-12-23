package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/** subjects:
 *  give overview over all available Activities
 */
public class MainActivity extends Activity{

    ListView activityListView;

    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            activityListView=(ListView)findViewById(R.id.activityListView);
            String[] activiesStrings = getResources().getStringArray(R.array.availableActivities);
            ArrayAdapter<String> activitiesArrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,activiesStrings);
            activityListView.setAdapter(activitiesArrayAdapter);
            //register a listener for click events in ListView
            activityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent universalIntent = new Intent();
                    //set the class the intent should switch to
                    switch (position) {
                        case 0:
                            universalIntent.setClass(getBaseContext(), CheckboxActivity.class);
                            break;
                        case 1:
                            universalIntent.setClass(getBaseContext(),RadioButtonActivity.class);
                            break;
                        case 2:
                            universalIntent.setClass(getBaseContext(),AutoCompleteActivity.class);
                            break;
                        case 3:
                            universalIntent.setClass(getBaseContext(),SwitcherActivity.class);
                            break;
                        case 4:
                            universalIntent.setClass(getBaseContext(),SpinnerActivity.class);
                            break;
                        case 5:
                            universalIntent.setClass(getBaseContext(),ListViewActivity.class);
                            break;
                    }
                    startActivity(universalIntent);
                }
            });
    }


}
