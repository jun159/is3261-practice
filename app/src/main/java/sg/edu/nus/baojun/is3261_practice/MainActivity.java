package sg.edu.nus.baojun.is3261_practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import sg.edu.nus.baojun.is3261_practice.intent.IntentActivity;
import sg.edu.nus.baojun.is3261_practice.sqlite.SQLite;

public class MainActivity extends Activity {

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
}
