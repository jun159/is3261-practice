package sg.edu.nus.baojun.is3261_practice.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Declare broadcast receiver in activity you want to use
 * Actvity will call the toast below
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String key = "rojak";
        Toast.makeText(context, key + " is " + intent.getStringExtra(key) + "!",
                Toast.LENGTH_LONG).show();
    }
}
