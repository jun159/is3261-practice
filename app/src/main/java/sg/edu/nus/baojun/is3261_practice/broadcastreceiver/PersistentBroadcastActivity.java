package sg.edu.nus.baojun.is3261_practice.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sg.edu.nus.baojun.is3261_practice.R;

public class PersistentBroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistent_broadcast);

        // Call persistent receiver
        Intent intent = new Intent("SOC_Students");
        intent.putExtra("rojak", "delicious");
        sendBroadcast(intent);
    }
}
