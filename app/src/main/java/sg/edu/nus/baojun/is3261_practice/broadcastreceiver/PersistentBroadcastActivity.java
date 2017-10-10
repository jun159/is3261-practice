package sg.edu.nus.baojun.is3261_practice.broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import sg.edu.nus.baojun.is3261_practice.R;

public class PersistentBroadcastActivity extends Activity {

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
