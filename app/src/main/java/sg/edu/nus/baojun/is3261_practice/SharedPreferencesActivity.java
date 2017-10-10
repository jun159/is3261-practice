package sg.edu.nus.baojun.is3261_practice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class SharedPreferencesActivity extends AppCompatActivity {

    public static final String SHAREDPREF_NAME = "sg.edu.nus.baojun";

    public static final String KEY_SCHOOL = "School";
    public static final String VALUE_SCHOOL = "NUS";

    public static final String KEY_STUDENTS = "NumOfStudents";
    public static final int VALUE_STUDENTS = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
    }

    // CREATE/UPDATE KEY-VALUE
    public void onClick_SaveKeyValue(View view) {
        SharedPreferences.Editor editor =
                getSharedPreferences(SHAREDPREF_NAME, MODE_PRIVATE).edit();

        editor.putString(KEY_SCHOOL, VALUE_SCHOOL);
        editor.putInt(KEY_STUDENTS, VALUE_STUDENTS);
        editor.commit();
    }

    // READ ALL KEY-VALUE
    public void onClick_RetrieveKeyValue(View view) {
        SharedPreferences prefs = getSharedPreferences(SHAREDPREF_NAME, MODE_PRIVATE);
        String text = prefs.getString(KEY_SCHOOL, null);

        if (text != null) {
            String school = prefs.getString(KEY_SCHOOL, "default school name");
            int nStudents = prefs.getInt(KEY_STUDENTS, 0);

            Toast.makeText(this,
                    KEY_SCHOOL + " = " + school + ", " +
                    KEY_STUDENTS + " = " + nStudents,
                    Toast.LENGTH_SHORT).show();
        }
    }

    // DELETE A RECORD GIVEN KEY
    public void onClick_DeleteKeyValue(View view) {
        SharedPreferences prefs = getSharedPreferences(SHAREDPREF_NAME, MODE_PRIVATE);
        prefs.edit().remove(KEY_STUDENTS).commit();
    }

    // DELETE ALL
    public void onClick_DeleteAllKeyValue(View view) {
        SharedPreferences prefs = getSharedPreferences(SHAREDPREF_NAME, MODE_PRIVATE);
        prefs.edit().clear().commit();
    }
}
