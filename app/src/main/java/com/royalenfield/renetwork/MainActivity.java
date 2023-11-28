package com.royalenfield.renetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

     WifiReceiver wifiReceiver = new WifiReceiver(this);
    BluetoothReceiver bluetoothReceiver = new BluetoothReceiver(this);

    @Override
    protected void onStart() {
        Log.d("Patel","Patel"+"on Started");
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(wifiReceiver, filter);

        IntentFilter wifiFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        wifiFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);
        wifiFilter.addAction(WifiManager.NETWORK_IDS_CHANGED_ACTION);
        registerReceiver(wifiReceiver, wifiFilter);

        IntentFilter bluetoothFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        bluetoothFilter.addAction(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED);
        bluetoothFilter.addAction(BluetoothA2dp.ACTION_CONNECTION_STATE_CHANGED);
        bluetoothFilter.addAction(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
        registerReceiver(bluetoothReceiver, bluetoothFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}