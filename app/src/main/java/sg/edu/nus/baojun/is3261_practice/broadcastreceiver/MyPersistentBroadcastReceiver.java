package sg.edu.nus.baojun.is3261_practice.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Declare persistent broadcast receiver in manifest
 * Any button that uses channel "SOC_Students" will call the toast below
 */

public class MyPersistentBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String key = "rojak";
        Toast.makeText(context, "PersistentReceiver: broadcast message 1 = "
                        + intent.getStringExtra(key),
                Toast.LENGTH_LONG ).show();
    }
}