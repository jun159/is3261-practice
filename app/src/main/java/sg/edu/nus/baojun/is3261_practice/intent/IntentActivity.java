package sg.edu.nus.baojun.is3261_practice.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import sg.edu.nus.baojun.is3261_practice.R;

public class IntentActivity extends Activity {

    public static final String KEY_NPLAYERS = "NPlayers";
    public static final String KEY_SPORTS = "Sports";
    public static final String KEY_DOZEN = "dozen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    // Main pass data to Activity1 using INTENT
    public void onClick_PassFromMainToNewWithIntent(View view) {
        Intent intent = new Intent(IntentActivity.this, Activity1.class);
        intent.putExtra(KEY_NPLAYERS, 6);
        intent.putExtra(KEY_SPORTS, "Volleyball");
        startActivity(intent);
    }

    // Main pass data to Activity2 using BUNDLE
    public void onClick_PassFromMainToNewWithBundle(View view) {
        Bundle bundleObject = new Bundle();
        bundleObject.putInt(KEY_NPLAYERS, 6);
        bundleObject.putString(KEY_SPORTS, "Volleyball");

        Intent intent = new Intent(IntentActivity.this, Activity1.class);
        intent.putExtras(bundleObject);
        startActivity(intent);
    }

    // (1) Main request data from Activity3
    public void onClick_MainRequestFromNewAndNewPassBackToMain(View view) {
        int requestCode = 1;
        Intent intent = new Intent(IntentActivity.this, Activity2.class);
        startActivityForResult(intent, requestCode);
    }

    // (2) Activity3 returns data
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                int dozen = data.getIntExtra(KEY_DOZEN, 0);
                Toast.makeText(this, "a dozen = " + dozen, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
