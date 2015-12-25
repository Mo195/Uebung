package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

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
    }
}
