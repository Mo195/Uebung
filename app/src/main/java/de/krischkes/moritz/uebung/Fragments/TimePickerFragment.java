package de.krischkes.moritz.uebung.Fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.TimePickerDialog.OnTimeSetListener;

import java.util.Calendar;
import java.util.Date;

import de.krischkes.moritz.uebung.PickerActivity;
import de.krischkes.moritz.uebung.R;

/**
 * Created by Moritzkrischke on 27/12/15.
 */
public class TimePickerFragment extends DialogFragment implements OnTimeSetListener{
    //todo: how to set 24h time format?

    public TimePickerDialog onCreateDialog(Bundle savedInstanceState){
        //get local final instance of calender to have the always the current time
        final Calendar calendar = Calendar.getInstance();
        //get current time to set as default
        //CAUTION: HOUR_OF_DAY = 24h time format, HOUR = 12h time format
        //calendar.set(Calendar.AM_PM, int); int=0 --> am, int=1-->pm
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        //create fragment element
        return new TimePickerDialog(getActivity(),this,hour,minute,true);
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //get a new instance of calendar so set the new time
        Calendar cal= Calendar.getInstance();
        //set the time in calling Activity to refer to it as old values:
        ((PickerActivity)getActivity()).getSelectedDate().set(Calendar.HOUR_OF_DAY, hourOfDay);
        ((PickerActivity)getActivity()).getSelectedDate().set(Calendar.MINUTE, minute);
        //Second and millisecond is not provided by Interface --> set to 0
        ((PickerActivity)getActivity()).getSelectedDate().set(Calendar.SECOND, 0);
        ((PickerActivity)getActivity()).getSelectedDate().set(Calendar.MILLISECOND, 0);
        Log.d("PickerActivity","hour: " +hourOfDay +" and minute: "+minute);
        //get TextView to show the selected time
        TextView resultTimeTV = (TextView) getActivity().findViewById(R.id.resultTime);
        resultTimeTV.setText(hourOfDay+":"+minute);
    }
}
