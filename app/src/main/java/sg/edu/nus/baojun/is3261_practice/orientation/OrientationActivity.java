package sg.edu.nus.baojun.is3261_practice.orientation;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

import sg.edu.nus.baojun.is3261_practice.R;

public class OrientationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction;

        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        fragmentTransaction.add(R.id.frameLayout1, fragment1);
        fragmentTransaction.commit();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentTransaction = fragmentManager.beginTransaction();
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.add(R.id.frameLayout2, fragment2);
            fragmentTransaction.commit();
        }
    }
}
