package sg.edu.nus.baojun.is3261_practice.fragmentcommunication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sg.edu.nus.baojun.is3261_practice.R;

public class FragmentCommunicationActivity extends AppCompatActivity
    implements Fragment1.OnFragmentOneInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);

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
    public void fromFragmentOneToTwo(String str) {
        // Pass from Fragment ONE to Fragment TWO
        Fragment2 fragment2 = (Fragment2) getFragmentManager().findFragmentById(R.id.frameLayout2);
        fragment2.getTextFromOne(str);
    }
}
