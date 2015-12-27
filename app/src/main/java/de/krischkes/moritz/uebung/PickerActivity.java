package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.SharedPreferences.Editor;

import de.krischkes.moritz.uebung.Fragments.DatePickerFragment;
import de.krischkes.moritz.uebung.Fragments.TimePickerFragment;

/**
 * Created by Moritzkrischke on 26/12/15.
 */
public class PickerActivity extends Activity{

    //keys to retrieve information from Sharedpreferences
    private final String SELECTEDHOUR ="selected_hour";
    private final String SELECTEDMINUTE="selected_minute";
    private final String SELECTEDDAY="selected_day";
    private final String SELECTEDMONTH="selected_month";
    private final String SELECTEDYEAR="selected_year";


    TextView dateResultTV, timeResultTV, lastSelectedValues;
    DatePickerFragment datePickerFragment;
    TimePickerFragment timePickerFragment;
    Calendar selectedDate;
    Button dateAddButton;
    SharedPreferences sharedPrefs;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        selectedDate=Calendar.getInstance();
        //create the needed fragment for datepicker
        datePickerFragment = new DatePickerFragment();
        //get view and add onclick to create fragment
        dateResultTV = (TextView) findViewById(R.id.resultDate);
        dateResultTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start fragment --> references result
                datePickerFragment.show(getFragmentManager(), "datepicker_1");
            }
        });
        timeResultTV= (TextView)findViewById(R.id.resultTime);
        //create needed fragment
        timePickerFragment = new TimePickerFragment();
        timeResultTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            timePickerFragment.show(getFragmentManager(),"timepicker_1");
            }
        });
        lastSelectedValues = (TextView) findViewById(R.id.lastSelectedValuesTV);
        dateAddButton = (Button) findViewById(R.id.dateAddButton);
        dateAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSelectedValuesTV();
            }
        });
    }

    protected void onStart(){
        sharedPrefs=getPreferences(MODE_PRIVATE);
        super.onStart();
        //retrieve values
        selectedDate.set(Calendar.YEAR, sharedPrefs.getInt(SELECTEDYEAR, 1970));
        selectedDate.set(Calendar.MONTH, sharedPrefs.getInt(SELECTEDMONTH, 1));
        selectedDate.set(Calendar.DAY_OF_MONTH, sharedPrefs.getInt(SELECTEDDAY, 1));
        selectedDate.set(Calendar.HOUR_OF_DAY, sharedPrefs.getInt(SELECTEDHOUR, 22));
        selectedDate.set(Calendar.MINUTE, sharedPrefs.getInt(SELECTEDMINUTE, 22));
        refreshSelectedValuesTV();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Save old values
        //this is no smart solution --> only for test purpose --> Maybe work with long number from Date class to construct/reconstruct
        //another solution would be to use JSON instead and retrieve everything from JSON String
        Editor edit = sharedPrefs.edit();
        edit.putInt(SELECTEDYEAR, selectedDate.get(Calendar.YEAR));
        edit.putInt(SELECTEDMONTH, selectedDate.get(Calendar.MONTH));
        edit.putInt(SELECTEDDAY, selectedDate.get(Calendar.DAY_OF_MONTH));
        edit.putInt(SELECTEDHOUR, selectedDate.get(Calendar.HOUR_OF_DAY));
        edit.putInt(SELECTEDMINUTE, selectedDate.get(Calendar.MINUTE));
        edit.commit();
    }

    protected void refreshSelectedValuesTV(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        lastSelectedValues.append("\n"+dateFormat.format(selectedDate.getTime()));
    }

    public Calendar getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Calendar selectedDate) {
        this.selectedDate = selectedDate;
    }
}
