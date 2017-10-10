package sg.edu.nus.baojun.is3261_practice.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Create Database
 */

public class MyDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "yourDBName";

    public static final String TABLE_NAME = "yourTableName";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_FURNITURE = "furniture";
    public static final String COLUMN_NAME_CLASS = "classification";

    private static final String SQLITE_CREATE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME_FURNITURE + " TEXT NOT NULL,"
                    + COLUMN_NAME_CLASS + " TEXT NOT NULL);";

    private static final String SQLITE_DELETE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLITE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLITE_DELETE);
        onCreate(db);
    }
}