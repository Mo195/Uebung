package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.krischkes.moritz.uebung.Fragments.DatePickerFragment;

/**
 * Created by Moritzkrischke on 26/12/15.
 */
public class PickerActivity extends Activity{

    TextView selectDateLabel;
    DatePickerFragment datePickerFragment;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        //create the needed fragment
        datePickerFragment = new DatePickerFragment();
        selectDateLabel = (TextView) findViewById(R.id.selectDateLabel);
        selectDateLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerFragment.show(getFragmentManager(), "datepicker_1");
            }
        });
    }
}
