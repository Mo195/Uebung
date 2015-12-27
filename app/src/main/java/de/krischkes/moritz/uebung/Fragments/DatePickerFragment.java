package de.krischkes.moritz.uebung.Fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import de.krischkes.moritz.uebung.PickerActivity;
import de.krischkes.moritz.uebung.R;

/**
 * Created by Moritzkrischke on 26/12/15.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    public Dialog onCreateDialog(Bundle savedInstancestate){
        //get current date to use as default
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year, month,day);
    }

    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //set values in calling Activity
        ((PickerActivity)getActivity()).getSelectedDate().set(Calendar.YEAR,year);
        ((PickerActivity)getActivity()).getSelectedDate().set(Calendar.MONTH,monthOfYear);
        ((PickerActivity)getActivity()).getSelectedDate().set(Calendar.DAY_OF_MONTH,dayOfMonth);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        //set date in calling activity to refer to it as last select
        ((PickerActivity)getActivity()).setSelectedDate(calendar);
        //format date
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        TextView dateResultTV = (TextView)getActivity().findViewById(R.id.resultDate);
        dateResultTV.setText(date.format(calendar.getTime()));
    }
}
