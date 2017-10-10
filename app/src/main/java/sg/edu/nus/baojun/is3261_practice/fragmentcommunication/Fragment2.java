package sg.edu.nus.baojun.is3261_practice.fragmentcommunication;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sg.edu.nus.baojun.is3261_practice.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    private TextView textView;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        textView = (TextView) view.findViewById(R.id.text);
        return view;
    }

    // Get from fragment ONE
    public void getTextFromOne(String text){
        textView.setText(text);
    }
}
