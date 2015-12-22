package de.krischkes.moritz.uebung;

import android.app.Activity;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * topics:
 * -work with locations
 * -work with bluetooth
 * -Switcher
 * -ToogleButton
 */
public class SwitcherActivity extends Activity {
    //WARNING: This Activity crashes when running on virtual Device because of the Bluetooth and WLAN functionality

    Switch aSwitch;
    ToggleButton toggleButton;
    Button resultButton, nextPractise;
    TextView resultView;
    boolean wlan,bluetooth;
    WifiManager wifiManager;
    BluetoothManager bluetoothManager;




    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switcher);
        wlan=false;
        bluetooth=false;

        //get Manager to handle bluetooth and wifi
        wifiManager=(WifiManager)getBaseContext().getSystemService(Context.WIFI_SERVICE);
        bluetoothManager=(BluetoothManager)getBaseContext().getSystemService(Context.BLUETOOTH_SERVICE);


        resultView=(TextView)findViewById(R.id.resultTVFourthPractise);
        aSwitch=(Switch)findViewById(R.id.wlanSwitcher);
        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wifiManager.getWifiState()==WifiManager.WIFI_STATE_ENABLED) {
                    wifiManager.setWifiEnabled(false);
                    wlan=false;
                    aSwitch.setChecked(false);
                }else if (wifiManager.getWifiState()==WifiManager.WIFI_STATE_DISABLED){
                    wifiManager.setWifiEnabled(true);
                    aSwitch.setChecked(true);
                    wlan=true;
                }
            }
        });
        toggleButton=(ToggleButton)findViewById(R.id.bluetoothToogleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetoothManager.getAdapter().isEnabled()) {
                    bluetoothManager.getAdapter().disable();
                    toggleButton.setChecked(false);
                    bluetooth=false;
                }else{
                    bluetoothManager.getAdapter().enable();
                    toggleButton.setChecked(true);
                    bluetooth=true;
                }
            }
        });
        if(wifiManager.getWifiState()==WifiManager.WIFI_STATE_ENABLED){
            aSwitch.setChecked(true);
        }
        if(bluetoothManager.getAdapter().isEnabled()){
            toggleButton.setChecked(true);
        }
        resultButton=(Button)findViewById(R.id.resultButtonFourthPractise);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultView.setText("Wlan: "+String.valueOf(wlan)+"\n"+"Bluetooth: "+String.valueOf(bluetooth));
            }
        });

        nextPractise = (Button)findViewById(R.id.nextPractiseFourthPractise);
        nextPractise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextPractiseIntent= new Intent(getBaseContext(), SpinnerActivity.class);
                startActivity(nextPractiseIntent);
            }
        });

    }

}
