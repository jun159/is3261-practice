package sg.edu.nus.baojun.is3261_practice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

public class SeekBarActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar seekBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        seekBar1 = (SeekBar)findViewById(R.id.seekBar);
        seekBar1.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Toast.makeText(getApplicationContext(), "Seekbar progress: " + progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(), "Seekbar touch started!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(), "Seekbar touch stopped!", Toast.LENGTH_SHORT).show();
    }
}
