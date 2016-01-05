package de.krischkes.moritz.uebung.ActiveAndroid;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Moritzkrischke on 30/12/15.
 */
public class ActiveAndroidInherit extends com.activeandroid.app.Application{

    public void onCreate(){
        //Don´t forget to call onCreate() of parent
        super.onCreate();
    }
}
