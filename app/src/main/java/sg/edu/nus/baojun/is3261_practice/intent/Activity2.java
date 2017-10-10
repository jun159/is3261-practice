package sg.edu.nus.baojun.is3261_practice.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import sg.edu.nus.baojun.is3261_practice.R;

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = new Intent();
        intent.putExtra(IntentActivity.KEY_DOZEN, 12);
        setResult(RESULT_OK, intent);
    }
}
