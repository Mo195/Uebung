package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import de.krischkes.moritz.uebung.Database.PractiseDatabaseHelper;

public class DatabasePlaygroundActivtiy extends Activity {

    private PractiseDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_playground);
        dbHelper = new PractiseDatabaseHelper(this);
        //this creates the database
        SQLiteDatabase sqLiteDatabase= dbHelper.getWritableDatabase();
    }
}
