package de.krischkes.moritz.uebung.ActiveAndroid;

import android.app.Activity;
import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Created by Moritzkrischke on 30/12/15.
 */
public class ActiveAndroidInitialize extends Application{

    public void onCreate(Context context){
        //some operations....

        //initialize ActiveAndroid Framework
        ActiveAndroid.initialize(context);

    }
}
