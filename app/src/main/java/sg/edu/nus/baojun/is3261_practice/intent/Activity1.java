package sg.edu.nus.baojun.is3261_practice.intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import sg.edu.nus.baojun.is3261_practice.R;

public class Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        int nPlayers = getIntent().getIntExtra(IntentActivity.KEY_NPLAYERS, 0);
        String sports = getIntent().getStringExtra(IntentActivity.KEY_SPORTS);

        // OR
//        int nPlayers = getIntent().getExtras().getInt(IntentActivity.KEY_NPLAYERS);
//        String sports = getIntent().getExtras().getString(IntentActivity.KEY_SPORTS);

        Toast.makeText(this, "Number of Volleyball Players = " + nPlayers, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Sports : " + sports, Toast.LENGTH_SHORT).show();
    }
}
