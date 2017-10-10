package sg.edu.nus.baojun.is3261_practice.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static sg.edu.nus.baojun.is3261_practice.sqlite.MyDBHelper.TABLE_NAME;

/**
 * CRUD Functions
 */

public class MyDB {

    private MyDBHelper dbHelper;
    private SQLiteDatabase db;
    private Context context;

    public MyDB(Context ctx) {
        this.context = ctx;
        dbHelper = new MyDBHelper(this.context);
    }

    public MyDB open() {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    // CREATE
    public void insertRecord(String furniture, String classification) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(MyDBHelper.COLUMN_NAME_FURNITURE, furniture);
        initialValues.put(MyDBHelper.COLUMN_NAME_CLASS, classification);
        db.insert(TABLE_NAME, null, initialValues);
    }

    // READ
    public Cursor getRecord(long id) {
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{
                        MyDBHelper.COLUMN_NAME_ID,
                        MyDBHelper.COLUMN_NAME_FURNITURE,
                        MyDBHelper.COLUMN_NAME_CLASS},
                MyDBHelper.COLUMN_NAME_ID + "=" + id,
                null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }

    // READ ALL
    public Cursor getAllRecords() {
        return db.query(
                TABLE_NAME,
                new String[]{
                        MyDBHelper.COLUMN_NAME_ID,
                        MyDBHelper.COLUMN_NAME_FURNITURE,
                        MyDBHelper.COLUMN_NAME_CLASS},
                null, null, null, null, null);

    }

    // UPDATE GIVEN FURNITURE, update classification
    public void updateRecordGivenFurniture(String furniture, String classification) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(MyDBHelper.COLUMN_NAME_CLASS, classification);
        db.update(TABLE_NAME, initialValues,
                MyDBHelper.COLUMN_NAME_FURNITURE + "=?", new String[]{furniture});
    }

    // UPDATE GIVEN CLASSIFICATION, update furniture
    public void updateRecordGivenClassification(String furniture, String classification) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(MyDBHelper.COLUMN_NAME_FURNITURE, furniture);
        db.update(TABLE_NAME, initialValues,
                MyDBHelper.COLUMN_NAME_CLASS + "=?", new String[]{classification});
    }

    // DELETE GIVEN ID
    public void deleteRecordGivenId(String id) {
        db.delete(TABLE_NAME, MyDBHelper.COLUMN_NAME_ID + "=" +
                id, null);
    }

    // DELETE GIVEN FURNITURE
    public void deleteRecordGivenFurniture(String furniture) {
        db.delete(TABLE_NAME,
                MyDBHelper.COLUMN_NAME_FURNITURE + "=?", new String[] {furniture});
    }

    // DELETE GIVEN CLASSIFICATION
    public void deleteRecordGivenClassification(String classification) {
        db.delete(TABLE_NAME,
                MyDBHelper.COLUMN_NAME_CLASS + "=?", new String[] {classification});
    }

    // DELETE ALL
    public void deleteAllRecords() {
        db.execSQL("delete from " + TABLE_NAME);
        // Reset primary key id
        db.execSQL("update sqlite_sequence set seq = 0 where name = \'" + TABLE_NAME + "\'");
    }
}