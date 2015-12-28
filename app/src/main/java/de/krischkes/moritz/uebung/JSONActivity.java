package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.krischkes.moritz.uebung.ContentClasses.Car;

/**
 * topics:
 * understand how to use JSON Objects and JSON Arrays
 * learn how to print structured JSON
 */

//todo: later implementation should send and receive JSON Objects
//CAUTION: Keep in mind that JSON should only be handled in Background
public class JSONActivity extends Activity{

    Car testCar;
    TextView jsonResultView;
    Button generateJSONButton;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        jsonResultView = (TextView) findViewById(R.id.jsonResultView);
        generateJSONButton = (Button) findViewById(R.id.genereateJSON);
        generateJSONButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonResultView.setText(testCar.toJSON());
            }
        });
    }

    protected void onStart(){
        super.onStart();
        //instantiate a test object
        testCar= new Car(4,300,2000,true,5,"Audi S3", 33333, 1, 2000, 33333);
        //add a few more services to fill JSONArray
        testCar.addService(2,10000,66666);
        testCar.addService(3,300,99999);
        testCar.addService(4,100,333333);
    }


}
