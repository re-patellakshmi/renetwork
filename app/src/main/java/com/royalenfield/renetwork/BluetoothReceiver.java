package com.royalenfield.renetwork;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.util.Set;

public class BluetoothReceiver extends BroadcastReceiver {

    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private Set<BluetoothDevice> pairedDevices;

    private MainActivity mainActivity;

    public BluetoothReceiver(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Patel Bluetooth","Patel: "+"Bluetooh changed");
        Log.d("Patel","BluetoothDevice.EXTRA_RSSI: "+BluetoothDevice.EXTRA_RSSI);
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        pairedDevices = bluetoothAdapter.getBondedDevices();
        for(BluetoothDevice bluetoothDevices: pairedDevices){
            Log.d("Patel xxx","Patel: "+""+bluetoothDevices.getAddress());
            Log.d("Patel Bluetooth","Patel: "+""+bluetoothDevices.getAddress());
            Log.d("Patel Bluetooth","Patel: "+""+bluetoothDevices.getName());
        }



    }

    private static boolean isBluetoothOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.BLUETOOTH_ON, 0) != 0;
    }
}
