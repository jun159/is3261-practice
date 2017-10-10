package sg.edu.nus.baojun.is3261_practice.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import sg.edu.nus.baojun.is3261_practice.R;

public class BroadcastActivity extends AppCompatActivity {

    MyBroadcastReceiver myReceiver;
    IntentFilter myIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        myReceiver = new MyBroadcastReceiver();
        myIntentFilter = new IntentFilter("SOC_Students");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, myIntentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(myReceiver);
        super.onPause();
    }

    public void onClick_SendBroadcast(View view) {
        // Call static and persistent receiver
        Intent intent = new Intent("SOC_Students");
        intent.putExtra("rojak", "delicious");
        sendBroadcast(intent);
    }
}
