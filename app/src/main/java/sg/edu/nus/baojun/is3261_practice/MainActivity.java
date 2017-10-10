package sg.edu.nus.baojun.is3261_practice;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import sg.edu.nus.baojun.is3261_practice.broadcastreceiver.BroadcastActivity;
import sg.edu.nus.baojun.is3261_practice.broadcastreceiver.PersistentBroadcastActivity;
import sg.edu.nus.baojun.is3261_practice.dynamicfragment.DynamicFragmentsActivity;
import sg.edu.nus.baojun.is3261_practice.intent.IntentActivity;
import sg.edu.nus.baojun.is3261_practice.orientation.OrientationActivity;
import sg.edu.nus.baojun.is3261_practice.sqlite.SQLite;
import sg.edu.nus.baojun.is3261_practice.staticfragment.StaticFragmentsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_Calculator(View view) {
        Intent intent = new Intent(MainActivity.this, Calculator.class);
        startActivity(intent);
    }

    public void onClick_SQLite(View view) {
        Intent intent = new Intent(MainActivity.this, SQLite.class);
        startActivity(intent);
    }

    public void onClick_SharedPreferences(View view) {
        Intent intent = new Intent(MainActivity.this, SharedPreferencesActivity.class);
        startActivity(intent);
    }

    public void onClick_Intent(View view) {
        Intent intent = new Intent(MainActivity.this, IntentActivity.class);
        startActivity(intent);
    }

    public void onClick_StaticFragments(View view) {
        Intent intent = new Intent(MainActivity.this, StaticFragmentsActivity.class);
        startActivity(intent);
    }

    public void onClick_DynamicFragments(View view) {
        Intent intent = new Intent(MainActivity.this, DynamicFragmentsActivity.class);
        startActivity(intent);
    }

    public void onClick_Orientation(View view) {
        Intent intent = new Intent(MainActivity.this, OrientationActivity.class);
        startActivity(intent);
    }

    public void onClick_BroadcastReceiver(View view) {
        Intent intent = new Intent(MainActivity.this, BroadcastActivity.class);
        startActivity(intent);
    }

    public void onClick_PersistentBroadcastReceiver(View view) {
        Intent intent = new Intent(MainActivity.this, PersistentBroadcastActivity.class);
        startActivity(intent);
    }

    public void onClick_SeekBar(View view) {
        Intent intent = new Intent(MainActivity.this, SeekBarActivity.class);
        startActivity(intent);
    }
}
