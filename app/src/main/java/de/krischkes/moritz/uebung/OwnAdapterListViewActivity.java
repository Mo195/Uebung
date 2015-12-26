package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import de.krischkes.moritz.uebung.OwnArrayAdapter.ChristmasSongsArrayAdapter;

/**
 * Created by Moritzkrischke on 24/12/15.
 */
public class OwnAdapterListViewActivity extends Activity {
    //todo:list items are hardcoded in values folder -> get values dynamically from Database

    ListView top10ChristmasHitsLV;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownadapterlistview);
        top10ChristmasHitsLV=(ListView)findViewById(R.id.top10ChristmasHitsList);

        //get String Arrays out of values file
        String[] songtitles = getResources().getStringArray(R.array.top10_christmas_hits_songtitles);
        String[] artists = getResources().getStringArray(R.array.top10_christmas_hits_artists);

        //create instance of own Adapter
        //todo: need to change value for layoutressource and for drawableressource
        ChristmasSongsArrayAdapter christmasSongsArrayAdapter= new ChristmasSongsArrayAdapter(this,R.layout.moritz_list_row_layout,songtitles,artists,0);
        top10ChristmasHitsLV.setAdapter(christmasSongsArrayAdapter);
        top10ChristmasHitsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
            }
        });
    }
}
