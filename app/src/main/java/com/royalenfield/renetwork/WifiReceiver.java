package com.royalenfield.renetwork;

import static android.content.Context.WIFI_SERVICE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import java.sql.ResultSet;
import java.util.List;

public class WifiReceiver extends BroadcastReceiver {

    private MainActivity mainActivity;
    private WifiManager wifiManager;

    public WifiReceiver(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Patel","Patel"+"Wifi changed");
        WifiManager wifiManager =(WifiManager) context.getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo info = wifiManager.getConnectionInfo();
        String ssid = info.getSSID();
        int rssi = info.getRssi();
        Log.d("Patel","RSSI: "+rssi+" ssid:"+ssid);



    }

    private static boolean isWifiOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.WIFI_ON, 0) != 0;
    }


}
