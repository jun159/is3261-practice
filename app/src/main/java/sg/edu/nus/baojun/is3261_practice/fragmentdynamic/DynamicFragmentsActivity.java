package sg.edu.nus.baojun.is3261_practice.fragmentdynamic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import sg.edu.nus.baojun.is3261_practice.R;

public class DynamicFragmentsActivity extends AppCompatActivity
            implements Fragment1.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragments);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction;

        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment1 fragment1 = new Fragment1();
        fragmentTransaction.add(R.id.frameLayout1, fragment1);
        fragmentTransaction.commit();

        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment2 fragment2 = new Fragment2();
        fragmentTransaction.add(R.id.frameLayout2, fragment2);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(String str) {
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}
