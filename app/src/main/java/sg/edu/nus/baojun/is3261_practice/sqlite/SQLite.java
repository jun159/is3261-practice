package sg.edu.nus.baojun.is3261_practice.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sg.edu.nus.baojun.is3261_practice.R;

public class SQLite extends Activity {

    private EditText editId;
    private EditText editFurniture;
    private EditText editClass;

    private TextView textResult;
    private MyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        db = new MyDB(this);
        textResult = (TextView) findViewById(R.id.text_result);

        editId = (EditText) findViewById(R.id.edit_id);
        editFurniture = (EditText) findViewById(R.id.edit_furniture);
        editClass = (EditText) findViewById(R.id.edit_class);
        displayResult();
    }

    public ArrayList<String[]> getAllRecords() {
        db.open();
        Cursor cursor = db.getAllRecords();
        ArrayList<String[]> records = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String[] record = {
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2)};
                records.add(record);
            } while (cursor.moveToNext());
        }

        db.close();
        return records;
    }

    public void displayResult() {
        String result = "";

        ArrayList<String[]> myRecords = getAllRecords();
        for (int i = 0; i < myRecords.size(); i++) {
            String[] myRecord = myRecords.get(i);
            result += myRecord[0] + " " + myRecord[1] + " " + myRecord[2] + "\n";
        }

        textResult.setText(result);
    }

    public void onClick_AddRecord(View view) {
        String furniture = editFurniture.getText().toString().trim();
        String classification = editClass.getText().toString().trim();

        if(!furniture.isEmpty() && !classification.isEmpty()) {
            db.open();
            db.insertRecord(furniture, classification);
            displayResult();
            db.close();
        } else {
            Toast.makeText(this, "Please give the correct input.", Toast.LENGTH_LONG).show();
        }
    }

    public void onClick_UpdateRecord(View view) {
        String furniture = editFurniture.getText().toString();
        String classification = editClass.getText().toString();

        db.open();

        if(!furniture.isEmpty()) {
            db.updateRecordGivenFurniture(furniture, classification);
        }

        if(!classification.isEmpty()) {
            db.updateRecordGivenClassification(furniture, classification);
        }

        displayResult();

        db.close();
    }

    public void onClick_DeleteRecord(View view) {
        String id = editId.getText().toString();
        String furniture = editFurniture.getText().toString();
        String classification = editClass.getText().toString();

        db.open();

        if(!id.isEmpty()) {
            db.deleteRecordGivenId(id);
        }

        if(!furniture.isEmpty()) {
            db.deleteRecordGivenFurniture(furniture);
        }

        if(!classification.isEmpty()) {
            db.deleteRecordGivenClassification(classification);
        }

        displayResult();

        db.close();
    }

    public void onClick_DeleteAllRecords(View view) {
        db.open();
        db.deleteAllRecords();
        db.close();
        textResult.setText("");
    }
}