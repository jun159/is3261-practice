package sg.edu.nus.baojun.is3261_practice.fragmentcommunication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import sg.edu.nus.baojun.is3261_practice.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment1.OnFragmentOneInteractionListener} interface
 * to handle interaction events.
 */
public class Fragment1 extends Fragment {

    private OnFragmentOneInteractionListener mListener;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Interface to be used within activity
        // Method declared in activity, activity tells fragment what to do
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        Button button = (Button) view.findViewById(R.id.button_fragment_1);

        // Fragment ONE pass to fragment TWO upon click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.fromFragmentOneToTwo("I am from fragment ONE");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentOneInteractionListener) {
            mListener = (OnFragmentOneInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentOneInteractionListener {
        void fromFragmentOneToTwo(String str);
    }
}
