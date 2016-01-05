package de.krischkes.moritz.uebung.Database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * This class is responsible for creating the schema of an SQLite Database.
 * It extends the SQLiteOpenHelper and provides Methods that should be called for creating databases
 * and alter databases
 */
public class PractiseDatabaseHelper extends SQLiteOpenHelper{

    //This class define constant fields like:
    //database- & tablename, Primary key, Version, columnnames of table
    private static final String DATABASENAME = "database_playground.db";
    private static final String TABLENAME = "FIRSTPLAYGROUND";
    //UID = Unique identifier --> String specifies the columnname of the identifier, should be named as _id by convention
    private static final String UID = "_id";
    private static final String FIRSTCOLUMNNAME ="FristColumn";
    private static final String SECONDCOLUMNNAME = "SecondColumn";
    //android will call onUpgrade() once in case the VersionNumber has been incremented
    private static final int DATABASE_VERSION= 1;




    public PractiseDatabaseHelper(Context context) {
        //third argument of super constructor is in case a custom cursor was created
        super(context, DATABASENAME, null /*no custom cursor*/, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL Query for creating table -->implement HelperMethod!!!
        try{
            String createQuery="CREATE TABLE "+TABLENAME +
                    " ("+UID+" "+SQLHelper.DTINTEGER +" " +SQLHelper.PRIMARYKEY+" AUTOINCREMENT, "
                    +FIRSTCOLUMNNAME +" " +SQLHelper.DTVARCHAR +"(255), "
                    +SECONDCOLUMNNAME +" "+SQLHelper.DTBOOLEAN
                    +");";
            //todo: Entry in log is just for debugging --> delete
            Log.d("PractiseDatabaseHelper", createQuery);
        db.execSQL(createQuery);}catch (SQLException ex){
            Log.d("PractiseDatabaseHelper", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //this is an easy example for upgrade case
        //deleting table that is already persistent and create new Table (with new Columns/Datatypes etc)
        try {
            String deleteQuery="DROP TABLE IF EXISTS "+TABLENAME;
            Log.d("PractiseDatabaseHelper", deleteQuery);
            db.execSQL(deleteQuery);
            onCreate(db);
        } catch (SQLException e) {
            Log.d("PractiseDatabaseHelper", e.getMessage());
        }
    }

}
