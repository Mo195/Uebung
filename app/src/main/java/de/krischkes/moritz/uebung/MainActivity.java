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
 *  create ListView with available android standard layout
 *  create ArrayAdapter with one method
 *  create intent and set target in condition
 */
public class MainActivity extends Activity{

    ListView activityListView;

    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            activityListView=(ListView)findViewById(R.id.activityListView);
            String[] activiesStrings = getResources().getStringArray(R.array.availableActivities);
            ArrayAdapter<CharSequence> activitiesArrayAdapter= ArrayAdapter.createFromResource(this,R.array.availableActivities,android.R.layout.simple_list_item_1);
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
                        case 6:
                            universalIntent.setClass(getBaseContext(),OwnAdapterListViewActivity.class);
                            break;
                        case 7:
                            universalIntent.setClass(getBaseContext(),PickerActivity.class);
                            break;
                        case 8:
                            universalIntent.setClass(getBaseContext(),JSONActivity.class);
                            break;
                        case 9:
                            universalIntent.setClass(getBaseContext(), DatabasePlaygroundActivtiy.class);
                            break;
                    }
                    startActivity(universalIntent);
                }
            });
    }


}
